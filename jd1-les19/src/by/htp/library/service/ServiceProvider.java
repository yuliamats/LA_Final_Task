package by.htp.library.service;

import by.htp.library.service.impl.BookServiceImpl;
import by.htp.library.service.impl.UserServiceImpl;

public class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();
	
	private UserService userService = new UserServiceImpl();
	private BookService bookService = new BookServiceImpl();
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}
	
	public BookService getBookService() {
		return bookService;
	}

}
