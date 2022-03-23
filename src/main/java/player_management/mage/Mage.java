package player_management.mage;

import beast_management.Beast;
import beast_management.enemy.Enemy;
import behaviours.ICast;
import player_management.PlayerCharacter;
import resource_management.spells.Spell;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class Mage extends PlayerCharacter implements ICast {

    private int MAXHP;
    private int HP;
    private int INT;
    private MageType type;
    private ArrayList<Spell> spells;
    private Beast mount;

    public Mage(String name, MageType type, ArrayList<Spell> spells, Beast mount) {
        super(name);
        this.MAXHP = 75;
        this.HP = 75;
        this.INT = 1;
        this.type = type;
        this.spells = spells;
        this.mount = mount;
    }

    public int getMAXHP() {
        return MAXHP;
    }

    public int getHP() {
        return HP;
    }

    public int getINT() {
        return INT;
    }

    public int spellCount(){
        return spells.size();
    }

    public Spell getSpellByName(String name){
        Spell foundSpell = null;
        String search = name.toUpperCase();
        for(Spell spell : spells){
            if(spell.getName().equals(search)){
                foundSpell = spell;
            }
        } return foundSpell;
    }

    public void cast(String spell, Enemy enemy){
        Spell activeSpell = getSpellByName(spell);
        if(activeSpell.getMP() <= getAP()) {
            int DMG = activeSpell.getATK();
            enemy.takeDMG(DMG);
            reduceAP(activeSpell.getMP());
            if (enemy.getHP() <= 0) {
                addGold(enemy.getGOLD());
            }
        }
    }

    public void learnSpell(Spell spell){
        if(spell.getAlignment().equals(type.getAlignment()) || spell.getAlignment().equals("N")){
            spells.add(spell);
        }
    }

    public void takeDMG(int DMG){
        this.HP -= DMG;
    }

    public void heal(int amount){
        if((this.HP + amount) > this.MAXHP){
            this.HP = this.MAXHP;
        } else {
            this.HP += amount;
        }
    }
}
