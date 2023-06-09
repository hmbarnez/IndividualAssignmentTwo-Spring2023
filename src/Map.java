import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//map class only used for reading the text file and returning array list rooms/items/puzzles
public class Map implements Serializable {
    private final ArrayList<Room> roomsList;
    public Map() {
        roomsList = new ArrayList<>();
    }
    //readRooms returns an Array List of rooms after reading the file
    public ArrayList<Room> readRooms(){

        try {
            Scanner scan = new Scanner(new File("MapInformation/map.txt"));
            ArrayList<Item> items = readItems();
            ArrayList<Puzzle> puzzles = readPuzzles();

            while(scan.hasNextLine()){
                int[] directions = new int[4];
                String[] roomArray = scan.nextLine().split("~");

                int roomId = Integer.parseInt(roomArray[0]);
                directions[0] = Integer.parseInt(roomArray[1]);
                directions[1] = Integer.parseInt(roomArray[2]);
                directions[2] = Integer.parseInt(roomArray[3]);
                directions[3] = Integer.parseInt(roomArray[4]);
                boolean isVisited = Boolean.parseBoolean(roomArray[5]);
                String roomDesc = roomArray[6];

                //need to maybe change the logic here but im going with adding a blank puzzle to rooms without a puzzle
                int puzzleId = Integer.parseInt(roomArray[7]);
                Puzzle tempPuzz = null;
                if (!(puzzleId==0)){
                    for (Puzzle x: puzzles){
                        if(puzzleId == x.getPuzzId()){
                            tempPuzz = x;
                        }
                    }
                }else{
                    //empty puzzle place holder for rooms without puzzles
                    tempPuzz = new Puzzle(0,"","","",0);
                }

                ArrayList<Item> tempItems = new ArrayList<>();
                //check to see if room has an item(s) in it
                for(Item x: items){
                    if(x.getItemLocation() == roomId){
                        tempItems.add(x);
                    }
                }

                roomsList.add(new Room(roomId,directions,isVisited,roomDesc,tempItems,tempPuzz));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
//        for (Room x: roomsList){
//            System.out.println(x);
//        }
        System.out.println("You are in the "+roomsList.get(0).getRoomDescription()+" "+roomsList.get(0).getRoomId());
        return roomsList;
    }

    private ArrayList<Item> readItems(){
        ArrayList<Item> items = new ArrayList<>();
        try {
            Scanner scan = new  Scanner(new File("MapInformation/items.txt"));
            while(scan.hasNextLine()){
                String[] lineSplit = scan.nextLine().split("~");
                int itemId = Integer.parseInt(lineSplit[0]);
                String itemName = lineSplit[1];
                String itemDesc = lineSplit[2];
                int itemLocation = Integer.parseInt(lineSplit[3]);

                items.add(new Item(itemId,itemName,itemDesc,itemLocation));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return items;
    }

    private ArrayList<Puzzle> readPuzzles(){
        ArrayList<Puzzle> puzzles = new ArrayList<>();
        try {
            Scanner scan = new  Scanner(new File("MapInformation/puzzles.txt"));
            while(scan.hasNextLine()){
                String[] lineSplit = scan.nextLine().split("~");
                int puzzId = Integer.parseInt(lineSplit[0]);
                String puzzName = lineSplit[1];
                String puzzDesc = lineSplit[2];
                String puzzAns = lineSplit[3];
                int numAttempts = Integer.parseInt(lineSplit[4]);

                puzzles.add(new Puzzle(puzzId,puzzName,puzzDesc,puzzAns,numAttempts));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return puzzles;
    }

}
