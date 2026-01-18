package Characters;

import Rooms.Room;

public abstract class Character {
    protected String name;
    protected int age;
    protected Room currentRoom;

    public Character(String name, int age, Room currentRoom) {
        this.name = name;
        this.age = age;
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
