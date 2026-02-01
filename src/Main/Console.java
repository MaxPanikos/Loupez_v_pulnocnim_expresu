package Main;

import Commands.*;
import FileManagerHelper.FileManager;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private int roundCount;
    private HashMap<String, Command> commands;
    private World world;
    private Scanner sc;

    public Console() {
        this.commands = new HashMap<>();
        this.world = null;
        this.roundCount = 0;
        this.sc = new Scanner(System.in);
        FileManager fileManager = FileManager.loadData("/gamedata.json");
        try {
            world = fileManager.getRoomMap();
        } catch (Exception e) {
            System.out.println("Nastala chyba pri nacitani souboru!");
        }
        System.out.println(world.getRooms().size());
        System.out.println(world.getRooms());
        System.out.println(world.getPlayer());
        commands.put("konec", new Exit());
        commands.put("pomoc", new Help(commands));
        commands.put("pouzij", new Use());
        commands.put("prohledej", new Explore(world));
        commands.put("zeptej", new Ask(world));
        commands.put("obvin", new Accuse(world));
        commands.put("seber", new Grab(world));
        commands.put("odhod", new Discard(world));
        commands.put("jdi", new Move(world));
    }

    public void game () {
        if (world.getPlayer().getCurrentRoom() == null) {
            return;
        }
        boolean exit = false;
        while (!exit) {
            System.out.println(world.getPlayer().getCurrentRoom().text());
            System.out.print(">> ");
            String input = sc.nextLine();
            String[] command = input.split(" ", 2);
            String commandType = command[0].trim().toLowerCase();
            if (commands.containsKey(commandType)) {
                Command c = commands.get(commandType);
                try {
                    if (command.length == 1) {
                        System.out.println(c.execute(""));
                    } else {
                        System.out.println(c.execute(command[1]));
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                exit = c.exit();
            } else {
                System.err.println("Tento prikaz neznam! ('pomoc' pro napovedu)");
            }
            System.out.println();
        }
    }
}
