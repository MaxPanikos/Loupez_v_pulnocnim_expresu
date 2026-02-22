package FileManagerHelper;

public class ItemDTO {
    private String ID;
    private String name;
    private String description;
    private String currentRoomID;
    private String onlyIf;

    public ItemDTO(String ID, String name, String description, String currentRoomID) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.currentRoomID = currentRoomID;
        this.onlyIf = null;
    }

    public ItemDTO(String ID, String name, String description, String currentRoomID, String onlyIf) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.currentRoomID = currentRoomID;
        this.onlyIf = onlyIf;
    }

    public String getOnlyIf() {
        return onlyIf;
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
