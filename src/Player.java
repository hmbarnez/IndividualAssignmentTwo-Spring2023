//Nothing too crazy in here yet just added it for further assignments

import java.util.ArrayList;

public class Player {
    private String name;
    private int currentRoomID;
    private ArrayList<Room> rooms;

    private ArrayList<Item> playerInventory;

    public Player(String name, ArrayList<Room> rooms) {
        this.name = name;
        this.currentRoomID = 1;
        this.rooms = rooms;
        this.playerInventory = new ArrayList<>();
    }


    public void move(String direction){
        int index = 0;
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        switch (direction) {
            case "n" -> {}
            case "s" -> index = 1;
            case "e" -> index = 2;
            case "w" -> index = 3;
            default -> System.err.println("error");
        }

        if(currentRoom.roomDirections[index] == 0){
            System.err.println("Cant go this way");
        }else{
            //updates p1's room id
            this.setCurrentRoomID(currentRoom.roomDirections[index]);
            //updates the current room variable
            currentRoom = rooms.get(this.getCurrentRoomID() - 1);
            //prints the description of the room being moved to
            System.out.println(currentRoom.getRoomDescription() + " "+currentRoom.getRoomId());

            //test to print room inventory
            System.out.println(currentRoom.getRoomInventory());


            System.out.println(this.playerInventory);

            //check to see if the room has been visited
            if (currentRoom.isVisited()){
                System.out.println("This room is familiar...");
            }
            //update the isVisited
            currentRoom.setVisited(true);
        }



    }


    //Item methods
    public void pickupItem(String nameToPickup){
        Room room = rooms.get(currentRoomID-1);
        System.out.println(room.getRoomInventory());
    }




//    public void dropItem(String nameToDrop){
//        int id = -1;
//        Item tempItem;
//        for (Item x: playerInventory){
//            id++;
//            if(x.getItemName().equals(nameToDrop)){
//                tempItem = playerInventory.get(id);
//                System.out.println(id);
//                break;
//            }
//        }
//    }





    public String getName() {
        return name;
    }

    public int getCurrentRoomID() {
        return currentRoomID;
    }

    public void setCurrentRoomID(int currentRoomID) {
        this.currentRoomID = currentRoomID;
    }
}
