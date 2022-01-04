package by.jonline.module6.task1.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.jonline.module6.task1.bean.User;
import by.jonline.module6.task1.dao.DAOException;
import by.jonline.module6.task1.dao.Encrypter;
import by.jonline.module6.task1.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean authorization(String login, String password) throws DAOException {

		boolean result = false;

		try (BufferedReader reader = new BufferedReader(
				new FileReader("src/by/jonline/module6/task1/source/UserInfo.txt"))) {

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] splitted = line.split("[;]+");
				String[] params = new String[splitted.length];

				for (int i = 0; i < splitted.length; i++) {
					String[] tmp = splitted[i].split("[:]+");
					params[i] = tmp[1].trim();

				}

				if (params[4].equals(login) && params[5].equals(Encrypter.cryptWithMD5(password))) {
					result = true;
				}
			}

		} catch (IOException e) {
			throw new DAOException(e);
		}

		return result;

	}

	@Override
	public boolean registration(String name, String surname, String email, String password) throws DAOException {
		
		boolean result = false;

		try (BufferedWriter writer = new BufferedWriter(
				new FileWriter("src/by/jonline/module6/task1/source/UserInfo.txt"))) {

			// подумать над тем, чтобы созданный объект book также где-то хранился
			// default - not superuser
			User user = new User(name, surname, email, false);
			writer.write("id: " + user.getId() + "; имя:" + user.getName() + "; фамилия: " + user.getSurname()
					+ "; администратор: " + user.isSuperuser() + "; email: " + user.getEmail() + "; пароль: "
					+ Encrypter.cryptWithMD5(password) + "\n");
			
			result = true;

		} catch (IOException e) {
			throw new DAOException(e);
		}
		
		return result;

	}

}
