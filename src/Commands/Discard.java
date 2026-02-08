package Commands;

import Items.Item;
import Main.World;

public class Discard implements Command {
    private World world;

    public Discard(World world) {
        this.world = world;
    }

    @Override
    public String execute(String command) throws Exception {
        command = command.trim().toLowerCase();
        Item item = world.getPlayer().getInventoryItem(command);
        if (item != null && world.getPlayer().throwAwayItem(item)) {
            return "Predmet " + item.getName() + " byl odlozen.";
        }
        throw new Exception("Tento predmet nemate v kapsach!");
    }

    @Override
    public boolean exit() {
        return false;

    }

    @Override
    public String text() {
        return "";
    }

    @Override
    public boolean hasText() {
        return false;
    }

    @Override
    public boolean nextScanner() {
        return false;
    }

    @Override
    public String toString() {
        return "Odhodit: odhod <item v inventari>";
    }
}
