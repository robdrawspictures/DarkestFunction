package resource_management.spells;

public enum SpellType {

    LIGHTNINGBOLT(2, 4),
    FIREBALL(2, 3),
    DEATH(3, 5),
    PLAGUE(3, 2),
    HEAL(1, 3),
    CURE(1, 3),
    SLOW(1, 2),
    HASTE(1, 2);

    private final int alignment;
    private final int ATK;

    SpellType(int alignment, int ATK){
        this.alignment = alignment;
        this.ATK = ATK;
    }
}
