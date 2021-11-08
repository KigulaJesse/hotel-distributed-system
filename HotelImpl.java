package hotel;

import java.rmi.*;

public class HotelImpl extends java.rmi.server.UnicastRemoteObject implements Hotel{
	public HotelImpl() throws RemoteException{                        
		super();	
	}
}
