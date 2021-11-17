package hotel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.*;

public class HotelClient{
	public static void main(String args []){
		try{
			
			if(args.length >= 1){
				
				try{
					String s = "rmi://localhost:"+String.valueOf(args[1])+"/HotelService";
					RoomManager r = (RoomManager)Naming.lookup(s);

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

					//View the guest list
					else if(args[0].equals("guests")){
						String[][] myGuestLists = r.myguests();
						for(String[] myGuests : myGuestLists){
							if(myGuests.length == 1){
								continue;
							}else{
								for(int i=0; i < myGuests.length; i++){
									if(i == 0){
										System.out.println(" ");
										System.out.println(myGuests[i]);
										System.out.println("-------");
										
									}else{
										System.out.println(myGuests[i]);
									}
									
								}
							}

						}
					}

					//Get the revenue
					else if(args[0].equals("revenue")){
						System.out.println(r.revenue());
					}

					else{
						System.out.println("***************COMMAND NOT FOUND*******************************");
						System.out.println("Please enter a correct server address and follow commands below");
						System.out.println("***************************************************************");
						
						printCommands();	
					}

				} catch (ConnectException c){
					System.out.println("***************WRONG SERVER ADDRESS STATED*********************");
					System.out.println("Please enter a correct server address and follow commands below");
					System.out.println("***************************************************************");
					
					printCommands();
				} catch (ArrayIndexOutOfBoundsException c){
					System.out.println("======================SERVER ADDRESS NOT STATED================");
					System.out.println("Please enter a correct server address and follow commands below");
					System.out.println("================================================================");
					
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
