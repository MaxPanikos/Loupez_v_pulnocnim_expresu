package FileManagerHelper;

import java.util.List;

public class RoomDTO {
    private String ID;
    private String name;
    private String description;
    private List<String> exits;
    private String unlocks;

    public RoomDTO(String name, String ID, String description, List<String> exits) {
        this.name = name;
        this.ID = ID;
        this.description = description;
        this.exits = exits;
    }

    public RoomDTO(String ID, String name, String description, List<String> exits, String unlocks) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.exits = exits;
        this.unlocks = unlocks;
    }

    public String getUnlocks() {
        return unlocks;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getExits() {
        return exits;
    }
}
