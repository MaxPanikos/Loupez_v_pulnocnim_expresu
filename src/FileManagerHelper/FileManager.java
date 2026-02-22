package FileManagerHelper;

import Characters.NPC;
import Characters.Player;
import Characters.Thief;
import Items.Item;
import Main.World;
import Rooms.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map; // Důležitý import!

/**
 * Třída slouží jako "přepravka" pro data z JSONu a zároveň jako loader.
 */
public class FileManager {

    private Map<String, ItemDTO> items;
    private Map<String, RoomDTO> rooms;
    private Map<String, NPCDTO> npcs;
    private String startingRoomID;
    private ThiefDTO thief;

    /**
     * Načte data z JSON souboru.
     */
    public static FileManager loadData(String resourcePath) {
        Gson gson = new Gson();

        try (InputStream is = FileManager.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath);
            }

            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    FileManager.class
            );

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

    public Map<String, RoomDTO> getRooms() { return rooms; }
    public Map<String, ItemDTO> getItems() { return items; }
    public Map<String, NPCDTO> getNpcs() { return npcs; }

    /**
     * Převede načtená "syrová" data (DTO) na skutečné herní objekty.
     */
    public World getRoomMap() throws Exception {
        try {
            HashMap<String, Room> worldMap = new HashMap<>();

            HashMap<String, Item> itemMap = new HashMap<>();

            for (RoomDTO roomDto : rooms.values()) {
                worldMap.put(roomDto.getID(), new Room(roomDto.getID(), roomDto.getName(), roomDto.getDescription()));
            }

            for (ItemDTO itemDto : items.values()) {
                String roomId = itemDto.getCurrentRoomID();
                if (worldMap.containsKey(roomId)) {
                    Item item = new Item(itemDto.getID(), itemDto.getName(), itemDto.getDescription());
                    worldMap.get(roomId).addItem(item);
                    itemMap.put(item.getID(), item);
                }
            }

            for (ItemDTO itemDto : items.values()) {
                String roomId = itemDto.getCurrentRoomID();
                if (worldMap.containsKey(roomId)) {
                    if (itemDto.getOnlyIf() != null && itemMap.get(itemDto.getOnlyIf()) != null) {
                        worldMap.get(roomId).getItems().get(itemDto.getID()).setOnlyIf(itemMap.get(itemDto.getOnlyIf()));
                    }
                }
            }

            for (NPCDTO npcDto : npcs.values()) {
                String roomId = npcDto.getCurrentRoomID();
                if (worldMap.containsKey(roomId)) {
                    if (npcDto.getItemForDialogue() != null) {
                        Item itemForDialogue = itemMap.get(npcDto.getItemForDialogue());
                        worldMap.get(roomId).spawnNPC(new NPC(worldMap.get(roomId), npcDto.getID(), npcDto.getName(), npcDto.getAge(), npcDto.getBasicDialogue(), itemForDialogue, npcDto.getAfterItemDialogue()));
                    } else {
                        worldMap.get(roomId).spawnNPC(new NPC(npcDto.getID(), npcDto.getName(), npcDto.getAge(), worldMap.get(roomId), npcDto.getBasicDialogue()));
                    }
                }
            }

            if (thief != null) {
                String roomId = thief.getCurrentRoomID();
                if (worldMap.containsKey(roomId)) {
                    worldMap.get(roomId).spawnNPC(new Thief(thief.getID(), thief.getName(), thief.getAge(), worldMap.get(roomId), (ArrayList<String>) thief.getProofs(), thief.getBasicDialogue(), thief.getAfterCaughtDialogue()));
                }
            }

            for (RoomDTO roomDto : rooms.values()) {
                Room currentRoom = worldMap.get(roomDto.getID());

                ArrayList<String> exitsIds = (ArrayList<String>) roomDto.getExits();

                if (exitsIds != null) {
                    HashMap<String, Room> actualExitsMap = new HashMap<>();

                    for (String exitId : exitsIds) {
                        if (worldMap.containsKey(exitId)) {
                            actualExitsMap.put(exitId, worldMap.get(exitId));
                        }
                    }
                    currentRoom.setRooms(actualExitsMap);
                }
                if (roomDto.getUnlocks() != null) {
                    Item unlockingItem = itemMap.get(roomDto.getUnlocks());
                    currentRoom.setUnlocks(unlockingItem);
                }
            }

            Room startingRoomObj = null;
            if (!worldMap.isEmpty()) {
                if (worldMap.containsKey(startingRoomID)) {
                    startingRoomObj = worldMap.get(startingRoomID);
                }
            }

            World world = new World(worldMap, new Player(startingRoomObj));

            return world;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Chyba při konverzi DTO na herní objekty: " + e.getMessage());
        }
    }

    public static void save (World world, String resourcePath) throws Exception{

    }
}