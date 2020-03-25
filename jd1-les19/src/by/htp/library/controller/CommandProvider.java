package by.htp.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.library.controller.impl.AddNewBook;
import by.htp.library.controller.impl.AuthorizationCommand;
import by.htp.library.controller.impl.ChangeUserStatusCommand;
import by.htp.library.controller.impl.EditBook;
import by.htp.library.controller.impl.RegistrationCommand;

public class CommandProvider {

	private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();
	
	public CommandProvider() {
		commands.put(CommandName.REGISTRATION, new RegistrationCommand());
		commands.put(CommandName.AUTHORIZATION, new AuthorizationCommand());
		commands.put(CommandName.ADD_NEW_BOOK, new AddNewBook());
		commands.put(CommandName.EDIT_BOOK, new EditBook());
		commands.put(CommandName.CHANGE_USER_STATUS, new ChangeUserStatusCommand());
	}
	
	
	public Command getCommand(String strCommandName) {
		CommandName commandName;
		Command command;
		
		commandName = CommandName.valueOf(strCommandName.toUpperCase());
		command = commands.get(commandName);
		
		return command;
	}
}
