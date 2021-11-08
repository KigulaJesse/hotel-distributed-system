package hotel;

import java.net.MalformedURLException;
import java.rmi.Naming;

public class HotelClient{
	public static void main(String args []){
		try{
			RoomManager r = (RoomManager)Naming.lookup("rmi://localhost:1099/HotelService");
		}
		catch(Exception e){
			System.out.println("Received Exception: ");
			System.out.println(e);		
		}
	}
}
