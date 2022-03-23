package player_management.warrior;

public enum WarriorType {

    ROGUE(1, 2, 1),
    KNIGHT(2,4, 2),
    BARBARIAN(4, 2, 3);

    private final int STR;
    private final int DEF;
    private final int CLASS;

    WarriorType(int STR, int DEF, int CLASS){
        this.STR = STR;
        this.DEF = DEF;
        this.CLASS = CLASS;
    }

    public int getSTR(){
        return this.STR;
    }

    public int getDEF(){
        return this.DEF;
    }

    public int getCLASS(){
        return this.CLASS;
    }
}
