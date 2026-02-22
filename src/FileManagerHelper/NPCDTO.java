package FileManagerHelper;

public class NPCDTO {
    protected String ID;
    protected String name;
    protected int age;
    protected String currentRoomID;
    protected String basicDialogue;
    protected String itemForDialogue;
    protected String afterItemDialogue;

    public NPCDTO(String ID, String name, int age, String currentRoom, String basicDialogue) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.currentRoomID = currentRoom;
        this.basicDialogue = basicDialogue;
        this.itemForDialogue = null;
        this.afterItemDialogue = null;
    }

    public NPCDTO(String ID, String name, int age, String currentRoomID, String basicDialogue, String itemForDialogue, String forItemDialogue) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.currentRoomID = currentRoomID;
        this.basicDialogue = basicDialogue;
        this.itemForDialogue = itemForDialogue;
        this.afterItemDialogue = forItemDialogue;
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

    public String getBasicDialogue() {
        return basicDialogue;
    }

    public String getItemForDialogue() {
        return itemForDialogue;
    }

    public String getAfterItemDialogue() {
        return afterItemDialogue;
    }
}
