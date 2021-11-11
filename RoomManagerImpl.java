package hotel;

import java.rmi.*;

public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager{

	public static int type_0 = 10;
	public static int type_1 = 20;
	public static int type_2 = 5;
	public static int type_3 = 3;
	public static int type_4 = 4;

	public RoomManagerImpl() throws RemoteException{                        
		super();
	}

	public String[] list() throws RemoteException{
		String[] myRooms = new String[7];
		myRooms[0] = " ";
		myRooms[1] = String.valueOf(RoomManagerImpl.type_0)+" rooms of type 0 are available for 55,000 UGX per night";
		myRooms[2] = String.valueOf(RoomManagerImpl.type_1)+" rooms of type 1 are available for 75,000 UGX per night";
		myRooms[3] = String.valueOf(RoomManagerImpl.type_2)+" rooms of type 2 are available for 80,000 UGX per night";
		myRooms[4] = String.valueOf(RoomManagerImpl.type_3)+" rooms of type 3 are available for 150,000 UGX per night";
		myRooms[5] = String.valueOf(RoomManagerImpl.type_4)+" rooms of type 4 are available for 230,000 UGX per night";
		myRooms[6] = " ";
		return myRooms;	
	}
	
	public String book(String room_type, String guest_name) throws RemoteException{
		RoomManagerImpl.type_0 = RoomManagerImpl.type_0 - 1;
		return "You have booked a room";
	}

	public String guests() throws RemoteException{
		return "You are in the guests method";
	}

	public String revenue() throws RemoteException{
		return "You are in the revenue method";
	}
}
