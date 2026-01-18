package Characters;

import Rooms.Room;

public abstract class NPC extends Character{
    protected String name;
    protected int age;
    public NPC(String name, int age, Room currentRoom) {
        this.name = name;
        this.age = age;
        super(currentRoom);
    }

    public boolean move (Room newRoom) {
        if (currentRoom.getName().equals(newRoom.getName())) {
            return false;
        }
        if (currentRoom.getRooms().containsKey(newRoom.getName())) {
            currentRoom.removeNPC(this);
            newRoom.addNPC(this);
            return true;
        }
        return false;
    }

    public String ask () {
        return "";
    }

    public boolean accuse () {
        return false;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
