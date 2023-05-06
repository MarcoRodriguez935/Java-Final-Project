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

		String[] inventory = {"FISTS", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"};


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



		String current_level = "Level 1";
		updateElementsPassed(levels_passed, current_level);


		health = entityEncounter(health, inventory, current_level, entities_encountered);

	}

	public static void final_level(String name, int health, String[] inventory) {
	  	return;
	}



	public static void currentStats(String player_name, int health, String[] inventory) {

		System.out.println("----------" + player_name + "----------");
		System.out.println("\nHealth: " + health + "%");
		System.out.println("\nInventory: ");

		displayList(inventory);

		System.out.println();
	}

	public static boolean playerIsDead(int health) {
		if (health <= 0) 
		  	return true;
		else 
		  	return false;
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

	public static void displayList(String[] list) {
		for (int i = 0; i < list.length; i++) {
				System.out.println(" " + (i+1) + ")  " + list[i]);
		}
	}

	public static String[] addToInventory(String[] inv, String addition) {
		for (int i = 0; i < inv.length; i++) {
			if (inv[i].equals("EMPTY")) {
				inv[i] = addition;
				break;
			}
		}
		return inv;
	}
	
	public static String[] removeFromInventory(String[] inv, String remove) {

		if (remove.equals("FISTS")) {
			System.out.println("Cannot drop item: " + remove);
		}
		else {
			for (int i = 0; i < inv.length; i++) {
				if (inv[i].equals(remove)) {
					inv[i] = "EMPTY";
					break;
				}
			}
		}	
		return inv;
	}
	
	public static void displayInventoryItems(String[] inv, String item_type) {
		if (item_type.equals("weapons")) {
			System.out.println("\nWEAPONS: ");
			for (int i = 0; i < inv.length; i++) 
				if (inv[i].equalsIgnoreCase("fists") || inv[i].equalsIgnoreCase("weapon1") ||
					inv[i].equalsIgnoreCase("weapon2") || inv[i].equals("weapon3"))
				System.out.println(" - " + inv[i]);
		}
		else if (item_type.equals("health")) {
			System.out.println("\nHEALTH ITEMS: ");
			for (int i = 0; i < inv.length; i++) 
				if (inv[i].equalsIgnoreCase("almond water") || inv[i].equalsIgnoreCase("bandage") ||
					inv[i].equalsIgnoreCase("health pack"))
			System.out.println(" (+) " + inv[i]);
		}
	}
	
	public static String chooseItem() {
		Scanner input = new Scanner(System.in);
		System.out.print("> ");
		String item = input.nextLine();
		item = item.trim();

		while (!item.equalsIgnoreCase("fists") && !item.equalsIgnoreCase("weapon1")
			&& !item.equalsIgnoreCase("weapon2") && !item.equalsIgnoreCase("weapon3")
			&& !item.equalsIgnoreCase("almond water") && !item.equalsIgnoreCase("bandage")
			&& !item.equalsIgnoreCase("health pack")) {
			System.out.print("> ");
			item = input.nextLine();
			item = item.trim();
		}

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
	
	// entityEncounter(health, inventory, current_level, entities_encountered);
	public static int entityEncounter(int health, String[] inventory, String current_level, 
		String[] entities_encountered) {

		String current_entity = "";
		int entity_health = 0;
		String entity_type = ""; //Hostile, or Safe

		if (current_level.equals("Level 1")) {
			current_entity = "REANIMATED CORPSE";
			entity_health = 70;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity, entity_health);
			return health;
		}	
		else if (current_level.equals("Level 2")) {
			current_entity = "SMILER";
			entity_health = 200;
			entity_type = "Neutral";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity, entity_health);
			return health;
		}
		else if (current_level.equals("Level 3")) {
			current_entity = "SKIN-STEALER";
			entity_health = 120;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity, entity_health);
			return health;
		}
		else if (current_level.equals("Level 4")) {
			current_entity = "Entity 4";
			entity_health = 120;
			entity_type = "Neutral";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity, entity_health);
			return health;
		}
		else if (current_level.equals("Level 5")) {
			current_entity = "DEATHMOTH";
			entity_health = 140;
			entity_type = "Neutral";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity, entity_health);
			return health;
		}
		return health;
	}

	public static void getEntityDescription(String current_entity, int entity_health,
		String entity_type) {

		System.out.println("\nENTITY ENCOUNTERED: " + current_entity);
		System.out.println("\nENTITY HEALTH: " + entity_health + "%");
		System.out.println("\nENTITY TYPE: " + entity_type);

		if (current_entity.equals("REANIMATED CORPSE"))
			System.out.println("\nA recently deceased wanderer of the backrooms." + 
				"\nThey do not pose a significant threat and can be taken down easily." + 
				"\nHowever, be cautious if there are more than one of them.");
		else if (current_entity.equals("SMILER"))
			System.out.println("\nDescription for SMILER");
		else if (current_entity.equals("SKIN-STEALER"))
			System.out.println("\nDescription for Entity 3");
		else if (current_entity.equals("Entity 4"))
			System.out.println("\nDescription for Entity 4");
		else if (current_entity.equals("DEATHMOTH"))
			System.out.println("\nDescription for Entity 5");
	}

	public static int fightEntity(int health, String[] inventory, String current_entity, 
		int entity_health) {
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

			while (!verifyItem(inventory, weapon)) {
				weapon = chooseItem();
			}

			System.out.println("CONTINUE");

		}

		return health;
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

	public static void runHelpProgram() {
	  	System.out.println("\n----------Description----------");
	  	System.out.println("This game is heavily influenced by the expansive lore of the backrooms." + 
	  	    "\nIn short, the backrooms is an alternate dimension that victims enter by\n\"noclipping\"" +
	  	    " out of our reality.\nThe backrooms are characterized by its almost limitless number of random levels."
	  	    + "\nThese levels can lead to subequent ones leading to your escape." + 
	  	    "\nOr, if you're unlucky, can take you to undesirable locations.");
	  	System.out.println("\n----------Instructions----------");
	  	System.out.println("This project mainly incorporates the survival aspect of the backrooms" + 
	  			"\nYou will have to traverse through each level and fight any entities you encounter." + 
	  			"\nThese entities may vary in difficulty and clues will be provided in their description/health" + 
	  			"\nthat will advise whether it is best to flee or fight." +
	  			"\nIn the end, there will be a final level in which you can either escape the backrooms or be" + 
	  			"\nstuck there forever");
	  	System.out.println("\n----------GAMEPLAY----------");
	  	System.out.println("To enter a command/action, enter the desired word following the" + 
	     		"\n\">\" character");
	  	System.out.println("\nLIST OF COMMANDS:");
	  	System.out.println("To proceed with the story: > continue");
	  	System.out.println("To fight an entity: > fight");
	  	System.out.println("To flee from an entity: > flee");
	  	System.out.println("To select an item: > item_name");

	  	System.exit(1);
	}

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
}
