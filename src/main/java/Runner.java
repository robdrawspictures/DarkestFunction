import beast_management.BeastType;
import beast_management.enemy.Enemy;
import player_management.PlayerCharacter;
import player_management.warrior.Warrior;
import player_management.warrior.WarriorType;
import resource_management.weapons.Weapon;
import resource_management.weapons.WeaponType;
import room_management.Room;
import treasure.Chest;
import treasure.Treasure;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Weapon axe = new Weapon(WeaponType.AXE);

        Warrior player1 = new Warrior("Guts", WarriorType.BARBARIAN, axe);
        Enemy enemy1 = new Enemy(BeastType.BIGHORSE, 10, 10, 50);
        Treasure loot = new Chest("Stone Mask", 25);

        Room dungeon = new Room(player1, enemy1, loot);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your doom.");

        while(player1.getHP() > 0){
            System.out.println("You find yourself in a dark room with " + enemy1.getType());
            System.out.println("Nearby you see the " + loot.getName());
            System.out.println("You estimate it's value to be " + loot.getValue());
            System.out.println("Will you: (a)ttack the enemy, or (s)neak past and steal the treasure?");

            String response1 = scanner.nextLine();
            System.out.println(response1);

            if(response1.equals("s")){
                double randomNumber = Math.floor(Math.random() * (10 - 1) + 1);
                if(randomNumber >= 5){
                    player1.addGold(loot.getValue());
                    System.out.println("Treasure get!");
                    System.out.println("You leave the dungeon with " + player1.getGold() + "gold.");

                    System.out.println("A winner is you!");
                    break;
                }
                else{
                    enemy1.attack(player1);
                    System.out.println("Sneak failed. The enemy has noticed and attacked you.");
                    System.out.println("You have " + player1.getHP() + "HP.");
                    System.out.println("Will you: (a)ttack, or (b)eat it?");
                    response1 = scanner.nextLine();
                }
            }

            if(response1.equals("a")){
                while(player1.getHP() > 0 && enemy1.getHP() > 0){
                    if(response1.equals("a")){
                    System.out.println("You swing your " + axe.getType() + " with gusto!");
                    player1.attack(enemy1);
                    System.out.println("You deal " + player1.getSTR() + " damage!");
                    if(enemy1.getHP() > 0){
                        System.out.println("Enemy has " + enemy1.getHP() + "HP.");
                        enemy1.attack(player1);
                        System.out.println("Enemy attacks! You take " + enemy1.getSTR() + " damage.");
                        System.out.println("You have " + player1.getHP() + "HP.");
                        System.out.println("Will you: (a)ttack the enemy, or (b)eat it?");
                        response1 = scanner.nextLine();}
                    else{
                        break;
                    }
                } if(response1.equals("b")) {
                        double randomNumber = Math.floor(Math.random() * (10 - 1) + 1);
                        if(randomNumber <= 3){
                        System.out.println("You turn your back and begin to run.");
                        System.out.println(enemy1.getType() + " attacks as you flee. You die a coward's death.");
                        break;}
                        else if(randomNumber >= 4 || randomNumber <= 7){
                            System.out.println("There is little honour in fleeing, but the dead care little for honour.");
                            break;
                        }
                        else{
                            enemy1.attack(player1);
                            System.out.println(enemy1.getType() + " cuts off your escape and attacks!");
                            System.out.println("You have " + player1.getHP() + "HP.");
                            System.out.println("Will you: (a)ttack, or (b)eat it?");
                            response1 = scanner.nextLine();
                        }
                    }
                }
                if(enemy1.getHP() <= 0) {
                    System.out.println("Enemy defeated!");
                    player1.addGold(loot.getValue());
                    System.out.println("Treasure get!");
                    System.out.println("You leave the dungeon with " + player1.getGold() + " gold. The tavern beckons.");

                    System.out.println("A WINNER IS YOU");
                } else if(enemy1.getHP() > 0){
                    System.out.println("NEUTRAL END");
                } else {
                    System.out.println("GAME OVER");
                }
                break;
            }


        }
    }
}
