package by.jonline.module6.task1.dao;

public interface UserDAO {
	
	boolean authorization(String login, String password) throws DAOException;
	
	boolean registration(String name, String surname, String email, String password) throws DAOException;

}
