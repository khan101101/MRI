import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class InterfaceImplementation extends UnicastRemoteObject implements MyRemoteInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Book> bookList=new ArrayList<Book>();
	private Book[] books;
	private Integer id;
	private String author, title;
	private Date date;
	protected InterfaceImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	   * This method is used to add a book to the arrayList
	   * @param book
	   */
	@Override
	public void createBook(Book input) {
		
		bookList.add(input);
	}
	
	/**
	   * This method is used to find the book when the client looks for a book using the id of the book
	   * @param bookID
	   * 
	   * @return book
	   */
	@Override
	public Book getBook(int bookID) throws RemoteException {
		// TODO Auto-generated method stub
		
		
		for(Book b:bookList) {
			if(b.getBookID() == bookID)
				return b;
		}
		return null;
	}
	/**
	   * This method is used to delete a book.
	   * @param bookID
	   */
	@Override
	public void deleteBook(int bookID) throws RemoteException {
		// TODO Auto-generated method stub
	
		for(Book b:bookList) {
			if(b.getBookID() == bookID) {
				bookList.remove(b);
		   }
		}
		
	}
	/**
	   * This method is used to return all the books by author stored in the arraylist
	   * @param String a
	   */
	@Override
	public ArrayList<Book> getAllBooksByAuthor(String a) throws RemoteException {
	
	  return null;
	}
	/**
	   * This method is used to return all the books  stored in the arraylist
	   */
	@Override
	public ArrayList<Book> getAllBooks() throws RemoteException {
		// TODO Auto-generated method stub
		
			 return bookList;
			 }
	/**
	   * This method is used to transfer the books from arraylist to a file and save them.
	   */
	@Override
	
	public void closeBookManager() throws RemoteException {
	
		// TODO Auto-generated method stub

		try {

		String loc = "C:\\Users\\khan101\\eclipse-workspace\\RMIEX2Server\\newFile.txt"; 
		FileOutputStream fos = new FileOutputStream(loc);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(bookList);
		oos.close();
		}
				
		catch(IOException e){
			e.printStackTrace();
		}
		
	}

	/**
	   * This method is used to reading books back into arraylist
	   
	   */
	public void init() throws RemoteException{
		String loc = "C:\\Users\\khan101\\eclipse-workspace\\RMIEX2Server\\newFile.txt"; 
		 try {
			//BufferedReader reader = new BufferedReader(new FileReader(loc));
			FileInputStream fis = new FileInputStream(loc);
			ObjectInputStream ois = new ObjectInputStream(fis);
			bookList = (ArrayList<Book>) ois.readObject();
			ois.close();
			
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	}
        

}
