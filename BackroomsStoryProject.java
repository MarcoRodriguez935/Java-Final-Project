import java.util.Scanner;

// name, health, inventory, levels_passed, entities_encountered
// ^ These variables might be passed through most methods/levels so we can just copy and paste
// from here

public class BackroomsStoryProject {
	public static void main(String[] args) {
	  	Scanner input = new Scanner(System.in);
	    
	    // Runs the help program
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase("-help")) {
		    	runHelpProgram();
		    }
		}

		String name = readName();
		introMessage(name);

		System.out.print("Enter any key to begin: ");
		char key = input.next().charAt(0);

		System.out.println();


		// Stats to be updated every level
		int health = 100;

		String[] inventory = {"FISTS", "--EMPTY--", "--EMPTY--", "--EMPTY--", "--EMPTY--", "--EMPTY--"};


		String[] levels_passed = {"???", "???", "???", "???", "???", "???"};

		String[] entities_encountered = {"???", "???", "???", "???", "???", "???"};

		// Start first level
		level1(name, health, inventory, levels_passed, entities_encountered);

		// displayFinalResults(name, health, inventory, entities_encountered, 
		// levels_passed);

	}


	public static void level1(String name, int health, String[] inventory, 
		String[] levels_passed, String[] entities_encountered) {

		System.out.println("LEVEL 1\n");

		currentStats(name, health, inventory);

		readCommand(inventory);

		String current_level = "Level 1";
		updateElementsPassed(levels_passed, current_level);


		health = entityEncounter(health, inventory, current_level, entities_encountered);

	}

	public static void final_level(String name, int health, String[] inventory) {
	  	return;
	}
	
	// ---------- PLAYER STATS / GAMEPLAY METHODS ----------
	
	public static void readCommand(String[] inv) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter CONTINUE to proceed or CMDS for a list of commands");

		String command = "";

		do {
			System.out.print("> ");
			command = input.nextLine();
			command = command.trim();

			if (command.equalsIgnoreCase("fight") || command.equalsIgnoreCase("flee")) {
				System.out.println("\nPlayer is not currently engaging an entity\n");
			}
			else if (command.equalsIgnoreCase("inventory")) {
				System.out.println("\nInventory: ");
				displayList(inv);
				System.out.println();
			}
			else if (command.equalsIgnoreCase("cry")) {
				System.out.println("TODO");
			}
			else if (command.equals("cmds")) {
				System.out.println("\nTo proceed: > continue");
				System.out.println("To fight an entity: > fight");
				System.out.println("To flee from an entity: > flee");
				System.out.println("To select an item when prompted: > item_name");
				System.out.println("To display the inventory: > inventory");
				System.out.println("To cry: > cry");
				System.out.println("To display this list of commands: > cmds");
				System.out.println();
			}
		} while (!command.equalsIgnoreCase("continue"));
	}
	
	public static String chooseItem() {
		Scanner input = new Scanner(System.in);
		System.out.print("> ");
		String item = input.nextLine();
		item = item.trim();

		return item;
	}

	public static void currentStats(String player_name, int health, String[] inventory) {

		System.out.println("----------" + player_name + "----------");
		System.out.println("\nHealth: " + health + "%");
		System.out.println("\nInventory: ");

		displayList(inventory);

		System.out.println();
	}
	
	public static void displayFinalResults(String name, int health, String[] inventory, 
	  	String[] entities_encountered, String[] levels_passed) {

	  	System.out.println("\n---------PLAYER REPORT---------");

	  	String player_outcome = "";
	  	String player_status = "";

	  	if (health <= 0) {
	  		health = 0;
	  		player_outcome = "\nVictim: ";
	  		player_status = "Dead";
	  	}
	  	else {
	  		player_outcome = "\nSurvivor: ";
	  		player_status = "Alive";
	  	}

	  	System.out.println(player_outcome + name);
	  	System.out.println("\nHealth: " + health + "%");
	  	System.out.println("\nStatus: " + player_status);

	  	System.out.println("\nInventory: ");
	  	displayList(inventory);

	  	System.out.println("\nLevels Traversed: ");
	  	displayList(levels_passed);

	  	System.out.println("\nEntities Encountered: ");
	  	displayList(entities_encountered);

	  	System.out.println();

	  	if (playerIsDead(health)) {
	  		deathScreen();
	  	}
	  	else 
	  		victoryScreen();
	}
	
	public static String[] updateElementsPassed(String[] element_list, String current_element) {
		for (int i = 0; i < element_list.length; i++) {
			if (element_list[i].equals("???")) {
				element_list[i] = current_element;
				break;
			}	
		}
		return element_list;
	}

	// ---------- HEALTH METHODS ----------
	
	public static boolean playerIsDead(int health) {
		if (health <= 0) 
		  	return true;
		else 
		  	return false;
	}
	
	public static boolean lowHealth(int health) {
		if (health < 50 && health > 0)
			return true;
		else 
			return false;
	}
	
	public static int heal(int health, String[] inventory) {
		displayInventoryItems(inventory, "health");
		System.out.println("\nChoose an item:");
		String health_item = chooseItem();

		while (!verifyItem(inventory, health_item) || !isHealthItem(health_item)) {
			health_item = chooseItem();
		}
		if (health_item.equalsIgnoreCase("almond water")) {
			health += 20;
			removeFromInventory(inventory, health_item);
			System.out.println("\nHEALTH ADDED: +20%");
		}
		else if (health_item.equalsIgnoreCase("backshroom")) {
			health += 30;
			removeFromInventory(inventory, health_item);
			System.out.println("\nHEALTH ADDED: +30%");
		}
		else if (health_item.equalsIgnoreCase("bandage")) {
			health += 40;
			removeFromInventory(inventory, health_item);
			System.out.println("\nHEALTH ADDED: +40%");
		}
		else if (health_item.equalsIgnoreCase("health pack")) {
			health += 50;
			removeFromInventory(inventory, health_item);
			System.out.println("\nHEALTH ADDED: +50%");
		}

		if (health > 100) 
			health = 100;

		System.out.println("\nCurrent Health: " + health + "%");
		System.out.println();
		return health;
	}
	
	// ---------- INVENTORY / ARRAY METHODS ----------

	public static void displayList(String[] list) {
		for (int i = 0; i < list.length; i++) {
				System.out.println(" " + (i+1) + ")  " + list[i]);
		}
	}

	public static String[] addToInventory(String[] inv, String addition) {
		for (int i = 0; i < inv.length; i++) {
			if (inv[i].equals("--EMPTY--")) {
				inv[i] = addition;
				break;
			}
		}
		return inv;
	}
	
	public static String[] removeFromInventory(String[] inv, String remove) {

		if (remove.equals("FISTS")) {
			System.out.println("Cannot drop item: FISTS");
		}
		else {
			for (int i = 0; i < inv.length; i++) {
				if (inv[i].equalsIgnoreCase(remove)) {
					inv[i] = "--EMPTY--";
					break;
				}
			}
		}	
		return inv;
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
	
	// ---------- ITEM METHODS ----------
	
	public static boolean isWeapon(String weapon) {
		if (weapon.equalsIgnoreCase("fists") || weapon.equalsIgnoreCase("metal pipe") 
			|| weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket") ||
			weapon.equalsIgnoreCase("baseball bat"))
			return true;
		else 
			return false;
	}
	
	public static boolean isHealthItem(String item) {
		if (item.equalsIgnoreCase("almond water") || item.equalsIgnoreCase("bandage") ||
			item.equalsIgnoreCase("backshroom") || item.equalsIgnoreCase("health pack"))
			return true;
		else
			return false;
	}
	
	public static boolean hasHealthItems(String[] inv) {
		boolean has_health_items = false;

		for (int i = 0; i < inv.length; i++) {
			if (inv[i].equalsIgnoreCase("almond water") || inv[i].equalsIgnoreCase("bandage") ||
				inv[i].equalsIgnoreCase("backshroom") || inv[i].equalsIgnoreCase("health pack")) {
				has_health_items = true;
				break;
			}	
		}
		return has_health_items;
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
	
	public static boolean isValidItem(String item) {
		if (item.equalsIgnoreCase("metal pipe") || item.equalsIgnoreCase("chair leg") ||
			item.equalsIgnoreCase("tennis racket") || item.equalsIgnoreCase("baseball bat") ||
			item.equalsIgnoreCase("almond water") || item.equalsIgnoreCase("bandage") ||
			item.equalsIgnoreCase("backshroom") || item.equalsIgnoreCase("health pack")) {
			return true;
		} 
		else
			return false;
	}
	
	// ---------- ENTITIES METHODS ----------
	
	// entityEncounter(health, inventory, current_level, entities_encountered);
	public static int entityEncounter(int health, String[] inventory, String current_level, 
		String[] entities_encountered) {

		String current_entity = "";
		int entity_health = 0;
		String entity_type = ""; //Hostile, or Safe

		if (current_level.equals("Level 1")) {
			current_entity = "LIVING MANNEQUIN";
			entity_health = 50;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}	
		else if (current_level.equals("Level 2")) {
			current_entity = "SMILER";
			entity_health = 200;
			entity_type = "Neutral";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		else if (current_level.equals("Level 3")) {
			current_entity = "SKIN-STEALER";
			entity_health = 140;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		else if (current_level.equals("Level 4")) {
			current_entity = "HOUND";
			entity_health = 120;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		else if (current_level.equals("Level 5")) {
			current_entity = "DEATHMOTH";
			entity_health = 140;
			entity_type = "Neutral";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		return health;
	}

	public static void getEntityDescription(String current_entity, int entity_health,
		String entity_type) {

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
			System.out.println("\nChoose an item:");
			weapon = chooseItem();

			while (!verifyItem(inventory, weapon) || !isWeapon(weapon)) {
				weapon = chooseItem();
			}

			health = getFightOutcome(health, weapon, current_entity);

		}
		else if (cmd.equalsIgnoreCase("flee")) {
			health = getFleeOutcome(health, current_entity);
		}

		return health;
	}
	
	public static int getFightOutcome(int health, String weapon, String current_entity) {

		int health_lost = 0;

		// mannequin outcomes
		if (current_entity.equals("LIVING MANNEQUIN")) {
			if (weapon.equalsIgnoreCase("fists"))
				health_lost += (int)(Math.random() * (5 - 3 + 1) + 3);
			else if (weapon.equalsIgnoreCase("metal pipe") || weapon.equalsIgnoreCase("chair leg") ||
				weapon.equalsIgnoreCase("tennis racket") || weapon.equalsIgnoreCase("baseball bat"))
				health_lost += 0;
		}

		// smiler outcomes
		else if (current_entity.equalsIgnoreCase("SMILER")) {
			if (weapon.equalsIgnoreCase("fists") || weapon.equalsIgnoreCase("metal pipe") ||
				weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket") ||
				weapon.equalsIgnoreCase("baseball bat"))
				health_lost += (int)(Math.random() * (90 - 75 + 1) + 75);
		}

		// skin-stealer outcomes
		else if (current_entity.equalsIgnoreCase("SKIN-STEALER")) {
			if (weapon.equalsIgnoreCase("fists"))
				health_lost += (int)(Math.random() * (50 - 40 + 1) + 40);
			else if (weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket"))
				health_lost += (int)(Math.random() * (40 - 35 + 1) + 35);
			else if (weapon.equalsIgnoreCase("metal pipe") || weapon.equalsIgnoreCase("baseball bat"))
				health_lost += (int)(Math.random() * (25 - 20 + 1) + 20);
		}

		// hound outcomes
		else if (current_entity.equalsIgnoreCase("HOUND")) {
			if (weapon.equalsIgnoreCase("fists"))
				health_lost += (int)(Math.random() * (50 - 45 + 1) + 45);
			else if (weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket"))
				health_lost += (int)(Math.random() * (30 - 25 + 1) + 25);
			else if (weapon.equalsIgnoreCase("metal pipe") || weapon.equalsIgnoreCase("baseball bat"))
				health_lost += (int)(Math.random() * (15 - 10 + 1) + 10);
		}

		else if (current_entity.equalsIgnoreCase("DEATHMOTH")) {
			if (weapon.equalsIgnoreCase("fists"))
				health_lost += (int)(Math.random() * (60 - 55 + 1) + 55);
			else if (weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket"))
				health_lost += (int)(Math.random() * (35 - 30 + 1) + 30);
			else if (weapon.equalsIgnoreCase("metal pipe") || weapon.equalsIgnoreCase("baseball bat"))
				health_lost += (int)(Math.random() * (15 - 10 + 1) + 10);
		}

		System.out.println("\nHEALTH LOST: -" + health_lost + "%");

		health -= health_lost;

		if (playerIsDead(health)) {
			System.out.println("\nYou did not survive.\n");
			return health;
		}
		else {
			if (health >= 90)
				System.out.println("\nYou successfully dispatched the " + current_entity + "." +
					"\nYou may now proceed\n");
			else if (health >= 60)
				System.out.println("\nYou were able to fend off the " + current_entity + "." +
					"\nProceed with caution\n");
			else if (health >= 30)
				System.out.println("\nYou fought the " + current_entity + "." +
					"\nAlthough there was an struggle, at least you're still in one piece\n");
			else if (health >= 15)
				System.out.println("\nYou won, but you can't keep this up for much longer\n");
			else if (health > 0) 
				System.out.println("\nYou underestimated it");
		}
		return health;	
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
				"\nAfterwards, you ran as far as you could from the beast.");

		return health;
	}
	
	// ---------- MISC METHODS ----------
	
	public static String readName() {
	  	Scanner input = new Scanner(System.in);

		System.out.print("Enter your name: ");
		String name = input.nextLine();
		name = name.trim();

		return name;
	}

	public static void introMessage(String name) {

		System.out.println();
		System.out.println("Hello " + name + ",");
		System.out.println("You were having a normal day when you tripped and suddenly noclipped through " +
		    "the ground in broad daylight.");
		System.out.println("You are now in an unknown place.\nThere is nothing ahead but an endless number " +
		    "of seemingly randomly generated rooms enough to make anyone go insane.\nThis place does not seem real," + 
		    " you stand in disbelief as you don't understand how this is real.");
		System.out.println("The same questions linger in your thoughts nonstop.");
		System.out.println("Are you alone? Perhaps stuck here forever? Only time can tell.");
		System.out.println("Still, there's no guarantee time even exists here");
		System.out.println("\nWelcome to your final resting place.......");
		System.out.println();

		displayTitle();
	}

	public static void displayTitle() {
		System.out.println();

		System.out.println(
		    "▄▄▄█████▓██░ ██▓█████     ▄▄▄▄   ▄▄▄      ▄████▄  ██ ▄█▀██▀███  ▒█████  ▒█████  ███▄ ▄███▓ ██████    ");
		System.out.println(
		    "▓  ██▒ ▓▓██░ ██▓█   ▀    ▓█████▄▒████▄   ▒██▀ ▀█  ██▄█▒▓██ ▒ ██▒██▒  ██▒██▒  ██▓██▒▀█▀ ██▒██    ▒    ");
		System.out.println(
		    "▒ ▓██░ ▒▒██▀▀██▒███      ▒██▒ ▄█▒██  ▀█▄ ▒▓█    ▄▓███▄░▓██ ░▄█ ▒██░  ██▒██░  ██▓██    ▓██░ ▓██▄      ");
		System.out.println(
		    "░ ▓██▓ ░░▓█ ░██▒▓█  ▄    ▒██░█▀ ░██▄▄▄▄██▒▓▓▄ ▄██▓██ █▄▒██▀▀█▄ ▒██   ██▒██   ██▒██    ▒██  ▒   ██▒   ");
		System.out.println(
		    "  ▒██▒ ░░▓█▒░██░▒████▒   ░▓█  ▀█▓▓█   ▓██▒ ▓███▀ ▒██▒ █░██▓ ▒██░ ████▓▒░ ████▓▒▒██▒   ░██▒██████▒▒   ");
		System.out.println(
		    "  ▒ ░░   ▒ ░░▒░░░ ▒░ ░   ░▒▓███▀▒▒▒   ▓▒█░ ░▒ ▒  ▒ ▒▒ ▓░ ▒▓ ░▒▓░ ▒░▒░▒░░ ▒░▒░▒░░ ▒░   ░  ▒ ▒▓▒ ▒ ░   ");
		System.out.println(
		    "    ░    ▒ ░▒░ ░░ ░  ░   ▒░▒   ░  ▒   ▒▒ ░ ░  ▒  ░ ░▒ ▒░ ░▒ ░ ▒░ ░ ▒ ▒░  ░ ▒ ▒░░  ░      ░ ░▒  ░ ░   ");
		System.out.println(
		    "  ░      ░  ░░ ░  ░       ░    ░  ░   ▒  ░       ░ ░░ ░  ░░   ░░ ░ ░ ▒ ░ ░ ░ ▒ ░      ░  ░  ░  ░     ");
		System.out.println(
		    "         ░  ░  ░  ░  ░    ░           ░  ░ ░     ░  ░     ░        ░ ░     ░ ░        ░        ░     ");
		System.out.println(
		    "                               ░         ░                                                           ");

		System.out.println();
	}

	public static void deathScreen() {
		System.out.println("  ▄████ ▄▄▄      ███▄ ▄███▓█████     ▒█████  ██▒   █▓█████ ██▀███  ");
		System.out.println(" ██▒ ▀█▒████▄   ▓██▒▀█▀ ██▓█   ▀    ▒██▒  ██▓██░   █▓█   ▀▓██ ▒ ██▒");
		System.out.println("▒██░▄▄▄▒██  ▀█▄ ▓██    ▓██▒███      ▒██░  ██▒▓██  █▒▒███  ▓██ ░▄█ ▒");
		System.out.println("░▓█  ██░██▄▄▄▄██▒██    ▒██▒▓█  ▄    ▒██   ██░ ▒██ █░▒▓█  ▄▒██▀▀█▄  ");
		System.out.println("░▒▓███▀▒▓█   ▓██▒██▒   ░██░▒████▒   ░ ████▓▒░  ▒▀█░ ░▒████░██▓ ▒██▒");
		System.out.println(" ░▒   ▒ ▒▒   ▓▒█░ ▒░   ░  ░░ ▒░ ░   ░ ▒░▒░▒░   ░ ▐░ ░░ ▒░ ░ ▒▓ ░▒▓░");
		System.out.println("  ░   ░  ▒   ▒▒ ░  ░      ░░ ░  ░     ░ ▒ ▒░   ░ ░░  ░ ░  ░ ░▒ ░ ▒░");
		System.out.println("░ ░   ░  ░   ▒  ░      ░     ░      ░ ░ ░ ▒      ░░    ░    ░░   ░ ");
		System.out.println("      ░      ░  ░      ░     ░  ░       ░ ░       ░    ░  ░  ░     ");
		System.out.println("                                                 ░                 ");
	}

	public static void victoryScreen() {
		System.out.println("▓██   ██▓▒█████  █    ██    ▓█████  ██████ ▄████▄  ▄▄▄      ██▓███ ▓█████▓█████▄ ");
		System.out.println(" ▒██  ██▒██▒  ██▒██  ▓██▒   ▓█   ▀▒██    ▒▒██▀ ▀█ ▒████▄   ▓██░  ██▓█   ▀▒██▀ ██▌");
		System.out.println("  ▒██ ██▒██░  ██▓██  ▒██░   ▒███  ░ ▓██▄  ▒▓█    ▄▒██  ▀█▄ ▓██░ ██▓▒███  ░██   █▌");
		System.out.println("  ░ ▐██▓▒██   ██▓▓█  ░██░   ▒▓█  ▄  ▒   ██▒▓▓▄ ▄██░██▄▄▄▄██▒██▄█▓▒ ▒▓█  ▄░▓█▄   ▌");
		System.out.println("  ░ ██▒▓░ ████▓▒▒▒█████▓    ░▒████▒██████▒▒ ▓███▀ ░▓█   ▓██▒██▒ ░  ░▒████░▒████▓ ");
		System.out.println("   ██▒▒▒░ ▒░▒░▒░░▒▓▒ ▒ ▒    ░░ ▒░ ▒ ▒▓▒ ▒ ░ ░▒ ▒  ░▒▒   ▓▒█▒▓▒░ ░  ░░ ▒░ ░▒▒▓  ▒ ");
		System.out.println(" ▓██ ░▒░  ░ ▒ ▒░░░▒░ ░ ░     ░ ░  ░ ░▒  ░ ░ ░  ▒    ▒   ▒▒ ░▒ ░     ░ ░  ░░ ▒  ▒ ");
		System.out.println(" ▒ ▒ ░░ ░ ░ ░ ▒  ░░░ ░ ░       ░  ░  ░  ░ ░         ░   ▒  ░░         ░   ░ ░  ░ ");
		System.out.println(" ░ ░        ░ ░    ░           ░  ░     ░ ░ ░           ░  ░          ░  ░  ░    ");
		System.out.println(" ░ ░                                      ░                               ░      ");
	}
	
	public static void runHelpProgram() {
	  	System.out.println("\n----------Description----------");
	  	System.out.println("This game is heavily influenced by the expansive lore of the backrooms." + 
	  	    "\nIn short, the backrooms is an alternate dimension that victims enter by\n\"noclipping\"" +
	  	    " out of our reality.\nThe backrooms are characterized by its almost limitless number of random levels."
	  	    + "\nThese levels can lead to subequent ones leading to your escape." + 
	  	    "\nOr, if you're unlucky, can take you to undesirable locations.");
	  	System.out.println("\n----------Instructions----------");
	  	System.out.println("This project mainly incorporates the survival aspect of the backrooms" + 
	  			"\nYou will have to traverse through each room and fight any entities you encounter." + 
	  			"\nYou may also come across useful items that serve as weapons/health items." +
	  			"\nIn the end, there will be a final level in which you can either escape the backrooms or be" + 
	  			"\nstuck there forever");
	  	System.out.println("\n----------GAMEPLAY----------");
	  	System.out.println("The game is highly menu driven. You will be shown a layout of the rooms\n" +
				  "and will be presented with several options");
		System.out.println("Move: Move forward in (N/S/E/W) directions");
		System.out.println("Search: Observe your surroundings and identify items");
		System.out.println("Inventory: View and interact with your inventory");
		System.out.println("Cry: Cry and hope that the backrooms will let you leave (highly unlikely but not impossible)");

	  	System.exit(1);
	}
}
