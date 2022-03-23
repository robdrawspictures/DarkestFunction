package player_management.mage;

import beast_management.Beast;
import resource_management.spells.Spell;

import java.util.ArrayList;

public class Mage {

    private int INT;
    private ArrayList<Spell> spells;
    private Beast mount;

    public Mage(int INT, ArrayList<Spell> spells, Beast mount) {
        this.INT = INT;
        this.spells = spells;
        this.mount = mount;
    }
}
