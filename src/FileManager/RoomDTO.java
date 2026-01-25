package FileManager;

import java.util.List;

public class RoomDTO {
    private String ID;
    private String name;
    private String description;
    private List<String> exits;

    public RoomDTO(String name, String ID, String description, List<String> exits) {
        this.name = name;
        this.ID = ID;
        this.description = description;
        this.exits = exits;
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
