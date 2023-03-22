import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    private int roomId;
    public int roomDirections[];
    private boolean isVisited;
    private String roomDescription;
   private ArrayList<Item> roomInventory;

    public Room(int roomId, int[] roomDirections, boolean isVisited, String roomDescription, ArrayList<Item> roomInventory) {
        this.roomId = roomId;
        this.roomDirections = roomDirections;
        this.isVisited = isVisited;
        this.roomDescription = roomDescription;
        this.roomInventory = roomInventory;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomDirections=" + Arrays.toString(roomDirections) +
                ", isVisited=" + isVisited +
                ", roomDescription='" + roomDescription + '\'' +
                ", roomInventory=" + roomInventory +
                '}';
    }

    public int getRoomId() {
        return roomId;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public ArrayList<Item> getRoomInventory() {
        return roomInventory;
    }
}
