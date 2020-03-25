package by.htp.library.service;

import by.htp.library.bean.Book;

public interface BookService {
	void add(Book book) throws ServiceException;
	void edit(int idBook, Book book)  throws ServiceException;
}