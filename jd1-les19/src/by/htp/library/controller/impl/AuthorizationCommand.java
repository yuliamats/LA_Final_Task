package by.htp.library.controller.impl;

import by.htp.library.controller.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;
import by.htp.library.service.UserService;

public class AuthorizationCommand implements Command {

	@Override
	public String execute(String request) {
		String response;

		String login;
		String password;

		String[] params;
		params = request.split(" ");

		login = params[0].split("=")[1];
		password = params[1].split("=")[1];

		UserService service = ServiceProvider.getInstance().getUserService();
		try {
			service.authorization(login, password);
			response = "welcome!";
		} catch (ServiceException e) {
			// log
			response = "error! try adain";
		}
		return response;
	}

}
