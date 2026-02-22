package Commands;

import Characters.NPC;
import Items.Item;
import Main.World;
import Rooms.Room;

public class Unlock implements Command {
    private World world;

    public Unlock(World world) {
        this.world = world;
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public String text() {
        return "";
    }

    @Override
    public String execute(String command) throws Exception {
        Room room = world.getRooms().get(command);
        if (world.getPlayer().getCurrentRoom().getRooms().containsKey(command)) {
            if (room.isLocked()) {
                Item unlockingItem = room.getUnlocks();
                if (world.getPlayer().checkInventory(unlockingItem) != null) {
                    world.getPlayer().removeItem(unlockingItem);
                    room.setLocked(false);
                    return "Mistnost byla uspesne odemcena.";
                }
                throw new Exception("Nemate u sebe potrebny item pro otevreni mistnosti!");
            }
            throw new Exception("Tato mistnost je odemknuta!");
        }
        throw new Exception("Mistnost se nachazi ve vasi mistnosti!");
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Odemkni mistnost: odemkni <mistnost>";
    }
}
