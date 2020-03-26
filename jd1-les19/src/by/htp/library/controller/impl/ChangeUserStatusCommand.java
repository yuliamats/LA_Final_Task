package by.htp.library.controller.impl;

import by.htp.library.controller.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;
import by.htp.library.service.UserService;

public class ChangeUserStatusCommand implements Command {

	@Override
	public String execute(String request) {
		String response;

		int idUser;
		String newStatus;

		String[] params;
		params = request.split(" ");

		idUser = Integer.parseInt(params[0].split("=")[1]);
		newStatus = params[1].split("=")[1];

		UserService service = ServiceProvider.getInstance().getUserService();
		try {
			boolean result;
			result = service.changeUserStatus(idUser, newStatus);
			if (result) {
				response = "user's status is changed";
			} else {
				response = "try again";
			}
		} catch (ServiceException e) {
			// log
			response = "error!";
		}
		return response;
	}

}
