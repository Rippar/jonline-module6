package by.jonline.module6.task1.controller;

import java.util.HashMap;
import java.util.Map;

import by.jonline.module6.task1.controller.impl.AddBookCommand;
import by.jonline.module6.task1.controller.impl.AuthorizationCommand;
import by.jonline.module6.task1.controller.impl.CheckBooksCommand;
import by.jonline.module6.task1.controller.impl.DeleteBookCommand;
import by.jonline.module6.task1.controller.impl.RegistrationCommand;

public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("authorization", new AuthorizationCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("addBook", new AddBookCommand());
		commands.put("deleteBook", new DeleteBookCommand());
		commands.put("checkBooks", new CheckBooksCommand());
		
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}

}
