package FileManager;

public class ItemDTO {
    private String name;
    private String description;
    private String currentRoomID;

    public ItemDTO(String name, String description, String currentRoomID) {
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
}
