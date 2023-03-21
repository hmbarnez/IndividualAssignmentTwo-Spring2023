import java.util.Arrays;

public class Room {
    private int roomId;
    public int roomDirections[];
    private boolean isVisited;
    private String roomDescription;


    public Room(int roomId, int[] roomDirections, boolean isVisited, String roomDescription) {
        this.roomId = roomId;
        this.roomDirections = roomDirections;
        this.isVisited = isVisited;
        this.roomDescription = roomDescription;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomDirections=" + Arrays.toString(roomDirections) +
                ", isVisited=" + isVisited +
                ", roomDescription='" + roomDescription + '\'' +
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
}
