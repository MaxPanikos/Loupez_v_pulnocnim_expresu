package Characters;

import Rooms.Room;

public class NPC extends Character{
    public NPC(String name, int age, Room currentRoom) {
        super(name, age, currentRoom);
    }

    @Override
    public String ask() {
        return super.ask();
    }
}
