import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClientMain {

	public static void main(String[] args) throws Exception, RemoteException, NotBoundException {
		String name="//localhost/AccountService";
		ArrayList<Book> books=new ArrayList<Book>();
		ArrayList<Book> store = new ArrayList<Book>();
		MyRemoteInterface remoteService=(MyRemoteInterface)Naming.lookup(name);//Returns the remote object for the URL.
		Scanner s = new Scanner(System.in);
//		Scanner s2 = new Scanner(System.in);

		String[] tmp = s.nextLine().split(":");
//		String[] tmp2 = s2.nextLine().split(".");
		
		if(tmp[0].startsWith("createBook")) {
		  Date date=new SimpleDateFormat("dd/MM/yyyy").parse(tmp[4]); 
		  remoteService.createBook(new Book(tmp[1] , tmp[2], Integer.parseInt(tmp[3]),date));
		  System.out.println("Book added...");
		}
		
		else if(tmp[0].startsWith("get")) {
			
		System.out.println(remoteService.getBook(Integer.parseInt(tmp[1])));
		
		}
		
		else if(tmp[0].startsWith("close")) {
			remoteService.closeBookManager();
		}
		
		else if(tmp[0].startsWith("list")) {
			System.out.println(remoteService.getAllBooks());
		}
		

			  	
	}

}
