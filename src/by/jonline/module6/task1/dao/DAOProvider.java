package by.jonline.module6.task1.dao;

import by.jonline.module6.task1.dao.impl.BookDAOImpl;
import by.jonline.module6.task1.dao.impl.UserDAOImpl;

public final class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();

	private UserDAO userDAO = new UserDAOImpl();
	private BookDAO bookDAO = new BookDAOImpl();

	private DAOProvider() {
	}

	public static DAOProvider getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

}
