package Commands;

import Main.World;
import Rooms.Room;

public class Move implements Command{
    private World world;

    public Move(World world) {
        this.world = world;
    }

    @Override
    public String execute(String command) throws Exception {
        command = command.trim().toLowerCase();
        Room room = world.getRooms().get(command);
        if (room != null) {
            if (world.getPlayer().move(room)) {
                return "Hrac byl presunut do " + room.getName();
            }
            throw new Exception("Do teto mistnosti se neda jit z mistnosti kde se nachazite!");
        }
        throw new Exception("Tato mistnost neexistuje!");
    }

    @Override
    public boolean exit() {
        return false;
    }

    @Override
    public String toString() {
        return "Chodit: jdi <nazev mistnosti>";
    }
}
