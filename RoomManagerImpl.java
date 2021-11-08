package hotel;

import java.rmi.*;

public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager{
	public RoomManagerImpl() throws RemoteException{                        
		super();
	}

	public String list() throws RemoteException{
		return "You are in the list method";	
	}
	
	public String book() throws RemoteException{
		return "You are in the book method";
	}

	public String guests() throws RemoteException{
		return "You are in the guests method";
	}

	public String revenue() throws RemoteException{
		return "You are in the revenue method";
	}
}
