
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //intro message I put up here in case I wanted to edit it later
    static final String introMessage = "You wake up in a seemingly empty space station ...\nThe room appears to be a ";
    public static void main(String[] args) {
        //reading the map.txt file and creating the arraylist of rooms
        Map map = new Map("map.txt");
        ArrayList<Room> rooms = map.createRooms();

        //player object creation mainly for later projects not really used now
        Player p1 = new Player("p1",rooms);

        //This part is unnecessary right now, but if a different map is put in, this line will only use the name for intro message
        String[] introRoomName = rooms.get(0).getRoomDescription().split(": ");
        System.out.println(introMessage+ introRoomName[0]);

        //scanner for user input
        Scanner scan = new Scanner(System.in);

        //stops the game loop
        boolean gameOver = false;
        //room object of where the player is currently at by getting it from the rooms Array List
        Room currentRoom = rooms.get(p1.getCurrentRoomID() - 1);

        while(!gameOver){
            System.out.println("\n------------------------------------------------------");
            System.out.println("Enter direction to move (N,S,E,W) or 'Exit' to leave: ");
            String userInput = scan.nextLine();

            switch(userInput.toLowerCase()){
                case "n":
                case "s":
                case "e":
                case "w":
                    //checks the room to the north of current room
                    p1.move(userInput);
                    break;
                case "exit":
                    System.out.println("bye");
                    gameOver = true;
                    break;
                default:
                    //if user input does not match any of the options
                    System.out.println("Oops!");
                    System.out.println("Try to enter that again!");
                    System.out.println("'N' - 'S' - 'E' - 'W' or 'Exit'");

            }
            

        }




    }
}
