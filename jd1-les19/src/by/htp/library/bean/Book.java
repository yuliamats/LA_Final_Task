package by.htp.library.bean;

public class Book {
	private int id;
	private String author;
	private String title;
	private String publishingHouse;
	private int yearPublished;
	private int pageCount;
	private String status;

	public Book() {

	}

	public Book(int id, String author, String title, String publishingHouse, int yearPublished, int pageCount,
			String status) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.publishingHouse = publishingHouse;
		this.yearPublished = yearPublished;
		this.pageCount = pageCount;
		this.status = status;
	}

	public Book(String author, String title, String publishingHouse, int yearPublished, int pageCount,
			String status) {
		super();
		this.id = 0;
		this.author = author;
		this.title = title;
		this.publishingHouse = publishingHouse;
		this.yearPublished = yearPublished;
		this.pageCount = pageCount;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + pageCount;
		result = prime * result + ((publishingHouse == null) ? 0 : publishingHouse.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + yearPublished;
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
		if (pageCount != other.pageCount)
			return false;
		if (publishingHouse == null) {
			if (other.publishingHouse != null)
				return false;
		} else if (!publishingHouse.equals(other.publishingHouse))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearPublished != other.yearPublished)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id=" + id + " author=" + author + " title=" + title + " publishingHouse=" + publishingHouse
				+ " yearPublished=" + yearPublished + " pageCount=" + pageCount + " status=" + status + "";
	}

}
