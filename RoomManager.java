package hotel;

import java.rmi.*;

public interface RoomManager extends Remote{
    public String list()
		throws RemoteException;

    public String book()
		throws RemoteException;	
	
	public String guests()
		throws RemoteException;

    public String revenue()
		throws RemoteException;
}
