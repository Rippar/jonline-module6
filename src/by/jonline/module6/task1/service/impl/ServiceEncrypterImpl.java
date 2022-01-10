package by.jonline.module6.task1.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import by.jonline.module6.task1.service.ServiceEncrypter;
import by.jonline.module6.task1.service.ServiceException;

public class ServiceEncrypterImpl implements ServiceEncrypter {
	
	private MessageDigest md;

	public String getEncrypted(String pass) throws ServiceException {

		try {
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			throw new ServiceException(e);
		}

	}

}
