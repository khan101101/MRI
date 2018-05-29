import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

public class InterfaceImplementation extends UnicastRemoteObject implements MyRemoteInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Book> bookList=new ArrayList<Book>();
	
	protected InterfaceImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createBook(Book input) {
	
		bookList.add(input);
//		try {
//		    FileOutputStream fos = new FileOutputStream("outputt");
//		    ObjectOutputStream oos = new ObjectOutputStream(fos);   
//		    oos.writeObject(bookList); // write MenuArray to ObjectOutputStream
//		    oos.close(); 
//		} catch(Exception ex) {
//		    ex.printStackTrace();
//		}
	}
	


	@Override
	public Book getBook(int bookID) throws RemoteException {
		// TODO Auto-generated method stub
		
		for(Book b:bookList) {
			if(b.getBookID() == bookID)
				return b;
		}
		return null;
	}

	@Override
	public void deleteBook(int bookID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book[] getAllBooksByAuthor() throws RemoteException {
		// TODO Auto-generated method stub
		  Iterator itr=bookList.iterator();  
		  while(itr.hasNext()){  
		   System.out.println(itr.next());  
		  }
		  return null;
	}

	@Override
	public ArrayList<Book> getAllBooks() throws RemoteException {
		// TODO Auto-generated method stub
		return bookList;
	}

	
	


	@Override
	public void closeBookManager() throws RemoteException {
		// TODO Auto-generated method stub

		try {
//		File dir = new File(".");
//		String loc = dir.getCanonicalPath() + File.separator + "outputout.txt";
		String loc = "C:\\Users\\khan101\\eclipse-workspace\\RMIEX2Server\\newFile.txt"; 
//		File f = new File(loc);
		
		FileWriter fstream = new FileWriter(loc, true);
		BufferedWriter writer = new BufferedWriter(fstream);
		for (Book book : bookList) {
            writer.newLine();
            writer.write("id: " + book.getBookID());
            writer.newLine();
            writer.write("author: " + book.getAuthor());
            writer.newLine();
            writer.write("title: " + book.getTitle());
            writer.newLine();
            writer.write(String.valueOf(book.getReleaseDate()));

            writer.flush();
            
            writer.close();
            System.out.println("Books added to the File...");
		}
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
		
	
        }
	
	
	
}
