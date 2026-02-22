package FileManagerHelper;

import Items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class SaveDTO {
    private String saveID;
    private Item[] playerInventory;
    private ArrayList<String> playerProofs;
    private HashMap<String, String> npcLocations;
    private HashMap<String, String> itemsLocations;
}
