import java.util.Random;
import java.util.Scanner;

// This is a test for the entities encounters
public class EntitiesMethods2 {
	public static void main(String[] args) {
		
		String[] inventory = {"FISTS", "BASEBALL BAT", "--EMPTY--", "--EMPTY--"};
		int health = 100;
		health = entityEncounter(health, inventory);
		System.out.println("health: " + health);

	}

	public static int entityEncounter(int health, String[] inventory) {

		String current_entity = "";
		int entity_health = 0;
		int damage_player = 0;
		String entity_type = ""; //Hostile, or Neutral

		int r = (int)(Math.random() * (5 - 1 + 1) + 1);

		if (r == 1) {
			current_entity = "LIVING MANNEQUIN";
			entity_health = 30;
			damage_player = 7;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}	
		else if (r == 2) {
			current_entity = "SMILER";
			entity_health = 80;
			damage_player = 14;
			entity_type = "Neutral";

			getEntityDescription(current_entity, entity_health, entity_type);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		else if (r == 3) {
			current_entity = "SKIN-STEALER";
			entity_health = 65;
			damage_player = 18;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		else if (r == 4) {
			current_entity = "HOUND";
			entity_health = 50;
			damage_player = 23;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		else if (r == 5) {
			current_entity = "DEATHMOTH";
			entity_health = 60;
			damage_player = 21;
			entity_type = "Neutral";

			getEntityDescription(current_entity, entity_health, entity_type);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		return health;
	}

	public static void getEntityDescription(String current_entity, int entity_health, String entity_type) {

		System.out.println("\nENTITY ENCOUNTERED: " + current_entity);
		System.out.println("\nENTITY HEALTH: " + entity_health + "%");
		System.out.println("\nENTITY TYPE: " + entity_type);

		if (current_entity.equals("LIVING MANNEQUIN"))
			System.out.println(
				"\nA mannequin that resembles those typically found in department stores." + 
				"\nThey are normally hostile and will attack on sight. However, they are" +
				"\ngenerally easy to dispatch and can drop useful items.");
		else if (current_entity.equals("SMILER")) // Source: https://backrooms.fandom.com/wiki/Smilers
			System.out.println("\nSmilers are well known by their eerie luminescent smile." + 
				"\nThey mainly lurk in a level's dark areas. Because of this, it is often difficult to" +
				"\nidentify the rest of their physical features." + 
				"\nTherefore, be warned, they are often the most dangerous of entities" +
				"\nand will attack when provoked.");
		else if (current_entity.equals("SKIN-STEALER")) // Source: https://backrooms.fandom.com/wiki/Skin-Stealers
			System.out.println("\nSkin stealers are hostile entities that will normally attack wanderers" + 
				"\nwhen in a state of hunger. After killing their victims, they will absorb/eat the victim's" + 
				"\nflesh by \"wearing\" their skin. These entities are found on most levels and can imitate the " + 
				"\nvoices of human beings to lure potential victims.");
		else if (current_entity.equals("HOUND")) // Source: https://backrooms.fandom.com/wiki/Hounds
			System.out.println("\nHounds are hostile humanoids with animal-like characteristics." + 
				"\nThey are commonly found throughout much of the backrooms, are generally hostile" +
				"\ntowards wanderers, and will attack on sight. Be warned, like other entities, they are deadly." +
				"\nAs such, it is best to run or fend them off with long-ranged weapons.");
		else if (current_entity.equals("DEATHMOTH")) // Source: https://backrooms.fandom.com/wiki/Deathmoths
			System.out.println("\nDeathmoths resemble that of moths typically found in the normal world" +
				"\nwith the exception of their much larger appearances." + 
				"\nAlthough several deathmoths encounters have proven them to be neutral, they can still" + 
				"\nexhibit hostile tendancies including attacking those who wander close to their hives." + 
				"\nThese hives are typically found in certain levels and as such, the presence of deathmoths" + 
				"\nare higher and deadlier.");
	}

	public static int fightEntity(int health, String[] inventory, String current_entity) {
		Scanner input = new Scanner(System.in);

		System.out.println("\nDo you FLEE or FIGHT?");
		System.out.print("> ");
		String cmd = input.next();
		cmd = cmd.trim();

		String weapon = "";

		while (!cmd.equalsIgnoreCase("fight") && !cmd.equalsIgnoreCase("flee")) {
			System.out.print("> ");
			cmd = input.next();
			cmd = cmd.trim();
		}

		if (cmd.equalsIgnoreCase("fight")) {

			displayInventoryItems(inventory, "weapons");
			System.out.print("\nChoose an item: ");
			weapon = chooseItem();

			while (!verifyItem(inventory, weapon) || !isWeapon(weapon)) {
				System.out.println("Cannot use weapon");
				weapon = chooseItem();
			}

			health = playerFightEntity(health, weapon, current_entity);

		}
		else if (cmd.equalsIgnoreCase("flee")) {
			health = getFleeOutcome(health, current_entity);
		}

		return health;
	}
	
	public static String chooseItem() {
		Scanner input = new Scanner(System.in);
		String item = input.nextLine();
		item = item.trim();

		return item;
	}
	
	public static boolean verifyItem(String[] inv, String item) {
		boolean player_has_item = false;
		for (int i = 0; i < inv.length; i++) {
			if (inv[i].equalsIgnoreCase(item)) {
				player_has_item = true;
				break;
			}
		}
		return player_has_item;
	}
	
	public static boolean isWeapon(String weapon) {
		if (weapon.equalsIgnoreCase("fists") || weapon.equalsIgnoreCase("metal pipe") 
			|| weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket") ||
			weapon.equalsIgnoreCase("baseball bat"))
			return true;
		else 
			return false;
	}
	
	public static int getFleeOutcome(int health, String current_entity) {
		// flee outcomes
		if (current_entity.equals("SMILER"))
			System.out.println("\nWise choice\n");

		else if (current_entity.equalsIgnoreCase("DEATHMOTH")) {
			int health_lost = (int)(Math.random() * (10 - 7 + 1) + 7);
			health -= health_lost;
			System.out.println("\nHEALTH LOST: -" + (health_lost) + "%");
			System.out.println("\nDeathmoths can fly quickly." + 
				"\nIt outpaced you but you were able to lose it during the struggle\n");
		}

		else if (current_entity.equalsIgnoreCase("LIVING MANNEQUIN"))
			System.out.println("\nYou successfully ran from the mannequin." +
				"\nBut remember, they are also easy to take down\n");

		else if (current_entity.equalsIgnoreCase("SKIN-STEALER"))
			System.out.println("\nRunning was a good choice. Skin-stealers are unpleasant creatures\n");

		else if (current_entity.equalsIgnoreCase("HOUND"))
			System.out.println("\nYou walked away slowly and stayed calm until you were out of sight." + 
				"\nAfterwards, you ran as far as you could from the beast.\n");

		return health;
	}

	public static void displayInventoryItems(String[] inv, String item_type) {
		if (item_type.equalsIgnoreCase("weapons")) {
			System.out.println("\nWEAPONS: ");
			for (int i = 0; i < inv.length; i++) 
				if (inv[i].equalsIgnoreCase("fists") || inv[i].equalsIgnoreCase("metal pipe") ||
					inv[i].equalsIgnoreCase("chair leg") || inv[i].equalsIgnoreCase("tennis racket") ||
					inv[i].equalsIgnoreCase("baseball bat"))
				System.out.println(" - " + inv[i]);
		}
		else if (item_type.equalsIgnoreCase("health")) {
			System.out.println("\nHEALTH ITEMS: ");
			for (int i = 0; i < inv.length; i++) 
				if (inv[i].equalsIgnoreCase("almond water") || inv[i].equalsIgnoreCase("bandage") ||
					inv[i].equalsIgnoreCase("backshroom") || inv[i].equalsIgnoreCase("health pack"))
			System.out.println(" (+) " + inv[i]);
		}
	}

	public static boolean playerIsDead(int health) {
		if (health <= 0) 
		  	return true;
		else 
		  	return false;
	}

	public static int weaponDamage(String weapon) {
		int damage = 0;
		while (damage == 0) {
			if (weapon.equalsIgnoreCase("fists")) {
				damage = 10;
				break;
			}
			else if (weapon.equalsIgnoreCase("chair leg")) {
				damage = 17;
				break;
			}
			else if (weapon.equalsIgnoreCase("tennis racket")) {
				damage = 26;
				break;
			}
			else if (weapon.equalsIgnoreCase("metal pipe")) {
				damage = 34;
				break;
			}
			else if (weapon.equalsIgnoreCase("baseball bat")) {
				damage = 38;
				break;
			}
		}
		return damage;
	}

	public static int playerFightEntity(int health, String weapon, String current_entity) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();

		int enemy_health = 0;
		int enemy_damage = 0;

		if (current_entity.equalsIgnoreCase("LIVING MANNEQUIN")) {
			enemy_health = 30;
			enemy_damage = 7;
		}
		else if (current_entity.equalsIgnoreCase("SMILER")) {
			enemy_health = 80;
			enemy_damage = 14;
		}
		else if (current_entity.equalsIgnoreCase("SKIN-STEALER")) {
			enemy_health = 65;
			enemy_damage = 18;
		}
		else if (current_entity.equalsIgnoreCase("HOUND")) {
			enemy_health = 50;
			enemy_damage = 23;
		}
		else if (current_entity.equalsIgnoreCase("DEATHMOTH")) {
			enemy_health = 60;
			enemy_damage = 21;
		}

		int playerDamage = weaponDamage(weapon);

		while (enemy_health > 0) {

			System.out.println("\n" +
							   "> fight\n" +
							   "> flee");
			int enemyChance = rand.nextInt(100-1)+1;
			int playerChance = rand.nextInt(100-1)+1;
			String playerChoice = input.next();

			if (playerChoice.equalsIgnoreCase("fight")) {
				System.out.println("\nYou used your " + weapon);

				if (playerChance <= 5) {
					System.out.println("Your attack missed\n" +
									   "Your dealt zero damage");
					if (enemyChance <= 10) {
						System.out.println("The " + current_entity + "'s attack missed\n" +
										   "You received zero damage");
					}
					else if (enemyChance > 10 && enemyChance < 99) {
						System.out.println("You received " + enemy_damage + " damage from the " + current_entity);
						health -= enemy_damage;
					}
					else if (enemyChance == 100) {
						System.out.println("You received critical damage from the " + current_entity);
						health -= enemy_damage * 1.5;
					}
				}

				else if (playerChance > 5 && playerChance <= 90) {
					System.out.println("You were able to hit the " + current_entity + "!\n" +
									   "You dealt " + playerDamage + " damage to the enemy!");
					enemy_health -= playerDamage;
					if (enemyChance <= 10) {
						System.out.println("The " + current_entity + "'s attack missed\n" +
										 "You received zero damage");
					}
					else if (enemyChance > 10 && enemyChance < 99) {
						System.out.println("You received " + enemy_damage + " damage from the " + current_entity);
						health -= enemy_damage;
					}
					else if (enemyChance == 100) {
						System.out.println("You received critical damage from the " + current_entity);
						health -= enemy_damage * 1.5;
					}
				}

				else if (playerChance > 90) {
					System.out.println("You dealt a critical hit!");
					enemy_health -= playerDamage * 2;
					if (enemyChance <= 10) {
						System.out.println("The " + current_entity + "'s attack missed\n" +
										 "You received zero damage");
					}
					else if (enemyChance > 10 && enemyChance < 99) {
						System.out.println("You received " + enemy_damage + " damage from the " + current_entity);
						health -= enemy_damage;
					}
					else if (enemyChance == 100) {
						System.out.println("You received critical damage from the " + current_entity);
						health -= enemy_damage * 1.5;
					}
				}

				if (enemy_health < 0) {
					enemy_health = 0;
				}
				if (health < 0) {
					health = 0;
				}

				System.out.println();
				System.out.println(current_entity + " Health: " + enemy_health + "%");
				System.out.println("Player Health: " + health + "%");

				if (enemy_health <= 0) {
					break;
				}
				else if (health <= 0) {
					break;
				}
			}

			else if (playerChoice.equalsIgnoreCase("flee")) {
				fleeOutcome(health, current_entity);
				return health;
			}
		}

		if (enemy_health <= 0) {
			System.out.println(" ");
			System.out.println("You have defeated the " + current_entity);
			System.out.println("You may now proceed.\n");
		}
		else if (health <= 0) {
			System.out.println();
			System.out.println("The " + current_entity + " defeated you\n");
		}
		return health;
	}

	public static void fleeOutcome(int health, String current_entity) {

		if (current_entity.equals("SMILER")) {
			System.out.println("\nWise choice\n" +
							   "\nPlayer Health: " + health);
		}

		else if (current_entity.equalsIgnoreCase("LIVING MANNEQUIN")) {
			System.out.println("\nYou successfully ran from the mannequin.\n" +
							   "But remember, they are also easy to take down\n" +
							   "\nPlayer Health: " + health);
		}

		else if (current_entity.equalsIgnoreCase("SKIN-STEALER")) { 
			System.out.println("\nRunning was a good choice. Skin-stealers are unpleasant creatures\n" +
							   "\nPlayer Health: " + health);
		}

		else if (current_entity.equalsIgnoreCase("HOUND")) {
			System.out.println("\nYou walked away slowly and stayed calm until you were out of sight.\n" + 
							   "Afterwards, you ran as far as you could from the beast.\n" +
							   "\nPlayer Health: " + health);
		}

		else if (current_entity.equalsIgnoreCase("DEATHMOTH")) {
			System.out.println("\nDeathmoths can fly quickly.\n" + 
							   "It outpaced you but you were able to lose it during the struggle\n" +
							   "\nPlayer Health: " + health);
		}
	}
}
