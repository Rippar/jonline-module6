package by.jonline.module6.task1.service.impl;

import by.jonline.module6.task1.dao.DAOException;
import by.jonline.module6.task1.dao.DAOProvider;
import by.jonline.module6.task1.dao.UserDAO;
import by.jonline.module6.task1.service.ServiceException;
import by.jonline.module6.task1.service.UserService;

public class UserServiceImpl implements UserService {

	private final DAOProvider provider = DAOProvider.getInstance();

	@Override
	public boolean authorization(String login, String password) throws ServiceException {

		// логин представляет собой e-mail пользователя
		String regexForLogin = "(\\w{6,})@(\\w+\\.)([a-z]{2,4})";

		// пароль должен содержать как минимум одну букву верхнего регистра, одну
		// нижнего и одну цифру и быть длиной от 6 до 10 символов
		String regexForPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,10}$";

		if (login.matches(regexForLogin) && password.matches(regexForPassword)) {
			UserDAO userDAO = provider.getUserDAO();

			try {
				return userDAO.authorization(login, password);

			} catch (DAOException e) {
				throw new ServiceException(e);
			}

		} else {
			return false;
		}

	}

	@Override
	public void registration(String name, String surname, String email, String password) throws ServiceException {

		String regexForPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,10}$";

		if (password.matches(regexForPassword)) {
			UserDAO userDAO = provider.getUserDAO();

			try {
				userDAO.registration(name, surname, email, password);

			} catch (DAOException e) {
				throw new ServiceException(e);
			}

		} else {
			// ??какой-нибудь вывод в view что не удалось зарегаться из-за неподходящего
			// пароля
		}
	}

}
