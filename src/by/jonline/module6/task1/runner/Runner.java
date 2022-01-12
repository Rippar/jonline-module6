package by.jonline.module6.task1.runner;

import by.jonline.module6.task1.controller.impl.UserController;

// super admin dmitrymurzo1@gmail.com 1997rillJ2

// request "authorization  login password"
// request "registration name surname email password"

// request "addBook masterKey title author publishingHouse yearOfPublishing pages isElectronic"
// request "checkBooks filePath"
// request "deleteBook masterKey bookID"

public class Runner {

	public static void main(String[] args) {

		UserController controller = new UserController();
		UserDataInput input = new UserDataInput();

		while (true) {
			String command = input.enterFromConsole("\nВведите команду. Введите esc для выхода: ");

			if (command.equals("esc")) {
				break;
			}

			String response = controller.doAction(command);

			String[] params = response.split("\\s+");

			if (params[0].equals("1")) {
				
				if(params[1].equals("checkBooks")) {
					System.out.println(response);
					continue;
				}
				System.out.println(params[1] + " " + params[2]);
				continue;
				
			} else if (params[0].equals("0")) {
				System.out.println(params[1] + " " + params[2]);
				continue;
				
			} else if (response.equals("MasterKey is needed")) {
				System.out.println("Требуется пароль администратора для выполнения действия.");
				
			} else {
				System.out.println(params[0]);
				continue;
			}
		}

	}

}
