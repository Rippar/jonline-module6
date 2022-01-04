package by.jonline.module6.task1.controller.impl;

import by.jonline.module6.task1.controller.Command;
import by.jonline.module6.task1.presentation.UserActionViewer;
import by.jonline.module6.task1.service.BookService;
import by.jonline.module6.task1.service.ServiceException;
import by.jonline.module6.task1.service.ServiceProvider;

public class DeleteBookCommand implements Command {

	@Override
	public String execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();

		boolean result;

		try {
			result = bookService.deleteBook(Integer.parseInt(params[1]));
			
		} catch (NumberFormatException | ServiceException e) {
			// logging(e)
			
			return "Error";
		}

		String response = UserActionViewer.deleteBookAnswer(result);

		return response;
	}

}
