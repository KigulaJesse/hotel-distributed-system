import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.*;

public class HotelClient{
	public static void main(String args []){
		try{
			
			if(args.length >= 1){
				
				try{
					
					String s = "rmi://localhost:"+args[1]+"/HotelService";
					RoomManager r = (RoomManager)Naming.lookup(s);
					

					//List the rooms available for booking
					if(args[0].equals("list")){
						System.out.println(r.list());
					}

					//Book a room on the client side
					else if(args[0].equals("book")){
						System.out.println(r.book(args[2], args[3]));
					}

					//View the guest list
					else if(args[0].equals("guests")){
						System.out.println(r.myguests());
					}

					//Get the revenue
					else if(args[0].equals("revenue")){
						System.out.println(r.revenue());
					}

					else{
						System.out.println("***************COMMAND NOT FOUND*******************************");
						System.out.println("Please enter commands as stated below");
						System.out.println("***************************************************************");
						
						printCommands();	
					}
				} catch (ConnectException c){
					System.out.println("***************WRONG SERVER ADDRESS STATED*********************");
					System.out.println("Please enter a correct server address and follow commands below");
					System.out.println("***************************************************************");
					
					printCommands();
				} catch (ArrayIndexOutOfBoundsException c){
					System.out.println("==================MISSING OPTIONS IN COMMAND================");
					System.out.println("Please enter a correct server address and follow commands below");
					System.out.println("================================================================");
					
					printCommands();
					
				} catch(NotBoundException c){
					System.out.println("***************SERVER NOT BOUND*********************");
					System.out.println("When server is not ");
					System.out.println("****************************************************");
					
					printCommands();
					
				} catch (MalformedURLException m){
					System.out.println("***************COMMAND NOT FOUND*******************************");
					System.out.println("Please enter commands as stated below");
					System.out.println("***************************************************************");
						
						printCommands();	
				}
			} else {
				System.out.println("");
				System.out.println("Please use anyone of the following commands:");
				
				printCommands();
			}
		}
		catch(Exception e){
			System.out.println("Received Exception: ");
			System.out.println(e);		

		}
	}

	public static void printCommands(){
		System.out.println("");
		System.out.println("java HotelClient list <server address>:");
		System.out.println("java HotelClient book <server address> <room type> <guest name>");
		System.out.println("java HotelClient guests <server address>:");
		System.out.println("java HotelClient revenue <server address>:");
		System.out.println("");
	}
}
