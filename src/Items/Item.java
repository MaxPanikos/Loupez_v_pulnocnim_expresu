package Items;

import java.io.Serializable;

public class Item implements Serializable {
    private String ID;
    private String name;
    private String description;
    private Item onlyIf;

    public Item(String ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.onlyIf = null;
    }

    public Item getOnlyIf() {
        return onlyIf;
    }

    public void setOnlyIf(Item onlyIf) {
        this.onlyIf = onlyIf;
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
