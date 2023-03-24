
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        //new map reads text files and creates rooms array list
        Map map = new Map();
        Player p1 = new Player("p1",map);


        Scanner scan = new Scanner(System.in);
        boolean gameOver = false;

        while(!gameOver) {
            System.out.println("\n------------------------------------------------------");
            System.out.println("Enter direction to move (N,S,E,W) or 'Exit' to leave: ");
            String userInput = scan.nextLine().toLowerCase();

            //single input commands first
            if (userInput.length() == 1) {
                p1.move(userInput);
            } else if (userInput.equals("explore")) { //explore command prints current room inventory
                p1.exploreRoomInventory();
            } else if (userInput.equalsIgnoreCase("exit")) { //exit command ends game
                System.out.println("bye");
                gameOver = true;
            } else if (userInput.equals("inventory")) { //
                p1.printPlayerInventory();

            // two input commands
            } else if (userInput.contains("pickup")) {
                p1.pickupItem(splitInput(userInput));
            } else if (userInput.contains("drop")) {
                p1.dropItem(splitInput(userInput));
            }else if(userInput.contains("inspect")){
                p1.inspectItem(splitInput(userInput));


            }else{
                System.out.println("That command doesn't exist!");
                System.out.println("Try again!");
            }

        }
    }

    // probably a better existing method but this just split the input in 2 parts after the first word
    //created for items that are two words iq
    public static String splitInput(String input){
        String[] splitput = input.split(" ",2);
        return splitput[1];
    }
}
