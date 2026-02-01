package Characters;

import Rooms.Room;

public class NPC extends Character{
    private String ID;
    private String name;
    private int age;

    public NPC(String ID, String name, int age, Room currentRoom) {
        super(currentRoom);
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    public boolean move (Room newRoom) {
        if (currentRoom.getID().equals(newRoom.getID())) {
            return false;
        }
        if (currentRoom.getRooms().containsKey(newRoom.getID())) {
            currentRoom.removeNPC(this);
            newRoom.addNPC(this);
            return true;
        }
        return false;
    }

    public String ask () {
        return "";
    }

    public String accuse () {
        return "";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}
