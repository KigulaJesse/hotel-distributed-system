package hotel;

import java.rmi.*;

public class RoomManagerImpl extends java.rmi.server.UnicastRemoteObject implements RoomManager{
	public RoomManagerImpl() throws RemoteException{                        
		super();	
	}
}
