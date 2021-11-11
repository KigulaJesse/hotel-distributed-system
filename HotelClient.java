package hotel;

import java.net.MalformedURLException;
import java.rmi.Naming;

public class HotelClient{
	public static void main(String args []){
		try{
			RoomManager r = (RoomManager)Naming.lookup("rmi://localhost:1099/HotelService");

			if(args.length >= 1){
				//List the rooms available for booking
				if(args[0].equals("list")){
					String[] myRooms = r.list();
					for(String myRoom : myRooms){
						System.out.println(myRoom);
					}
				}

				//Book a room
				else if(args[0].equals("book") & 3 == args.length){
					System.out.println(r.book(args[1], args[2]));
				}
				else if(args[0].equals("guests")){
					System.out.println(r.guests());
				}
				else if(args[0].equals("revenue")){
					System.out.println(r.revenue());
				}
			} else {
				System.out.println("");
				System.out.println("Please use anyone of the following commands:");
				System.out.println("");
				System.out.println("java HotelClient list <server address>:");
				System.out.println("java HotelClient book <server address> <room type> <guest name>");
				System.out.println("java HotelClient guests <server address>:");
				System.out.println("java HotelClient revenue <server address>:");
				System.out.println("");
			}
		}
		catch(Exception e){
			System.out.println("Received Exception: ");
			System.out.println(e);		

		}
	}
}
