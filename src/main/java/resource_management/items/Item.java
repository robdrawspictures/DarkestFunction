package resource_management.items;

public class Item {

    private ItemType type;
    private int properties;

    public Item(ItemType type) {
        this.type = type;
        this.properties = type.getValue();
    }

    public ItemType getType() {
        return type;
    }

    public int getProperties() {
        return properties;
    }
}
