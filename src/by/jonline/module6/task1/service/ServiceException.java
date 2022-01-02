package by.jonline.module6.task1.service;

public class ServiceException extends Exception{

	private static final long serialVersionUID = 1157519562898370580L;
	
	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}
	

}
