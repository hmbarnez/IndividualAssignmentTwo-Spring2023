import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//map class only used for reading the text file and returning array list rooms/items/puzzles
public class Map {
    private String path;
    public Map(String path) {
        this.path = path;
    }

    //createRooms returns an Array List of rooms after reading the file
    public ArrayList<Room> readRooms(){
        ArrayList<Room> roomsList = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File(this.path));
            while(scan.hasNextLine()){
                int[] directions = new int[4];
                String roomInfo = scan.nextLine();
                String[] roomArray = roomInfo.split("~");
                int roomID = Integer.parseInt(roomArray[0]);
                directions[0] = Integer.parseInt(roomArray[1]);
                directions[1] = Integer.parseInt(roomArray[2]);
                directions[2] = Integer.parseInt(roomArray[3]);
                directions[3] = Integer.parseInt(roomArray[4]);
                boolean isVisited = Boolean.parseBoolean(roomArray[5]);
                String roomDesc = roomArray[6];
                roomsList.add(new Room(roomID,directions,isVisited,roomDesc));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return roomsList;
    }
}
