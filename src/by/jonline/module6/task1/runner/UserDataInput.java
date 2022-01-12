package by.jonline.module6.task1.runner;

import java.util.Scanner;

public class UserDataInput {
	public String enterFromConsole(String message) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}

}
