package resource_management.spells;

public class Spell {

    private int ATK;
    private SpellType type;

    public Spell(SpellType type) {
        this.ATK = type.getATK();
        this.type = type;
    }

    public String getName(){
        return this.type.toString();
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public SpellType getType() {
        return type;
    }

    public void setType(SpellType type) {
        this.type = type;
    }

    public String getAlignment(){
        return type.getAlignment();
    }
}
