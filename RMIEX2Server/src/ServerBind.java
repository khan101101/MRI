import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerBind{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String name="//localhost/AccountService";
		
		LocateRegistry.createRegistry(1099);
	
		MyRemoteInterface service= new InterfaceImplementation();
		
		Naming.rebind(name, service);//rebinds the name to the new object based 
		System.out.println("Server up and running, binding successfull");

	}

}
