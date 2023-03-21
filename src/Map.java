import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//map class only used for reading the text file and returning array list rooms/items/puzzles
public class Map {
    private ArrayList<Room> roomsList;
    public Map() {
        this.roomsList = new ArrayList<>();
    }

    //readRooms returns an Array List of rooms after reading the file
    public ArrayList<Room> readRooms(){

        try {
            Scanner scan = new Scanner(new File("map.txt"));
            ArrayList<Item> items = readItems();
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
                ArrayList<Item> tempItems = new ArrayList<>();

                //check to see if room has an item(s) in it
                for(Item x: items){
                    if(x.getItemLocation() == roomId){
                        tempItems.add(x);

                    }

                }

                roomsList.add(new Room(roomId,directions,isVisited,roomDesc,tempItems));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        for (Room x: roomsList){
            System.out.println(x);
        }
        return roomsList;
    }

    public ArrayList<Item> readItems(){
        ArrayList<Item> items = new ArrayList<>();
        try {
            Scanner scan = new  Scanner(new File("items.txt"));
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

}
