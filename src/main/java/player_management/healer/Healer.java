package player_management.healer;

import beast_management.enemy.Enemy;
import behaviours.ICast;
import behaviours.IUse;
import player_management.PlayerCharacter;
import resource_management.items.Item;
import resource_management.spells.Spell;

import java.util.ArrayList;

public class Healer extends PlayerCharacter implements ICast, IUse{

    private int MAXHP;
    private int HP;
    private int INT;
    private HealerType type;
    private ArrayList<Item> items;
    private ArrayList<Spell> spells;

    public Healer(String name, HealerType type, ArrayList<Item> items, ArrayList<Spell> spells) {
        super(name);
        this.MAXHP = 50;
        this.HP = 50;
        this.INT = 1;
        this.type = type;
        this.items = items;
        this.spells = spells;
    }

    public int itemCount(){
        return items.size();
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void useItem(Item item, PlayerCharacter ally){
        ally.heal(item.getProperties());
        removeItem(item);
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
        this.HP += amount;
    }
}
