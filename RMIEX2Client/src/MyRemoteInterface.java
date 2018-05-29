import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MyRemoteInterface extends Remote {

	

	
	public void createBook(Book input) throws RemoteException;
	public Book getBook(int bookID) throws RemoteException;
	public void deleteBook(int bookID) throws RemoteException;
	public Book[] getAllBooksByAuthor() throws RemoteException;
	public ArrayList<Book> getAllBooks() throws RemoteException;
	public void closeBookManager () throws RemoteException;
}
