package FileManagerHelper;

public class ItemDTO {
    private String ID;
    private String name;
    private String description;
    private String currentRoomID;

    public ItemDTO(String ID, String name, String description, String currentRoomID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.currentRoomID = currentRoomID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrentRoomID() {
        return currentRoomID;
    }

    public String getID() {
        return ID;
    }
}
