package Items;

public class Item {
    private String ID;
    private String name;
    private String description;

    public Item(String ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
