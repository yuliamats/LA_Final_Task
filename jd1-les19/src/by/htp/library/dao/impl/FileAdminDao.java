package by.htp.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.Book;
import by.htp.library.dao.AdminDao;
import by.htp.library.dao.DaoException;

public class FileAdminDao implements AdminDao {
	private static final String BOOKS_PATH = "D:\\Workspace\\JD\\jd1-les19\\src\\resource\\books.txt";

	@Override
	public boolean add(Book newBook) throws DaoException {
		List<Book> books;

		String newId;
		String newLine;
		
		boolean result = false;

		try {
			books = readBooksFromFile();
			for (Book b : books) {
				if ((b.getAuthor().compareTo(newBook.getAuthor()) == 0)
						&& (b.getTitle().compareTo(newBook.getTitle()) == 0)) {
					return result;
				}
			}
		} catch (DaoException e) {
			throw new DaoException(e);
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOKS_PATH, true))) {
					
			newId = "id=" + String.valueOf((books.size() + 1));
			newLine = newBook.toString().replace("id=0", newId);
			
			writer.newLine();
			writer.write(newLine);
			result = true;
			
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return result;
	}

	@Override
	public boolean edit(int idBook, Book book) throws DaoException {
		List<Book> books;

		String idOfEditBook;
		String editLine = "";
		String oldLine = "";
		String editContent = "";
		String oldContent = "";
		
		
		Boolean result = false;

		idOfEditBook = "id=" + String.valueOf(idBook);
		editLine = book.toString().replace("id=0", idOfEditBook);

		try {
			books = readBooksFromFile();
			for (Book b : books) {
				if (b.getId() == idBook) {
					oldLine = b.toString();
					oldContent = oldContent + b.toString() + System.lineSeparator();
				} else {
					oldContent = oldContent + b.toString() + System.lineSeparator();
				}
			}
		} catch (DaoException e) {
			throw new DaoException(e);
		}

		if (oldLine.isEmpty()) {
			result = false;
		} else {
			editContent = oldContent.replace(oldLine, editLine);
		}

		try (BufferedWriter newWriter = new BufferedWriter(new FileWriter(BOOKS_PATH))) {
			newWriter.write(editContent);
			result = true;
		} catch (IOException e) {
			throw new DaoException(e);
		}

		return result;
	}

	public List<Book> readBooksFromFile() throws DaoException {
		List<Book> books = new ArrayList<Book>();

		int id;
		String author;
		String title;
		String publishingHouse;
		int yearPublished;
		int pageCount;
		String status;

		try (BufferedReader reader = new BufferedReader(new FileReader(BOOKS_PATH))) {
			String line = reader.readLine();
			List<String> lines = new ArrayList<String>();

			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}

			for (String l : lines) {
				id = Integer.parseInt(l.split(" ")[0].split("=")[1]);
				author = l.split(" ")[1].split("=")[1];
				title = l.split(" ")[2].split("=")[1];
				publishingHouse = l.split(" ")[3].split("=")[1];
				yearPublished = Integer.parseInt(l.split(" ")[4].split("=")[1]);
				pageCount = Integer.parseInt(l.split(" ")[5].split("=")[1]);
				status = l.split(" ")[6].split("=")[1];

				Book book = new Book();
				book.setId(id);
				book.setAuthor(author);
				book.setTitle(title);
				book.setPublishingHouse(publishingHouse);
				book.setYearPublished(yearPublished);
				book.setPageCount(pageCount);
				book.setStatus(status);
				books.add(book);
			}
		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return books;
	}

}
