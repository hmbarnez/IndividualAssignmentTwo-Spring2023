Text-Based Space Station Game
by Harrison Barnes

This program allows you to make your own map for a text-based game. To create
your own map follow the directions below.

--insert map.txt into project directory

--each line of map.txt is formatted as follows:

1) roomID - int values that identifies the room with an int value

2) northRoomID
   southRoomID
   eastRoomID
   westRoomID
   - Each int value indicates the roomID to the north, south, east, and west of the current room.

3) isVisited - boolean value that represents if the player has visited the room or not

4) roomDescription - description of the room (I kept mine simple for now)


Example of Room 1 in Map.txt

1
2
0
0
0
true
Medical-bay: Starting room

Default Map Layout:
    6
    |
    5
    |
3 - 2 - 4
    |
    1




