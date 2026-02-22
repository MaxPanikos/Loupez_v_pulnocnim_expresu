package Characters;

import Items.Item;
import Rooms.Room;

import java.util.ArrayList;

public class NPC extends Character{
    protected String ID;
    protected String name;
    protected int age;
    protected String basicDialogue;
    protected Item itemForDialogue;
    protected boolean wasItemGiven;
    protected String afterItemDialogue;

    public NPC(String ID, String name, int age, Room currentRoom, String basicDialogue) {
        super(currentRoom);
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.basicDialogue = basicDialogue;
        this.itemForDialogue = null;
        this.afterItemDialogue = null;
        this.wasItemGiven = false;
    }

    public NPC(Room currentRoom, String ID, String name, int age, String basicDialogue, Item itemForDialogue, String afterItemDialogue) {
        super(currentRoom);
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.basicDialogue = basicDialogue;
        this.itemForDialogue = itemForDialogue;
        this.afterItemDialogue = afterItemDialogue;
        this.wasItemGiven = false;
    }

    /**
     * moves character to another room
     * @param newRoom room where the character wants to move
     * @return true if the move is done correctly
     */
    public boolean move (Room newRoom) {
        if (currentRoom.getID().equals(newRoom.getID())) {
            return false;
        }
        if (currentRoom.getRooms().containsKey(newRoom.getID())) {
            currentRoom.removeNPC(this);
            newRoom.addNPC(this);
            return true;
        }
        return false;
    }

    /**
     * only gives true/false if you have enough proofs to detain thief
     * @param playerProofs list of ployers proofs
     * @return false for every npc
     */
    public boolean accuseTest (ArrayList<String> playerProofs) {
        return false;
    }

    /**
     * gives you speech from person about them being thief
     * @param playerProofs list of players proofs
     * @return String
     */
    public String accuse (ArrayList<String> playerProofs) {
        return name + ": Nemate dukazy a ja to opravdu nejsem!";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getID() {
        return ID;
    }

    public String getBasicDialogue() {
        return basicDialogue;
    }

    public Item getItemForDialogue() {
        return itemForDialogue;
    }

    public String getAfterItemDialogue() {
        return afterItemDialogue;
    }

    public boolean isWasItemGiven() {
        return wasItemGiven;
    }

    public void setWasItemGiven(boolean wasItemGiven) {
        this.wasItemGiven = wasItemGiven;
    }

    @Override
    public String toString() {
        return name + " (" + ID + ")";
    }
}
