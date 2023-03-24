//Nothing too crazy in here yet just added it for further assignments

import java.util.ArrayList;

public class Player {
    private final String name;
    private int currentRoomID;
    private final ArrayList<Room> rooms;
    private final ArrayList<Item> playerInventory;

    public Player(String name, Map map) {
        this.name = name;
        this.currentRoomID = 1;
        this.rooms = map.readRooms();
        this.playerInventory = new ArrayList<>();
    }


    public void move(String direction){
        int index = 0;
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        //logic here is to 1. set the index to the correct direction to travel to
        //                 2. if input is not n s e w to display error message
        switch (direction) {
            case "n" -> {}
            case "s" -> index = 1;
            case "e" -> index = 2;
            case "w" -> index = 3;
            default -> {
                System.err.println("Error! Try: 'N' 'S' 'E' or 'W'!");
                return;
            }
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

            //check to see if the room has a puzzle and if that puzzle has been solved already
            //i plan to maybe change room class
            if((currentRoom.getPuzzle().getPuzzId() != 0) && !(currentRoom.getPuzzle().getHasBeenSolved())){
                currentRoom.getPuzzle().solvePuzzle();
            }

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
                    System.out.println("You picked up a "+ x.getItemName() +"!");
                    this.playerInventory.add(x);
                    room.removeItem(x);
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


    public void dropItem(String itemToDrop){
        Room room = rooms.get(currentRoomID-1);
        if(!playerInventory.isEmpty()){
            boolean droppedSomething = false;
            for (Item x: playerInventory){
                if (x.getItemName().equalsIgnoreCase(itemToDrop)) {
                    System.out.println("You dropped a "+ x.getItemName());
                    room.addItem(x);
                    playerInventory.remove(x);
                    droppedSomething = true;
                    break;
                }
            }
            if(!droppedSomething){
                System.out.println("That item is not in your inventory!");
            }
        }else{
            System.out.println("There is nothing in your inventory!");
        }
    }


    public void inspectItem(String s) {
        //flag to see if the item is found or not
        boolean isFound = false;
        for (Item x: playerInventory){
            if(x.getItemName().equalsIgnoreCase(s)){
                System.out.println(x.getItemDesc());
                isFound = true;
            }
        }
        //if item is not found in the player's inventory this msg is displayed
        if(!isFound)
            System.out.println("That item is not in your inventory");
    }

    public void exploreRoomInventory(){
        Room currentRoom = this.rooms.get(this.getCurrentRoomID() - 1);
        if(!currentRoom.getRoomInventory().isEmpty() ){
            System.out.println(currentRoom.getRoomInventory());
        }else{
            System.out.println("There are no items in this room.");
        }
    }

    public void viewPlayerInventory(){
        if(!this.playerInventory.isEmpty()){
            System.out.println(this.playerInventory);
        }else{
            System.out.println("You didn’t pickup any items yet!");
        }
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
