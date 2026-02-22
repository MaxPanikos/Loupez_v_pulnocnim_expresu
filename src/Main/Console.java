package Main;

import Commands.*;
import FileManagerHelper.FileManager;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private HashMap<String, Command> gameCommands;
    private HashMap<String, Command> menuCommands;
    private World world;
    private Scanner sc;

    /**
     * constructor + setup of the game
     */
    public Console() {
        this.gameCommands = new HashMap<>();
        this.menuCommands = new HashMap<>();
        this.world = null;
        this.sc = new Scanner(System.in);
        FileManager fileManager = FileManager.loadData("/gamedata.json");
        try {
            world = fileManager.getRoomMap();
        } catch (Exception e) {
            System.err.println("Nastala chyba pri nacitani souboru!");
        }
        System.out.println("Pocet nactenych mistnosti: " + world.getRooms().size());
        System.out.println();
        gameCommands.put("konec", new Exit());
        gameCommands.put("pomoc", new Help(gameCommands));
        gameCommands.put("prohledej", new Explore(world));
        gameCommands.put("zeptej", new Ask(world));
        gameCommands.put("obvin", new Accuse(world));
        gameCommands.put("seber", new Grab(world));
        gameCommands.put("odhod", new Discard(world ));
        gameCommands.put("jdi", new Move(world));
        gameCommands.put("prohledni", new Inspect(world));
        gameCommands.put("podej", new Give(world));
        gameCommands.put("odemkni", new Unlock(world));

        menuCommands.put("konec", new Exit());
        menuCommands.put("pomoc", new Help(menuCommands));
        menuCommands.put("nova hra", new NewGame(this));
    }

    /**
     * main menu of the game
     */
    public void menu () {
        boolean exit = false;
        while (!exit) {
            System.out.println(Colors.YELLOW + "Loupez v pulnocnim expresu" + Colors.RESET);
            System.out.println("Napiste co chcete udelat:");
            System.out.println(Colors.GREEN + "nova hra" + Colors.RESET + " - Vytvorit novou hru.");
            System.out.println(Colors.GREEN + "konec" + Colors.RESET + " - Vytvorit novou hru.");
            System.out.print(">> ");
            String input = sc.nextLine();
            String commandType = input.toLowerCase();
            if (menuCommands.containsKey(commandType)) {
                Command c = menuCommands.get(commandType);
                try {
                    if (c.hasText()) {
                        System.out.println(">> " + c.text());
                        System.out.println(">> " + c.execute(""));
                    } else {
                        System.out.println(">> " + c.execute(""));
                    }
                } catch (Exception e) {
                    System.err.println(">> " + e.getMessage());
                }
                exit = c.exit();
            } else {
                System.err.println(">> Tento prikaz neznam! ('pomoc' pro napovedu)");
            }
            System.out.println();
        }
    }

    /**
     * actual game
     */
    public void game () {
        if (world.getPlayer().getCurrentRoom() == null) {
            return;
        }
        System.out.println(Colors.BLUE + world.getPrologue() + Colors.RESET);
        boolean exit = false;
        while (!exit) {
            if (!world.isGameOver() && !(world.getMinutesLeft() <= 0)) {
                System.out.println(">> Zbyva minut: " + world.getMinutesLeft());
                System.out.println(">> " + world.getPlayer().getCurrentRoom().text());
                System.out.println(">> " + world.getPlayer().inventory());
                System.out.print(">> ");
                String input = sc.nextLine();
                String[] command = input.split(" ", 2);
                String commandType = command[0].trim().toLowerCase();
                if (gameCommands.containsKey(commandType)) {
                    Command c = gameCommands.get(commandType);
                    try {
                        if (command.length == 1) {
                            System.out.println(">> " + c.execute(""));
                        } else {
                            System.out.println(">> " + c.execute(command[1]));
                        }
                    } catch (Exception e) {
                        System.err.println(">> " + e.getMessage());
                    }
                    exit = c.exit();
                } else {
                    System.err.println(">> Tento prikaz neznam! ('pomoc' pro napovedu)");
                }
                System.out.println();
            } else {
                if (world.isGameOver()) {
                    System.out.println(Colors.GREEN + "Hrac vyhral. Dopadl zlodeje a zadrzel ho!" + Colors.RESET);
                } else if (world.getMinutesLeft() <= 0) {
                    System.out.println(Colors.YELLOW + "Hrac nestihl zlodeje chytit v cas a uprchl!" + Colors.RESET);
                } else {
                    System.out.println(Colors.RED + "Nastala neocekava chyba. Posilam vas do menu!" + Colors.RESET);
                }
                menu();
            }
        }
    }
}
