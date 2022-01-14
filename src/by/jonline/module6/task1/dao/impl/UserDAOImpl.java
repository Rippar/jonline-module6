package by.jonline.module6.task1.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.jonline.module6.task1.bean.User;
import by.jonline.module6.task1.dao.DAOException;
import by.jonline.module6.task1.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	private List<User> users = null;

	@Override
	public boolean authorization(String login, String password) throws DAOException {

		boolean result = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(
				"D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/UserInfo.txt"))) {

			String line = null;

			while ((line = reader.readLine()) != null) {

				String[] splitted = line.split("[;]+");
				String[] params = new String[splitted.length];

				for (int i = 0; i < splitted.length; i++) {
					String[] tmp = splitted[i].split("[:]+");
					params[i] = tmp[1].trim();

				}

				if (params[3].equals(login) && params[4].equals(password)) {
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

		if (users == null) {

			try (BufferedReader reader = new BufferedReader(new FileReader(
					"D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/UserInfo.txt"))) {

				users = new ArrayList<User>();
				String line = null;

				while ((line = reader.readLine()) != null) {

					String[] splitted = line.split("[;]+");
					String[] params = new String[splitted.length];

					for (int i = 0; i < splitted.length; i++) {
						String[] tmp = splitted[i].split("[:]+");
						params[i] = tmp[1].trim();

					}

					users.add(new User(params[1], params[2], params[3]));

				}

			} catch (IOException e) {
				throw new DAOException(e);
			}

		}

		boolean result = false;

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(
				"D:/Programming/Workspace/jonline-module6/src/by/jonline/module6/task1/source/UserInfo.txt", true))) {

			User user = new User(name, surname, email);
			users.add(user);
			writer.write("id: " + user.getId() + "; имя: " + user.getName() + "; фамилия: " + user.getSurname()
					+ "; email: " + user.getEmail() + "; пароль: " + password + "\n");

			result = true;

		} catch (IOException e) {
			throw new DAOException(e);
		}

		return result;

	}

}
