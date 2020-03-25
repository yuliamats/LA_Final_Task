package by.htp.library.controller.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.service.BookService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;

public class EditBook implements Command {

	@Override
	public String execute(String request) {
		String response;

		int id;
		String author;
		String title;
		String publishingHouse;
		int yearPublished;
		int pageCount;
		String status;

		String[] params;
		params = request.split(" ");
		id = Integer.parseInt(params[0].split("=")[1]);
		author = params[1].split("=")[1];
		title = params[2].split("=")[1];
		publishingHouse = params[3].split("=")[1];
		yearPublished = Integer.parseInt(params[4].split("=")[1]);
		pageCount = Integer.parseInt(params[5].split("=")[1]);
		status = params[6].split("=")[1];

		BookService service = ServiceProvider.getInstance().getBookService();

		Book b = new Book(author, title, publishingHouse, yearPublished, pageCount, status);
		try {
			service.edit(id, b);
			response = "book is edited";
		} catch (ServiceException e) {
			// log
			response = "error! Try again";
		}
		return response;
	}
}
