package player_management.mage;

public enum MageType {

    WARLOCK("D"),
    WIZARD("L");

    private final String alignment;

    MageType(String alignment){
        this.alignment = alignment;
    }

    public String getAlignment() {
        return alignment;
    }
}
