package by.jonline.module6.task1.controller.impl;

import by.jonline.module6.task1.controller.Command;
import by.jonline.module6.task1.dao.DAOException;
import by.jonline.module6.task1.dao.Encrypter;
import by.jonline.module6.task1.presentation.UserActionViewer;
import by.jonline.module6.task1.service.BookService;
import by.jonline.module6.task1.service.ServiceException;
import by.jonline.module6.task1.service.ServiceProvider;

public class DeleteBookCommand implements Command {

	private final String masterKey = "82c36833cc1c048417088e0f87be0ba";

	@Override
	public String execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();

		boolean result;

		try {
			if (Encrypter.cryptWithMD5(params[1]).equals(masterKey)) {
				result = bookService.deleteBook(Integer.parseInt(params[2]));
			} else {
				return "MasterKey is needed";
			}

			// избавиться от DAOException (обернуть как-то на слое service)
		} catch (NumberFormatException | ServiceException | DAOException e) {
			// logging(e)

			return "Error";
		}

		String response = UserActionViewer.deleteBookAnswer(result);

		return response;
	}

}
