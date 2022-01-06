package by.jonline.module6.task1.runner;

import by.jonline.module6.task1.controller.impl.UserController;

public class Runner {

	public static void main(String[] args) {

		UserController controller = new UserController();

		String command0 = "authorization dmitrymurzo1@gmail.com 1997rillJ2"; // ввод с консоли

		String response0 = controller.doAction(command0);
		String[] params0 = response0.split("\\s+");

		if (params0[0].equals("1")) {
			String command1 = "deleteBook 1997rillJ2 2"; // ввод с консоли
			String response1 = controller.doAction(command1);

			if (response1.equals("MasterKey is needed")) {
				System.out.println("Требуется пароль администратора для выполнения действия.");

			} else if (params0[0].equals("Error")) {
				System.out.println("Произошла ошибка запроса.");

			} else {
				System.out.println(response1);
			}

		} else if (params0[0].equals("Error")) {
			System.out.println("Произошла ошибка запроса.");

		} else {
			System.out.println("команда не распознана. Попробуйте снова.");
		}

	}

}
