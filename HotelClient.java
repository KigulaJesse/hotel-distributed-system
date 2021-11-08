package hotel;

import java.net.MalformedURLException;
import java.rmi.Naming;

public class HotelClient{
	public static void main(String args []){
		try{
			RoomManager r = (RoomManager)Naming.lookup("rmi://localhost:1099/HotelService");

			if(args[0].equals("list")){
				System.out.println(r.list());
			}
			else if(args[0].equals("book")){
				System.out.println(r.book());
			}
			else if(args[0].equals("guests")){
				System.out.println(r.guests());
			}
			else if(args[0].equals("revenue")){
				System.out.println(r.revenue());
			}
		}
		catch(Exception e){
			System.out.println("Received Exception: ");
			System.out.println(e);		

		}
	}
}
