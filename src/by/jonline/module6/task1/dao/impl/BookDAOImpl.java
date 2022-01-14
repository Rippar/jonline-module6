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

	private List<Book> books = null;

	@Override
	public boolean addBook(String title, String author, String publishingHouse, int yearOfPublishing, int pages,
			boolean isElectronic) throws DAOException {

		if (books == null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(
					"D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/BookCatalog.txt"))) {

				String line = null;
				books = new ArrayList<Book>();

				while ((line = reader.readLine()) != null) {

					String[] splitted = line.split("[;]+");
					String[] params = new String[splitted.length];

					for (int i = 0; i < splitted.length; i++) {
						String[] tmp = splitted[i].split("[:]+");
						params[i] = tmp[1].trim();

					}

					books.add(new Book(params[1], params[2], params[3], Integer.parseInt(params[4]),
							Integer.parseInt(params[5]), Boolean.parseBoolean(params[6])));
				}

			} catch (IOException e) {
				throw new DAOException(e);
			}
		}

		boolean result = false;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(
				"D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/BookCatalog.txt",
				true))) {

			Book book = new Book(title, author, publishingHouse, yearOfPublishing, pages, isElectronic);
			books.add(book);

			writer.write("id: " + book.getId() + "; название книги: " + book.getTitle() + "; автор: " + book.getAuthor()
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

		if (books == null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(
					"D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/BookCatalog.txt"))) {

				String line = null;
				books = new ArrayList<Book>();

				while ((line = reader.readLine()) != null) {

					String[] splitted = line.split("[;]+");
					String[] params = new String[splitted.length];

					for (int i = 0; i < splitted.length; i++) {
						String[] tmp = splitted[i].split("[:]+");
						params[i] = tmp[1].trim();

					}

					books.add(new Book(params[1], params[2], params[3], Integer.parseInt(params[4]),
							Integer.parseInt(params[5]), Boolean.parseBoolean(params[6])));

				}

			} catch (IOException e) {
				throw new DAOException(e);
			}
		}

		boolean result = false;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(
				"D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/BookCatalog.txt",
				false))) {

			for (Book book : books) {
				if (book.getId() != id) {
					writer.write("id: " + book.getId() + "; название книги: " + book.getTitle() + "; автор: "
							+ book.getAuthor() + "; издание: " + book.getPublishingHouse() + "; год издания: "
							+ book.getYearOfPublishing() + "; количество страниц: " + book.getPages()
							+ "; электронная книга: " + book.isElectronic() + "\n");

				}

			}

			result = true;

		} catch (IOException e) {
			throw new DAOException(e);
		}

		return result;
	}

	@Override
	public List<Book> checkBooks() throws DAOException {

		if (books == null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(
					"D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/BookCatalog.txt"))) {

				String line = null;
				books = new ArrayList<Book>();

				while ((line = reader.readLine()) != null) {

					String[] splitted = line.split("[;]+");
					String[] params = new String[splitted.length];

					for (int i = 0; i < splitted.length; i++) {
						String[] tmp = splitted[i].split("[:]+");
						params[i] = tmp[1].trim();

					}

					books.add(new Book(params[1], params[2], params[3], Integer.parseInt(params[4]),
							Integer.parseInt(params[5]), Boolean.parseBoolean(params[6])));
				}

			} catch (IOException e) {
				throw new DAOException(e);
			}
		}

		return books;
	}

}
