package by.jonline.module6.task1.bean;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = -8090313237375560704L;

	private static int count;

	private final int id;
	private String title;
	private String author;
	private String publishingHouse;
	private int yearOfPublishing;
	private int pages;
	private boolean isElectronic;

	public Book() {
		id = count++;
	}

	public Book(String title, String author, String publishingHouse, int yearOfPublishing, int pages,
			boolean isElectronic) {
		this.id = count++;

		this.title = title;
		this.author = author;
		this.publishingHouse = publishingHouse;
		this.yearOfPublishing = yearOfPublishing;
		this.pages = pages;
		this.isElectronic = isElectronic;

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public boolean isElectronic() {
		return isElectronic;
	}

	public void setElectronic(boolean isElectronic) {
		this.isElectronic = isElectronic;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + (isElectronic ? 1231 : 1237);
		result = prime * result + pages;
		result = prime * result + ((publishingHouse == null) ? 0 : publishingHouse.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + yearOfPublishing;
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (isElectronic != other.isElectronic)
			return false;
		if (pages != other.pages)
			return false;
		if (publishingHouse == null) {
			if (other.publishingHouse != null)
				return false;
		} else if (!publishingHouse.equals(other.publishingHouse))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearOfPublishing != other.yearOfPublishing)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " id" + id + ", title=" + title + ", author=" + author
				+ ", publishingHouse=" + publishingHouse + ", yearOfPublishing=" + yearOfPublishing + ", pages=" + pages
				+ ", isElectronic=" + isElectronic;
	}

}
