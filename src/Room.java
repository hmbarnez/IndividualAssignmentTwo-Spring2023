import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Room implements Serializable {
    private final int roomId;
    public int[] roomDirections;
    private boolean isVisited;
    private final String roomDescription;
    private final Puzzle roomPuzzle;
    private final ArrayList<Item> roomInventory;

    public Room(int roomId, int[] roomDirections, boolean isVisited, String roomDescription, ArrayList<Item> roomInventory,Puzzle roomPuzzle) {
        this.roomId = roomId;
        this.roomDirections = roomDirections;
        this.isVisited = isVisited;
        this.roomDescription = roomDescription;
        this.roomInventory = roomInventory;
        this.roomPuzzle = roomPuzzle;
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

    public void removeItem(Item item){
        Iterator<Item> itemItr = roomInventory.iterator();
        while (itemItr.hasNext()) {
            if (itemItr.next().getItemName().equals(item.getItemName())) {
                itemItr.remove();
            }
        }
    }
    public void addItem(Item item){
        this.roomInventory.add(item);
    }

    public Puzzle getPuzzle(){
        return this.roomPuzzle;
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
