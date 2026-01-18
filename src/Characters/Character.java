package Characters;

import Rooms.Room;

public abstract class Character {
    protected Room currentRoom;

    public Character(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean move (Room newRoom) {
        if (currentRoom.getName().equals(newRoom.getName())) {
            return false;
        }
        if (currentRoom.getRooms().containsKey(newRoom.getName())) {
            currentRoom.removeCharacter(this);
            newRoom.addCharacter(this);
            return true;
        }
        return false;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
