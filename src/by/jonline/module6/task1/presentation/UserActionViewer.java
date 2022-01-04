package by.jonline.module6.task1.presentation;

import java.util.List;

import by.jonline.module6.task1.bean.Book;

public class UserActionViewer {
	public static String authorizationAnswer(boolean result) {

		if (result) {
			return "1 authorization success";
		} else {
			return "0 authorization failure";
		}
	}

	public static String registrationAnswer(boolean result) {

		if (result) {
			return "1 registration success";
		} else {
			return "0 registration failure";
		}
	}

	public static String addBookAnswer(boolean result) {

		if (result) {
			return "1 addBook success";
		} else {
			return "0 addBook failure";
		}
	}
	
	public static String deleteBookAnswer(boolean result) {

		if (result) {
			return "1 deleteBook success";
		} else {
			return "0  deleteBook failure";
		}
	}

	public static String checkBooksAnswer(List<Book> result) {

		if (result != null) {

			StringBuilder response = new StringBuilder("1 checkBooks success \n");

			for (Book book : result) {
				response.append("id:" + book.getId() + "; название книги: " + book.getTitle() + "; автор: "
						+ book.getAuthor() + "; издание: " + book.getPublishingHouse() + "; год издания: "
						+ book.getYearOfPublishing() + "; количество страниц: " + book.getPages()
						+ "; электронная книга: " + book.isElectronic() + "\n");

			}

			return response.toString();

		} else {
			return "0 checkBooks failure";
		}
	}

}
