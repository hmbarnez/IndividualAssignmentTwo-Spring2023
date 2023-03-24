//Nothing too crazy in here yet just added it for further assignments

import java.util.ArrayList;

public class Player {
    private String name;
    private int currentRoomID;
    private ArrayList<Room> rooms;

    public ArrayList<Item> playerInventory;

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
        //gets current room
        Room room = rooms.get(currentRoomID-1);
        //check to see if room is empty
        if(!room.getRoomInventory().isEmpty()){
            //flag to see if something actually gets picked up from the room
            boolean pickedSomethingUp = false;
            //cycles through room inventory and compares name of item to drop to room inventory item names
            for(Item x: room.getRoomInventory()){
                if(x.getItemName().equalsIgnoreCase(nameToPickup.toLowerCase())){
                    this.playerInventory.add(x);
                    room.removeItem(x);
                    System.out.println("You picked up a "+ nameToPickup +"!");
                    pickedSomethingUp = true;
                    break;
                }
            }
            //if nothing gets picked up after loop print this message
            if (!pickedSomethingUp)
                System.out.println("That item does not exist in this room!");
        }else {
            System.out.println("There is nothing in this room!");
        }

    }





   // public String

    public void printRoomInventory(){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        System.out.println(currentRoom.getRoomInventory());
    }

    public void printPlayerInventory(){
        System.out.println(this.playerInventory);
    }


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
