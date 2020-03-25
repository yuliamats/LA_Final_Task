package by.htp.library.service.impl;

import by.htp.library.bean.Book;
import by.htp.library.dao.AdminDao;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.DaoProvider;
import by.htp.library.service.BookService;
import by.htp.library.service.ServiceException;

public class BookServiceImpl implements BookService {

	@Override
	public void add(Book book) throws ServiceException {

		if (book.getAuthor() == null || book.getAuthor().isEmpty() || book.getTitle() == null
				|| book.getTitle().isEmpty()) {
			throw new RuntimeException("error");// stub
		}
		boolean result;

		DaoProvider provider = DaoProvider.getInstance();
		AdminDao adminDao = provider.getAdminDao();
		try {
			result = adminDao.add(book);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void edit(int idBook, Book book) throws ServiceException {

		if (book.getAuthor() == null || book.getAuthor().isEmpty() || book.getTitle() == null
				|| book.getTitle().isEmpty()) {
			throw new RuntimeException("error");// stub
		}
		boolean result;

		DaoProvider provider = DaoProvider.getInstance();
		AdminDao adminDao = provider.getAdminDao();
		try {
			result = adminDao.edit(idBook, book);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
