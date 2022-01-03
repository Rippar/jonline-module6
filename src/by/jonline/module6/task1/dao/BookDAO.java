package by.jonline.module6.task1.dao;

import java.util.List;

import by.jonline.module6.task1.bean.Book;

public interface BookDAO {
	
	boolean addBook(String title, String author, String publishingHouse, int yearOfPublishing, int pages, boolean isElectronic) throws DAOException;

	boolean deleteBook(int id) throws DAOException;

	List<Book> checkBooks(String path) throws DAOException;

}
