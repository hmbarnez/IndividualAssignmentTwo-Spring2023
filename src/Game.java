
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        newGame();
    }

    public static void newGame(){
        //new map reads text files and player class
        Map map = new Map();
        Player p1 = new Player("p1",map);


        Scanner scan = new Scanner(System.in);
        boolean gameOver = false;

        while(!gameOver) {
            System.out.println("\n------------------------------------------------------");
            System.out.println("Enter direction to move (N,S,E,W) or 'Exit' to leave: ");
            String userInput = scan.nextLine().toLowerCase();

            //single input commands first
            if (userInput.length()==1) {
                p1.move(userInput);
            } else if (userInput.equals("explore")) { //explore command prints current room inventory
                p1.exploreRoomInventory();
            } else if (userInput.equals("inventory")) { // inventory command
                p1.viewPlayerInventory();
            } else if (userInput.equals("exit")) { //exit command ends game
                System.out.println("bye");
                gameOver = true;

                // two input commands uses splitinput() method to separate command name from command parameter
            } else if (userInput.contains("pickup")) {// pickup command
                p1.pickupItem(splitInput(userInput));
            } else if (userInput.contains("drop")) {//drop command
                p1.dropItem(splitInput(userInput));
            } else if (userInput.contains("inspect")){//inspect command
                p1.inspectItem(splitInput(userInput));


            }else{
                System.out.println("That command doesn't exist!");
                System.out.println("Try again!");
            }

        }
    }

    // probably a better existing method but this just split the input in 2 parts after the first word for the format I need
    //created for mainly to clean up main method
    public static String splitInput(String input){
        String[] split = input.split(" ",2);
        return split[1];
    }
}
