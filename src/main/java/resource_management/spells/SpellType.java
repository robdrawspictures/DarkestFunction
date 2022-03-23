package resource_management.spells;

public enum SpellType {

    LIGHTNINGBOLT("N", 4, 3),
    FIREBALL("N", 3, 2),
    DEATH("D", 5, 5),
    PLAGUE("D", 2, 3),
    HEAL("L", 3, 2),
    CURE("L", 3, 1),
    SLOW("L", 2, 1),
    HASTE("L", 2, 1),
    METEOR("N", 1000, 10);

    private final String alignment;
    private final int ATK;
    private final int MP;

    SpellType(String alignment, int ATK, int MP){
        this.alignment = alignment;
        this.ATK = ATK;
        this.MP = MP;
    }

    public String getAlignment() {
        return alignment;
    }

    public int getATK() {
        return ATK;
    }

    public int getMP(){
        return MP;
    }
}
