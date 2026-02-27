package Characters;

import Rooms.Room;

import java.io.Serializable;

public abstract class Character implements Serializable {
    protected Room currentRoom;

    public Character(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoomID) {
        this.currentRoom = currentRoomID;
    }
}
