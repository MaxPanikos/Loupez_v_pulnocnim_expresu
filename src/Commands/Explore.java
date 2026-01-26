package Commands;

import Main.World;

public class Explore implements Command {
    private World world;

    public Explore(World world) {
        this.world = world;
    }

    @Override
    public String execute(String command) throws Exception{
        try {
            return world.getPlayer().getCurrentRoom().getItems().toString();
        } catch (Exception e) {
            throw new Exception("Nastala neocekavana chyba!");
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
