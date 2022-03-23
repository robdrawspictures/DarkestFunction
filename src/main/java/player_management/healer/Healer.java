package player_management.healer;

import player_management.PlayerCharacter;
import player_management.mage.ICast;
import resource_management.items.Item;
import resource_management.spells.Spell;

import java.util.ArrayList;

public class Healer extends PlayerCharacter implements ICast, IUse {

    private int INT;
    private ArrayList<Item> items;
    private ArrayList<Spell> spells;

    public Healer(String name, int HP, int AP, int gold, int INT, ArrayList<Item> items, ArrayList<Spell> spells) {
        super(name, HP, AP, gold);
        this.INT = INT;
        this.items = items;
        this.spells = spells;
    }

    public void useItem(Item item){

    }

    public void castSpell(Spell spell){

    }
}
