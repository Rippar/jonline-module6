package by.jonline.module6.task1.bean;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -157337258995588808L;

	private static int count;

	private final int id;
	private String name;
	private String surname;
	private String email;
	private boolean isSuperuser;

	public User() {
		id = count++;
	}

	public User(String name, String surname, String email, boolean isSuperuser) {
		id = count++;

		this.name = name;
		this.surname = surname;
		this.email = email;
		this.isSuperuser = isSuperuser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSuperuser() {
		return isSuperuser;
	}

	public void setSuperuser(boolean isSuperuser) {
		this.isSuperuser = isSuperuser;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + (isSuperuser ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (isSuperuser != other.isSuperuser)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", isSuperuser=" + isSuperuser;
	}

}
