package player_management.healer;

public enum HealerType {

    CLERIC("L"),
    MONK("N");

    private final String alignment;

    HealerType(String alignment){
        this.alignment = alignment;
    }

    public String getAlignment() {
        return alignment;
    }
}
