package by.jonline.module6.task1.service.impl;

import java.util.List;

import by.jonline.module6.task1.bean.Book;
import by.jonline.module6.task1.dao.BookDAO;
import by.jonline.module6.task1.dao.DAOException;
import by.jonline.module6.task1.dao.DAOProvider;
import by.jonline.module6.task1.service.BookService;
import by.jonline.module6.task1.service.ServiceException;

public class BookServiceImpl implements BookService {

	private final DAOProvider provider = DAOProvider.getInstance();

	@Override
	public boolean addBook(String title, String author, String publishingHouse, int yearOfPublishing, int pages, boolean isElectronic) throws ServiceException {

		boolean result = false;
		BookDAO bookDAO = provider.getBookDAO();
		
		try {
			bookDAO.addBook(title, author, publishingHouse, yearOfPublishing, pages, isElectronic);
			result = true;
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return result;
	}

	@Override
	public boolean deleteBook(Book book) throws ServiceException {

		BookDAO bookDAO = provider.getBookDAO();
		
		try {
			return bookDAO.deleteBook(book);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Book> checkBooks(String path) throws ServiceException {

		BookDAO bookDAO = provider.getBookDAO();
		
		try {
			return bookDAO.checkBooks(path);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

}