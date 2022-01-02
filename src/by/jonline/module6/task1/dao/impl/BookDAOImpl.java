package by.jonline.module6.task1.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.jonline.module6.task1.bean.Book;
import by.jonline.module6.task1.dao.BookDAO;
import by.jonline.module6.task1.dao.DAOException;

public class BookDAOImpl implements BookDAO {

	@Override
	public boolean addBook(String title, String author, String publishingHouse, int yearOfPublishing, int pages, boolean isElectronic) throws DAOException {

		boolean result = false;
		
		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("src/by/jonline/module6/task1/source/BookCatalog.txt"))) {
			
			//подумать над тем, чтобы созданный объект book также где-то хранился
			Book book = new Book(title, author, publishingHouse, yearOfPublishing, pages, isElectronic);
			
			writer.write(book.getId()+ " ");
			writer.write(book.getTitle() + " ");
			writer.write(book.getAuthor() + " ");
			writer.write(book.getPublishingHouse() + " ");
			writer.write(book.getYearOfPublishing() + " ");
			writer.write(book.getPages() + " ");
			writer.write(book.isElectronic() + "\n");
			
			result = true;

		} catch (IOException e) {
			throw new DAOException(e);
		}
		
		return result;

	}

	@Override
	public boolean deleteBook(Book book) throws DAOException {

		try (BufferedReader reader = new BufferedReader(
				new FileReader("src/by/jonline/module6/task1/source/BookCatalog.txt"))) {

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] params = line.split("\\s+");
				if (params[0].equals(book.getTitle()) && params[1].equals(book.getAuthor())
						&& params[2].equals(book.getPublishingHouse())
						&& Integer.parseInt(params[3]) == (book.getYearOfPublishing())
						&& Integer.parseInt(params[4]) == book.getPages()
						&& Boolean.parseBoolean(params[5]) == book.isElectronic()) {
					return true;
				}
			}

		} catch (IOException e) {
			throw new DAOException(e);
		}
		return false;

	}

	@Override
	public List<Book> checkBooks(String path) throws DAOException {

		List<Book> books = new ArrayList<Book>();

		try (BufferedReader reader = new BufferedReader(
				new FileReader("src/by/jonline/module6/task1/source/BookCatalog.txt"))) {

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] params = line.split("\\s+");
				Book book = new Book(params[0], params[1], params[2], Integer.parseInt(params[3]),
						Integer.parseInt(params[4]), Boolean.parseBoolean(params[5]));
				books.add(book);
			}

			return books;

		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

}
