package by.jonline.module6.task1.controller.impl;

import by.jonline.module6.task1.controller.Command;
import by.jonline.module6.task1.presentation.UserActionViewer;
import by.jonline.module6.task1.service.ServiceException;
import by.jonline.module6.task1.service.ServiceProvider;
import by.jonline.module6.task1.service.UserService;

public class AuthorizationCommand implements Command {

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		
		boolean result;
		try {
			result = userService.authorization(params[1], params[2]);
		} catch (ServiceException e) {
			// logging(e)
			
			return "Error";
		}
		String response = UserActionViewer.authorizationAnswer(result);
	
		return response;
	}

}
