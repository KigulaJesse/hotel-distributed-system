package hotel;

import java.rmi.Naming;

public class HotelServer{
	public HotelServer(){
		try{
			//The Hotel creates a HotelImpl object
			Hotel h = new HotelImpl();

			//It binds (registers) to the rmregistry
			Naming.rebind("rmi://localhost:1099/HotelService", h);
			
		}
		catch (Exception e){
			System.out.println("Trouble: _" + e);
		}	
	}

	public static void main (String args []){
		new HotelServer();	
	}
}
