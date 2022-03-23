package resource_management.items;

public enum ItemType {

    POTION(25),
    ANTIDOTE(0),
    PHOENIXDOWN(100);

    private final int value;

    ItemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
