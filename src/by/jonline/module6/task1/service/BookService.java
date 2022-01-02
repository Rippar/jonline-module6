package by.jonline.module6.task1.service;

import java.util.List;

import by.jonline.module6.task1.bean.Book;


public interface BookService {

	boolean addBook(String title, String author, String publishingHouse, int yearOfPublishing, int pages, boolean isElectronic) throws ServiceException;

	boolean deleteBook(Book book) throws ServiceException;

	List<Book> checkBooks(String path) throws ServiceException;

}
