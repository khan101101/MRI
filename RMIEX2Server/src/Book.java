import java.io.Serializable;
import java.util.Date;


public class Book  implements Serializable {

	private int bookID;
	private String title;
	private String author;
	private Date releaseDate;
	
	public Book( String title, String author,int bookID, Date releaseDate) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.releaseDate = releaseDate;
	}


	public int getBookID() {
		return bookID;
	}
	
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
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
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
