
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    private static Map map;
    private static Player p1;
    public static void main(String[] args) {
        newGame();
    }

    public static void newGame(){
        //new map reads text files and player class
        map = new Map();
        p1 = new Player("p1",map);


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

                //SAVE LOAD TESTING
            } else if (userInput.contains("save game")) {
                saveGame("testFile");
            } else if (userInput.contains("load game")){
                p1 = loadGame("testFile");
            } else if (userInput.contains("printpl")){
                System.out.println(p1);

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
        System.out.println(p1);
    }

    // probably a better existing method but this just split the input in 2 parts after the first word for the format I need
    //created for mainly to clean up main method
    public static String splitInput(String input){
        String[] split = input.split(" ",2);
        return split[1];
    }


    //working on save feature
    public static void saveGame(String saveName){
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("saves/" + saveName + ".bin"));
            writer.writeObject(p1);
            //writer.writeObject(map);
            System.out.println("game saved");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("something bad happened");
        }
    }

    public static Player loadGame(String saveName){
        Object temp = null;
        try {
            ObjectInputStream loader = new ObjectInputStream(new FileInputStream("saves/" + saveName + ".bin"));
            temp = loader.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("uh oh");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return (Player) temp;
    }




}
