package by.jonline.module6.task1.controller.impl;

import by.jonline.module6.task1.controller.Command;
import by.jonline.module6.task1.controller.CommandProvider;
import by.jonline.module6.task1.controller.Controller;


public class UserController implements Controller{
	
	public final String cryptedMasterKey = "82c36833cc1c048417088e0f87be0ba";
	private CommandProvider provider = new CommandProvider();

	@Override
	public String doAction(String request) {
		
		String[] params = request.split("\\s+");
		String commandName = params[0];
		
		Command currentCommand = provider.getCommand(commandName);
		
		String response = currentCommand.execute(params);
		
		return response;
	}

}
