package by.htp.library.service.impl;

import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.DaoProvider;
import by.htp.library.dao.UserDao;
import by.htp.library.service.ServiceException;
import by.htp.library.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public boolean authorization(String login, String password) throws ServiceException {
		if (login == null || login.isEmpty()) {
			throw new RuntimeException("error");// stub
		}
		boolean result;

		DaoProvider provider = DaoProvider.getInstance();
		UserDao userDao = provider.getUserDao();
		try {
			result = userDao.authorization(login, password);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;

	}

	@Override
	public void registration(User user) throws ServiceException {
		if (user.getLogin() == null || user.getLogin().isEmpty() || user.getPassword() == null
				|| user.getPassword().isEmpty()) {
			throw new RuntimeException("error");// stub
		}
		boolean result;

		DaoProvider provider = DaoProvider.getInstance();
		UserDao userDao = provider.getUserDao();
		try {
			result = userDao.registration(user);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean changeUserStatus(int idUser, String newStatus) throws ServiceException {
		if (newStatus == null || newStatus.isEmpty()) {
			throw new RuntimeException("error");// stub
		}
		boolean result;

		DaoProvider provider = DaoProvider.getInstance();
		UserDao userDao = provider.getUserDao();
		try {
			result = userDao.changeUserStatus(idUser, newStatus);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return result;
	}
}
