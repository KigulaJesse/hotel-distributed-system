import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;


public class HotelServer{
	public HotelServer(){
		try{
			//The Hotel creates a HotelImpl object
			RoomManager r = new RoomManagerImpl();
			RoomManager x = new RoomManagerImpl();

			//It binds (registers) to the rmregistry
			Naming.rebind("rmi://localhost:5000/HotelService", r);
			
			//It binds (registers) to the rmregistry
			
		}
		catch (Exception e){
			System.out.println("Trouble: _" + e);
		}	
	}

	public static void main (String args []){
		new HotelServer();	
	}
}
