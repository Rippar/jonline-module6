package by.jonline.module6.task1.runner;

import by.jonline.module6.task1.controller.impl.UserController;
import by.jonline.module6.task1.dao.DAOException;
import by.jonline.module6.task1.dao.Encrypter;

public class Runner {

	public static void main(String[] args) {
		
		UserController controller = new UserController();
			
		String command0 = "authorization dmitrymurzo1@gmail.com 1997rillJ2"; //ввод с консоли
		
		String response0 = controller.doAction(command0);
		String[] params0 = response0.split("\\s+");
		
		if (params0[0].equals("1")) {
			String command1 = "deleteBook 2"; //ввод с консоли
			
			try {
				if(Encrypter.cryptWithMD5(command0.split("\\s+")[2]).equals(controller.cryptedMasterKey)) {
					String response1 = controller.doAction(command1);
					System.out.println(response1);
				} else {
					System.out.println("недостаточно прав доступа");
					
				}
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		} else if(params0[0].equals("Error")) { 
			System.out.println("Произошла ошибка запроса.");
			
		} else {
			System.out.println("команда не распознана. Попробуйте снова.");	
		}
		

	}

}
