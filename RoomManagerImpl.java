package hotel;
import java.rmi.*;
import java.util.ArrayList;
import java.util.Arrays;  

public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager{

	public static int type_0 = 10;
	public static int type_1 = 20;
	public static int type_2 = 5;
	public static int type_3 = 3;
	public static int type_4 = 4;
	public static String[] type_0_list = {"Type 0 Guests", "55000"};
	public static String[] type_1_list = {"Type 1 Guests", "75000"};
	public static String[] type_2_list = {"Type 2 Guests", "80000"};
	public static String[] type_3_list = {"Type 3 Guests", "150000"};
	public static String[] type_4_list = {"Type 4 Guests", "230000"};

	public RoomManagerImpl() throws RemoteException{                        
		super();
	}

//List Function On Server side returns a string of rooms present
public String list() throws RemoteException{
String myRooms = "\r\n";
myRooms = myRooms+" "+String.valueOf(RoomManagerImpl.type_0)+" rooms of type 0 are available for 55,000 UGX per night\r\n";
myRooms = myRooms+" "+String.valueOf(RoomManagerImpl.type_1)+" rooms of type 1 are available for 75,000 UGX per night\r\n";
myRooms = myRooms+" "+ String.valueOf(RoomManagerImpl.type_2)+" rooms of type 2 are available for 80,000 UGX per night\r\n";
myRooms = myRooms+" "+ String.valueOf(RoomManagerImpl.type_3)+" rooms of type 3 are available for 150,000 UGX per night\r\n";
myRooms = myRooms+" "+ String.valueOf(RoomManagerImpl.type_4)+" rooms of type 4 are available for 230,000 UGX per night\r\n";
return myRooms;	
}
	
	public String book(String room_type, String guest_name) throws RemoteException{
		if(room_type.equals("type_0")){
			if(RoomManagerImpl.type_0 > 0){
				RoomManagerImpl.type_0 = RoomManagerImpl.type_0 - 1;
				
				ArrayList<String> guestList = new ArrayList<String>(Arrays.asList(RoomManagerImpl.type_0_list));  
				guestList.add(guest_name);  
				RoomManagerImpl.type_0_list = guestList.toArray(RoomManagerImpl.type_0_list);  
				return "You have booked a type_0 room";
			}
			else{
				return "Room of type_0 is fully booked";
			}
		}
		else if(room_type.equals("type_1")){
			if(RoomManagerImpl.type_1 > 0){
				RoomManagerImpl.type_1 = RoomManagerImpl.type_1 - 1;

				ArrayList<String> guestList = new ArrayList<String>(Arrays.asList(RoomManagerImpl.type_1_list));  
				guestList.add(guest_name);  
				RoomManagerImpl.type_1_list = guestList.toArray(RoomManagerImpl.type_1_list);  
				
				return "You have booked a type_1 room";
			}
			else{
				return "Room of type_1 is fully booked";
			}
		}
		else if(room_type.equals("type_2")){
			if(RoomManagerImpl.type_2 > 0){
				RoomManagerImpl.type_2 = RoomManagerImpl.type_2 - 1;
				
				ArrayList<String> guestList = new ArrayList<String>(Arrays.asList(RoomManagerImpl.type_2_list));  
				guestList.add(guest_name);  
				RoomManagerImpl.type_2_list = guestList.toArray(RoomManagerImpl.type_2_list);
				
				return "You have booked a type_2 room";
			}
			else{
				return "Room of type_2 is fully booked";
			}
		}
		else if(room_type.equals("type_3")){
			if(RoomManagerImpl.type_3 > 0){
				RoomManagerImpl.type_3 = RoomManagerImpl.type_3 - 1;

				ArrayList<String> guestList = new ArrayList<String>(Arrays.asList(RoomManagerImpl.type_3_list));  
				guestList.add(guest_name);  
				RoomManagerImpl.type_3_list = guestList.toArray(RoomManagerImpl.type_3_list);

				return "You have booked a type_3 room";
			}
			else{
				return "Room of type_3 is fully booked";
			}
		}
		else if(room_type.equals("type_4")){
			if(RoomManagerImpl.type_4 > 0){
				RoomManagerImpl.type_4 = RoomManagerImpl.type_4 - 1;

				ArrayList<String> guestList = new ArrayList<String>(Arrays.asList(RoomManagerImpl.type_4_list));  
				guestList.add(guest_name);  
				RoomManagerImpl.type_4_list = guestList.toArray(RoomManagerImpl.type_4_list);

				return "You have booked a type_4 room";
			}
			else{
				return "Room of type_4 is fully booked";
			}
		}else{
			
			String error="******BOOK COMMAND ENTERED WRONGLY********\r\n";
			error = error + "PLease follow format below\r\n";
			error = error + "********************************************";

			error = error + "\r\n \r\n java HotelClient book <server address> <room type> <guest name> \r\n";
			
			return error;
		}
	}

	public String myguests() throws RemoteException{
		String[][] guests = new String[][] 
		{
		RoomManagerImpl.type_0_list, 
		RoomManagerImpl.type_1_list, 
		RoomManagerImpl.type_2_list, 
		RoomManagerImpl.type_3_list, 
		RoomManagerImpl.type_4_list};

		String guests_list = " ";
		
		for(String[] myGuests : guests){
			if(myGuests.length == 2){
				continue;
			}else{
				for(int i=0; i < myGuests.length; i++){
					if(i == 0){
						guests_list = guests_list + "\r\n";
						guests_list = guests_list + myGuests[i] + "\r\n";
						guests_list = guests_list + "-------\r\n";
					} else if(i == 1){
						continue;
					}
					else{
						guests_list = guests_list + myGuests[i] + "\r\n";
					}
				}
			}

		}


		return guests_list;
	}

	public String revenue() throws RemoteException{
		String[][] guests = new String[][] 
		{
		RoomManagerImpl.type_0_list, 
		RoomManagerImpl.type_1_list, 
		RoomManagerImpl.type_2_list, 
		RoomManagerImpl.type_3_list, 
		RoomManagerImpl.type_4_list};

		String room_total = "";
		String total_amount = "";
		int total =  0;
		
		for(String[] myGuests : guests){
			if(myGuests.length == 2){
				continue;
			}else{
				room_total += myGuests[0]+" - "+ (myGuests.length - 2) +" x "+myGuests[1]+"		"+ (myGuests.length - 2) * Integer.valueOf(myGuests[1]) + "\r\n";
				total += (myGuests.length - 2) * Integer.valueOf(myGuests[1]);
				/**
				for(int i=0; i < myGuests.length; i++){
					if(i == 0){
						guests_list = guests_list + "\r\n";
						guests_list = guests_list + myGuests[i] + "\r\n";
						guests_list = guests_list + "-------\r\n";
					}else{
						guests_list = guests_list + myGuests[i] + "\r\n";
					}
				} */
			}
			

		}
		total_amount = "------------------------------------------------------"+ "\r\n";
		total_amount += "Total Revenue				"+total+ "\r\n";

		return room_total+total_amount;
	}
}
