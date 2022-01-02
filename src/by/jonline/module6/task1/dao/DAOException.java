package by.jonline.module6.task1.dao;

public class DAOException extends Exception {

	private static final long serialVersionUID = 1031847059109199548L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}

}
