package resource_management.weapons;

public enum WeaponType {

    SWORD(2, 3),
    AXE(2, 3),
    SPEAR(1, 2),
    MACE(2, 4),
    GREATSWORD(3, 4),
    DAGGER(1, 1),
    SCYTHE(2, 3),
    WHIP(1,3),
    DRAGONSLAYER(3, 5);

    private final int weight;
    private final int ATK;

    WeaponType(int weight, int ATK){
        this.weight = weight;
        this.ATK = ATK;
    }
}
