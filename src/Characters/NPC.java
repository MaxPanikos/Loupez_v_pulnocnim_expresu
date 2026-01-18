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

    public String ask () {
        return "";
    }

    public boolean accuse () {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
