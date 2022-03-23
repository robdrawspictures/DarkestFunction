package behaviours;

import player_management.PlayerCharacter;
import resource_management.items.Item;

public interface IUse {

    public void useItem(Item item, PlayerCharacter ally);
}
