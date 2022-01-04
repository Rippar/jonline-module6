package by.jonline.module6.task1.controller.impl;

import java.util.List;

import by.jonline.module6.task1.bean.Book;
import by.jonline.module6.task1.controller.Command;
import by.jonline.module6.task1.presentation.UserActionViewer;
import by.jonline.module6.task1.service.BookService;
import by.jonline.module6.task1.service.ServiceException;
import by.jonline.module6.task1.service.ServiceProvider;

public class CheckBooksCommand implements Command {

	@Override
	public String execute(String[] params) {
		
		ServiceProvider provider = ServiceProvider.getInstance();
		BookService bookService = provider.getBookService();

		List<Book> result;

		try {
			result = bookService.checkBooks(params[1]);

		} catch (ServiceException e) {
			// logging(e)
			return "Error";
		}

		String response = UserActionViewer.checkBooksAnswer(result);

		return response;
	}

}
