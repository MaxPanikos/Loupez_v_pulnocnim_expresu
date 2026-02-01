package Commands;

import Main.World;

public class Ask implements Command {
    private World world;
    public Ask(World world) {
        this.world = world;
    }

    @Override
    public String execute(String command) throws Exception{
        if (world.getPlayer().getCurrentRoom().getNpcs().containsKey(command)) {
            return world.getPlayer().getCurrentRoom().getNpcs().get(command).ask();
        }
        throw new Exception("Tato osoba se nenachazi v teto mistnosti!");
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Zeptat se: zeptej <jmeno npc>";
    }
}
