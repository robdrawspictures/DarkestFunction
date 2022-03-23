package resource_management.spells;

public enum SpellType {

    LIGHTNINGBOLT("N", 4),
    FIREBALL("N", 3),
    DEATH("D", 5),
    PLAGUE("D", 2),
    HEAL("L", 3),
    CURE("L", 3),
    SLOW("L", 2),
    HASTE("L", 2);

    private final String alignment;
    private final int ATK;

    SpellType(String alignment, int ATK){
        this.alignment = alignment;
        this.ATK = ATK;
    }

    public String getAlignment() {
        return alignment;
    }

    public int getATK() {
        return ATK;
    }
}
