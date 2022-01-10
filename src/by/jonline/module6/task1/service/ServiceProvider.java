package by.jonline.module6.task1.service;

import by.jonline.module6.task1.service.impl.BookServiceImpl;
import by.jonline.module6.task1.service.impl.ServiceEncrypterImpl;
import by.jonline.module6.task1.service.impl.UserServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();

	private UserService userService = new UserServiceImpl();
	private BookService bookService = new BookServiceImpl();
	private ServiceEncrypter serviceEncrypter = new ServiceEncrypterImpl();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public ServiceEncrypter getServiceEncrypter() {
		return serviceEncrypter;
	}

	public void setServiceEncrypter(ServiceEncrypter serviceEncrypter) {
		this.serviceEncrypter = serviceEncrypter;
	}
	
}
