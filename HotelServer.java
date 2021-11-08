package hotel;

import java.rmi.Naming;

public class HotelServer{
	public HotelServer(){
		try{
			//The Hotel creates a HotelImpl object
			RoomManager r = new RoomManagerImpl();

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
