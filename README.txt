Text-Based Space Station Game
by Harrison Barnes

This program allows you to make your own map for a text-based game. To create
your own map follow the directions below.

-------------------------------------------------------------------------------------------------

--insert all necessary text files into project directory

--each line of map.txt is formatted as follows:

1) roomID- int values that identifies the room with an int value

2) northRoomID, southRoomID, eastRoomID, westRoomID
   - Each int value indicates the roomID to the north, south, east, and west of the current room.

3) isVisited- boolean value that represents if the player has visited the room or not

4) roomDescription- description of the room (I kept mine simple for now)

5) puzzleId- int value of the puzzle id located in this room, 0 value represents no puzzle in the room

Example of Room 1 in Map.txt

1~2~0~0~0~true~Medical-bay~0

Default Map Layout:
    6
    |
    5
    |
3 - 2 - 4
    |
    1

Puzzles Located in rooms: 3 and 5
Items located in rooms: 2,4, and 6
---------------------------------------------------------------------------------------------------
Puzzles.txt Format:

1) puzzleId - int value that identifies the puzzle

2) puzzleName- String value of the puzzle's name

3) puzzleDesc- String value that describes the puzzle's question that the user must answer

4) puzzleAnswer- String value of the correct answer to the puzzle

5) puzzleAttempts- int value of the number of attempts the player has to solve the puzzle

Ex Puzzle:
1~Math Problem~This is a math puzzle! What is the cubic root of 512?? ~8~3
---------------------------------------------------------------------------------------------------
Items.txt Format

1) itemId- int value used to identify the item

2) itemName- String value of the items name

3) itemDesc- String value used to describe the item

4) itemLocation- int value used to identify which room the item is located

Ex Item:
1~Calculator~This calculator can be used to calculate things!~2
---------------------------------------------------------------------------------------------------
User Manual/Commands:

N,S,E,W- used to move the player's character in a certain direction to the next room

Explore- returns the all items located in the current room

Pickup <item name>- used to pickup an item thats located in the current room

Drop <item name>- used to remove an item from the player's inventory and place it in the current room

Inspect <item name>- used to see a description of an item that is in the player's inventory

Inventory- returns a list of all items that the player has picked up and not dropped


