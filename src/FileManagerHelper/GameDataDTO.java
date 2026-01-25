package FileManagerHelper;

import java.util.Map;

public class GameDataDTO {
    private Map<String, ItemDTO> items;
    private Map<String, NPCDTO> npcs;
    private Map<String, RoomDTO> rooms;

    public Map<String, ItemDTO> getItems() {
        return items;
    }

    public Map<String, NPCDTO> getNpcs() {
        return npcs;
    }

    public Map<String, RoomDTO> getRooms() {
        return rooms;
    }
}