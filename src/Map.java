import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//map class only used for reading the text file and returning array list of rooms
public class Map {
    private String path;
    public Map(String path) {
        this.path = path;
    }

    //createRooms returns an Array List of rooms after reading the file
    public ArrayList<Room> createRooms(){
        ArrayList<Room> roomsList = new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File(this.path));
            while(scan.hasNextLine()){
                int roomID = Integer.parseInt(scan.nextLine());
                int[] directions = new int[4];
                directions[0] = Integer.parseInt(scan.nextLine());
                directions[1] = Integer.parseInt(scan.nextLine());
                directions[2] = Integer.parseInt(scan.nextLine());
                directions[3] = Integer.parseInt(scan.nextLine());
                boolean isVisited = Boolean.parseBoolean(scan.nextLine());
                String roomDesc = scan.nextLine();
                roomsList.add(new Room(roomID,directions,isVisited,roomDesc));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return roomsList;
    }
}
