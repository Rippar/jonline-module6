package by.jonline.module6.task1.presentation;

public class UserActionViewer {
	public static String authorizationAnswer(boolean result) {
		
		if(result) {
			return "1 success";
		} else {
			return "0 failure";
		}
	}
	
	public static String registrationAnswer(boolean result) {
		
		if(result) {
			return "1 success";
		} else {
			return "0 failure";
		}
	}
	
	public static String addBookAnswer(boolean result) {
		
		if(result) {
			return "1 success";
		} else {
			return "0 failure";
		}
	}

}
