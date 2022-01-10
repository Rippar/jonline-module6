package by.jonline.module6.task1.controller.impl;

import by.jonline.module6.task1.controller.Command;
import by.jonline.module6.task1.presentation.UserActionViewer;
import by.jonline.module6.task1.service.BookService;
import by.jonline.module6.task1.service.ServiceEncrypter;
import by.jonline.module6.task1.service.ServiceException;
import by.jonline.module6.task1.service.ServiceProvider;

public class AddBookCommand implements Command {

	private final String masterKey = "82c36833cc1c048417088e0f87be0ba";

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();
		ServiceEncrypter serviceEncrypter = provider.getServiceEncrypter();

		boolean result;

		try {
			if (serviceEncrypter.cryptWithMD5(params[1]).equals(masterKey)) {
				result = bookService.addBook(params[2], params[3], params[4], Integer.parseInt(params[5]),
						Integer.parseInt(params[6]), Boolean.parseBoolean(params[7]));
			} else {
				return "MasterKey is needed";
			}

		} catch (NumberFormatException | ServiceException e) {
			// logging(e)

			return "Error";
		}

		String response = UserActionViewer.addBookAnswer(result);

		return response;
	}

}
