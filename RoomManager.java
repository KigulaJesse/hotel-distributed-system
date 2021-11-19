import java.rmi.*;

public interface RoomManager extends Remote{
    public String list()
		throws RemoteException;

    public String book(String room_type, String guest_name)
		throws RemoteException;	
	
	public String myguests()
		throws RemoteException;

    public String revenue()
		throws RemoteException;
}
