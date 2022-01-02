package by.jonline.module6.task1.controller.impl;

import by.jonline.module6.task1.controller.Command;
import by.jonline.module6.task1.presentation.UserActionViewer;
import by.jonline.module6.task1.service.BookService;
import by.jonline.module6.task1.service.ServiceException;
import by.jonline.module6.task1.service.ServiceProvider;

public class AddBookCommand implements Command{

	@Override
	public String execute(String[] params) {
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();
		
		boolean result;
		
		try {
			result = bookService.addBook(params[1], params[2], params[3], Integer.parseInt(params[4]), Integer.parseInt(params[5]), Boolean.parseBoolean(params[6]));
		} catch (NumberFormatException | ServiceException e) {
			// logging(e)
			
		    return "Error";
		}
		
		String response = UserActionViewer.addBookAnswer(result);
		
		return response;
	}

}
