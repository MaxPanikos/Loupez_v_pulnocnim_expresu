package Commands;

import Items.Item;
import Main.World;

public class Inspect implements Command{
    private World world;

    public Inspect(World world) {
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
        Item item = world.getPlayer().getInventoryItem(command);
        if (item != null) {
            this.world.setMinutesLeft(this.world.getMinutesLeft() - 1);
            return item.getDescription();
        }
        throw new Exception("Tento item nemate v inventari!");
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Prohlednout predmet: prohledni <item>";
    }
}
