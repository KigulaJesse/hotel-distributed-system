package hotel;

import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class HotelServer{
	public HotelServer(){
		try{
			//The Hotel creates a HotelImpl object
			RoomManager r = new RoomManagerImpl();

			//Registry registry = LocateRegistry.createRegistry(5000);
			System.out.println("here now");

			//It binds (registers) to the rmregistry
			Naming.rebind("rmi://localhost:1099/HotelService", r);
			
		}
		catch (Exception e){
			System.out.println("Trouble: _" + e);
		}	
	}

	public static void main (String args []){
		new HotelServer();	
	}
}
