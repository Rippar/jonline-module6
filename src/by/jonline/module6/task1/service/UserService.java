package by.jonline.module6.task1.service;


public interface UserService {
	
	boolean authorization(String login, String password) throws ServiceException;
	
	boolean registration(String name, String surname, String email, String password) throws ServiceException;

}
