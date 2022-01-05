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
	public boolean addBook(String title, String author, String publishingHouse, int yearOfPublishing, int pages,
			boolean isElectronic) throws DAOException {

		boolean result = false;

		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/BookCatalog.txt", true))) {

			// подумать над тем, чтобы созданный объект book также где-то хранился
			Book book = new Book(title, author, publishingHouse, yearOfPublishing, pages, isElectronic);

			writer.write("id:" + book.getId() + "; название книги: " + book.getTitle() + "; автор: " + book.getAuthor()
					+ "; издание: " + book.getPublishingHouse() + "; год издания: " + book.getYearOfPublishing()
					+ "; количество страниц: " + book.getPages() + "; электронная книга: " + book.isElectronic()
					+ "\n");

			result = true;

		} catch (IOException e) {
			throw new DAOException(e);
		}

		return result;

	}

	@Override
	public boolean deleteBook(int id) throws DAOException {

		List<String> books = new ArrayList<String>();

		boolean result = false;

		try (BufferedReader reader = new BufferedReader(
				new FileReader("D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/BookCatalog.txt"))) {

			String line = null;

			while ((line = reader.readLine()) != null) {
				String[] params = line.split("\\s+");
				String[] tmp = params[1].split(";");
				int currentID = Integer.parseInt(tmp[0]);

				if (currentID != id) {
					books.add(line);
				}

			}

		} catch (IOException e) {
			throw new DAOException(e);
		}

		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/BookCatalog.txt", false))) {

			for (String book : books) {
				writer.write(book + "\n");
			}

			result = true;

		} catch (IOException e) {
			throw new DAOException(e);
		}

		return result;
	}

	@Override
	public List<Book> checkBooks(String path) throws DAOException {

		List<Book> books = new ArrayList<Book>();

		try (BufferedReader reader = new BufferedReader(
				new FileReader("D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/BookCatalog.txt"))) {

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] splitted = line.split("[;]+");
				String[] params = new String[splitted.length];

				for (int i = 0; i < splitted.length; i++) {
					String[] tmp = splitted[i].split("[:]+");
					params[i] = tmp[1].trim();

				}

				books.add(new Book(params[0], params[1], params[2], Integer.parseInt(params[3]),
						Integer.parseInt(params[4]), Boolean.parseBoolean(params[5])));
			}

			return books;

		} catch (IOException e) {
			throw new DAOException(e);
		}
	}

}
