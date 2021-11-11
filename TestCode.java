import java.util.*;

public class TestCode{
    public static void main(String args []){
        int v = 5;
        int w = 5;
        int x = 5;
        int y = 5;
        int z = 5;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose a room");
        String str = sc.nextLine();

        if(str.equals("v")){
            v = v-1;
        }

        System.out.println(v);
    }
}