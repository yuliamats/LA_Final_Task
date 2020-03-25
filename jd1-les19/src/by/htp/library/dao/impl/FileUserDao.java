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
import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.UserDao;

public class FileUserDao implements UserDao {
	private static final String USERS_PATH = "D:\\Workspace\\JD\\jd1-les19\\src\\resource\\users.txt";

	@Override
	public boolean authorization(String login, String password) throws DaoException {
		List<User> users;

		try {
			users = readUsersFromFile();
			for (User u : users) {
				if ((u.getLogin().compareTo(login) == 0) && (u.getPassword().compareTo(password) == 0)) {
					return true;
				}
			}
		} catch (DaoException e) {
			throw new DaoException(e);
		}
		return false;
	}

	@Override
	public boolean registration(User newUser) throws DaoException {
		List<User> users;

		String newId;
		String newLine;

		boolean result = false;
		try {
			users = readUsersFromFile();
			for (User u : users) {
				if ((u.getLogin().compareTo(newUser.getLogin()) == 0)
						&& (u.getPassword().compareTo(newUser.getPassword()) == 0)) {
					return result;
				}
			}

		} catch (DaoException e) {
			throw new DaoException(e);
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_PATH, true))) {

			newId = "id=" + String.valueOf((users.size() + 1));
			newLine = newUser.toString().replace("id=0", newId);

			writer.newLine();
			writer.write(newLine);
			result = true;

		} catch (IOException e) {
			throw new DaoException(e);
		}
		return result;
	}

	@Override
	public boolean changeUserStatus(int idUser, String newStatus) throws DaoException {
		List<User> users;

		String editContent = "";
		boolean flag = false;
		boolean result = false;

		try {
			users = readUsersFromFile();
			for (User u : users) {
				if (idUser == u.getId()) {
					flag = true;
				}
			}

			if (flag) {
				for (User u : users) {
					if (idUser == u.getId()) {
						u.setRole(newStatus);
						editContent = editContent + u.toString() + System.lineSeparator();
					} else {
						editContent = editContent + u.toString() + System.lineSeparator();
					}
				}

				try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_PATH))) {
					bw.write(editContent);
					result = true;
				} catch (IOException e) {
					throw new DaoException(e);
				}
			}

		} catch (DaoException e) {
			throw new DaoException(e);
		}

		return result;
	}

	public List<User> readUsersFromFile() throws DaoException {
		List<User> users = new ArrayList<User>();

		int id;
		String login;
		String password;
		String name;
		String surname;
		String role;

		try (BufferedReader reader = new BufferedReader(new FileReader(USERS_PATH))) {
			String line = reader.readLine();
			List<String> lines = new ArrayList<String>();

			while (line != null) {
				lines.add(line);
				line = reader.readLine();
			}

			for (String l : lines) {
				id = Integer.parseInt(l.split(" ")[0].split("=")[1]);
				login = l.split(" ")[1].split("=")[1];
				password = l.split(" ")[2].split("=")[1];
				name = l.split(" ")[3].split("=")[1];
				surname = l.split(" ")[4].split("=")[1];
				role = l.split(" ")[5].split("=")[1];

				User user = new User();
				user.setId(id);
				user.setLogin(login);
				user.setPassword(password);
				user.setName(name);
				user.setSurname(surname);
				user.setRole(role);

				users.add(user);
			}
		} catch (FileNotFoundException e) {
			throw new DaoException(e);
		} catch (IOException e) {
			throw new DaoException(e);
		}

		return users;
	}
}
