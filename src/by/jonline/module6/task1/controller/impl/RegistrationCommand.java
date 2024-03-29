package by.jonline.module6.task1.controller.impl;

import by.jonline.module6.task1.controller.Command;
import by.jonline.module6.task1.presentation.UserActionViewer;
import by.jonline.module6.task1.service.ServiceException;
import by.jonline.module6.task1.service.ServiceProvider;
import by.jonline.module6.task1.service.UserService;

public class RegistrationCommand implements Command {

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();

		boolean result;

		try {
			result = userService.registration(params[1], params[2], params[3], params[4]);

		} catch (ServiceException e) {
			// logging(e)

			return "Error";
		}

		String response = UserActionViewer.registrationAnswer(result);

		return response;

	}

}
