package by.htp.library.controller.impl;

import by.htp.library.bean.Book;
import by.htp.library.controller.Command;
import by.htp.library.service.BookService;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;

public class AddNewBook implements Command {

	@Override
	public String execute(String request) {
		String response;

		String author;
		String title;
		String publishingHouse;
		int yearPublished;
		int pageCount;
		String status;

		String[] params;
		params = request.split(" ");

		author = params[0].split("=")[1];
		title = params[1].split("=")[1];
		publishingHouse = params[2].split("=")[1];
		yearPublished = Integer.parseInt(params[3].split("=")[1]);
		pageCount = Integer.parseInt(params[4].split("=")[1]);
		status = params[5].split("=")[1];

		BookService service = ServiceProvider.getInstance().getBookService();

		Book b = new Book(author, title, publishingHouse, yearPublished, pageCount, status);
		try {
			service.add(b);
			response = "book is added ";
		} catch (ServiceException e) {
			// log
			response = "error! Try again";
		}
		return response;
	}

}
