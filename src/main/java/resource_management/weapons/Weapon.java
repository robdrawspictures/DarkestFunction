package resource_management.weapons;

public class Weapon {

    private int ATK;
    private WeaponType type;

    public Weapon(WeaponType type) {
        this.ATK = type.getATK();
        this.type = type;
    }

    public int getATK() {
        return ATK;
    }

    public int getAPCost(){
        int APCost = type.getWeight();
        return APCost;
    }

    public WeaponType getType() {
        return type;
    }
}
