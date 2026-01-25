package FileManager;

public class NPCDTO {
    private String ID;
    private String name;
    private int age;
    private String currentRoomID;

    public NPCDTO(String ID, String name, int age, String currentRoom) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.currentRoomID = currentRoom;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCurrentRoomID() {
        return currentRoomID;
    }
}
