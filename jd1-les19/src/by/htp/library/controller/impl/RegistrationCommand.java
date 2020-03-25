package by.htp.library.controller.impl;

import by.htp.library.bean.User;
import by.htp.library.controller.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;
import by.htp.library.service.UserService;

public class RegistrationCommand implements Command {

	@Override
	public String execute(String request) {
		String response;

		String login;
		String password;
		String name;
		String surname;

		UserService service = ServiceProvider.getInstance().getUserService();

		String[] params;
		params = request.split(" ");

		login = params[0].split("=")[1];
		password = params[1].split("=")[1];
		name = params[2].split("=")[1];
		surname = params[3].split("=")[1];

		User user = new User(login, password, name, surname);
		try {
			service.registration(user);
			response = "registration OK";
		} catch (ServiceException e) {
			// log
			response = "error! Try again";
		}
		return response;
	}

}
