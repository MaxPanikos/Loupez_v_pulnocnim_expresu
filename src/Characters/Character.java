package Characters;

import Rooms.Room;

public abstract class Character {
    protected String currentRoomID;
    protected

    public Character(Room currentRoom) {
        this.currentRoomID = currentRoom;
    }

    public Room getCurrentRoomID() {
        return currentRoomID;
    }

    public void setCurrentRoomID(Room currentRoomID) {
        this.currentRoomID = currentRoomID;
    }
}
