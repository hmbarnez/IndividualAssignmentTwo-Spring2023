
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        //reading the map.txt file and creating the arraylist of rooms
        Map map = new Map();
        ArrayList<Room> rooms = map.readRooms();

        //player object creation mainly for later projects not really used now
        Player p1 = new Player("p1",rooms);

        //print starting room description
        System.out.println(rooms.get(0).getRoomDescription());
        //scanner for user input
        Scanner scan = new Scanner(System.in);

        //stops the game loop
        boolean gameOver = false;
        //room object of where the player is currently at by getting it from the rooms Array List


        while(!gameOver) {
            System.out.println("\n------------------------------------------------------");
            System.out.println("Enter direction to move (N,S,E,W) or 'Exit' to leave: ");
            String userInput = scan.nextLine().toLowerCase();

            //single input commands first
            if (userInput.length() == 1) {
                switch (userInput) {
                    case "n", "s", "e", "w" -> p1.move(userInput);
                    default -> {
                        //if user input does not match any of the options
                        System.out.println("Oops!");
                        System.out.println("Try to enter that again!");
                        System.out.println("'N' - 'S' - 'E' - 'W' ");
                    }
                }
            } else if (userInput.equals("explore")) { //explore command prints current room inventory
                p1.exploreRoomInventory();
            } else if (userInput.equalsIgnoreCase("exit")) { //exit command ends game
                System.out.println("bye");
                gameOver = true;
            } else if (userInput.equals("inventory")) { //
                p1.printPlayerInventory();


                // two input commands
            } else if (userInput.contains("pickup")) { //TODO !! ADD A SPACE TO THE END OF THE STRING AND REMOVE BAD LOGIC
                //I can move this logic into the pickup command but I like it more here I think
                String[] input = userInput.split(" ", 2);
                //if the input is only one word this displays a message to try again
                if (!(input.length == 1)) {
                    p1.pickupItem(input[1]);
                } else {
                    System.out.println("Double check you inputs and try that command again!");
                }
            } else if (userInput.contains("drop")) {
                //I can move this logic into the pickup command but I like it more here I think
                String[] input = userInput.split(" ", 2);
                //if the input is only one word this displays a message to try again
                if (!(input.length == 1)) {
                    p1.dropItem(input[1]);
                } else {
                    System.out.println("Double check you inputs and try that command again!");
                }
            }else if(userInput.contains("inspect")){
                String[] input = userInput.split(" ", 2);
                //if the input is only one word this displays a message to try again
                if (!(input.length == 1)) {
                    p1.inspectItem(input[1]);
                } else {
                    System.out.println("Double check you inputs and try that command again!");
                }




            }else{
                System.out.println("That command doesn't exist!");
                System.out.println("Try again!");
            }

        }




    }
}
