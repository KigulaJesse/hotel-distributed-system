package hotel;

public class Guest{
    private String room;
    private String name; 
    
    public String getRoom(){
        return room;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setRoom(String newRoom){
        this.room = newRoom;
    }
}