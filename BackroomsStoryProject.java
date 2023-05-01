import java.util.Scanner;

// name, health, inventory, num_of_levels_passed, levels_passed, levels_remaining, entities_encountered, entities_remaining
// ^ These variables might be passed through most methods/levels so we can just copy and paste
// from here

public class BackroomsStoryProject {
	public static void main(String[] args) {
	  	Scanner input = new Scanner(System.in);
	    
	    // Runs the help program
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase("-help")) {
		    	runHelpProgram();
		    	break;
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

		
		int num_of_levels_passed = 0; // If a certain number of levels have passed, 
									  //we can finish the game with the final level

		String[] levels_passed = {"???", "???", "???", "???", "???", 
					  "???", "???", "???", "???", "???"};
		String[] levels_remaining = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5",
					     "Level 6", "Level 7", "Level 8", "Level 9", "pass"};

		String[] entities_encountered = {"???", "???", "???", "???", "???", 
						 "???", "???", "???", "???", "???"};
		String[] entities_remaining = {"Entity 1", "Entity 2", "Entity 3", "Entity 4", "Entity 5", 
					      "Entity 6", "Entity 7", "Entity 8", "Entity 9", "pass"};

		// Start first level
		level1(name, health, inventory, num_of_levels_passed, levels_passed,
		    levels_remaining, entities_encountered, entities_remaining);

		// displayFinalResults(name, health, inventory, entities_encountered, 
		// levels_passed);

	}


	public static void level1(String name, int health, String[] inventory, 
		int num_of_levels_passed, String[] levels_passed, String[] levels_remaining,
		String[] entities_encountered, String[] entities_remaining) {

		System.out.println("LEVEL 1\n");

		currentStats(name, health, inventory);



		String current_level = "Level 1";
		updateLevelsPassed(levels_passed, current_level);
		updateRemainingLists(levels_remaining, current_level);
		

		num_of_levels_passed++;
	}

	public static void final_level(String name, int health, String[] inventory) {
	  	return;
	}

	public static void getRandomLevel(String name, int health, String[] inventory, 
		int num_of_levels_passed, String[] levels_passed, String[] levels_remaining,
		String[] entities_encountered, String[] entities_remaining) {

		int r = (int)(Math.random() * (9+1));

		String random_level = levels_remaining[r];

		if (random_level.equals("Level 2"))
			System.out.println("run level 2 TODO");
		else if (random_level.equals("Level 3"))
			System.out.println("run level 3 TODO");
		else if (random_level.equals("Level 4"))
			System.out.println("run level 4 TODO");
		else if (random_level.equals("Level 5"))
			System.out.println("run level 5 TODO");
		else if (random_level.equals("Level 6"))
			System.out.println("run level 6 TODO");
		else if (random_level.equals("Level 7"))
			System.out.println("run level 7 TODO");
		else if (random_level.equals("Level 8"))
			System.out.println("run level 8 TODO");
		else if (random_level.equals("Level 9"))
			System.out.println("run level 9 TODO");
		else 
			getRandomLevel(name, health, inventory, num_of_levels_passed, levels_passed,
						   levels_remaining, entities_encountered, entities_remaining);

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

	public static String[] updateLevelsPassed(String[] levels_passed, String current_level) {
		if (current_level.equals("Level 1")) 
			levels_passed[0] = current_level;
		else if (current_level.equals("Level 2")) 
			levels_passed[1] = current_level;
		else if (current_level.equals("Level 3")) 
			levels_passed[2] = current_level;
		else if (current_level.equals("Level 4")) 
			levels_passed[3] = current_level;
		else if (current_level.equals("Level 5")) 
			levels_passed[4] = current_level;
		else if (current_level.equals("Level 6")) 
			levels_passed[5] = current_level;
		else if (current_level.equals("Level 7")) 
			levels_passed[6] = current_level;
		else if (current_level.equals("Level 8")) 
			levels_passed[7] = current_level;
		else if (current_level.equals("Level 9")) 
			levels_passed[8] = current_level;
		else if (current_level.equals("Level 10")) 
			levels_passed[9] = current_level;

		return levels_passed;
	}

	public static String[] updateEntitiesEncountered(String[] entities_encountered, 
		String current_entity) {
		if (current_entity.equals("Entity 1"))
			entities_encountered[0] = current_entity;
		else if (current_entity.equals("Entity 2"))
			entities_encountered[1] = current_entity;
		else if (current_entity.equals("Entity 3"))
			entities_encountered[2] = current_entity;
		else if (current_entity.equals("Entity 4"))
			entities_encountered[3] = current_entity;
		else if (current_entity.equals("Entity 5"))
			entities_encountered[4] = current_entity;
		else if (current_entity.equals("Entity 6"))
			entities_encountered[5] = current_entity;
		else if (current_entity.equals("Entity 7"))
			entities_encountered[6] = current_entity;
		else if (current_entity.equals("Entity 8"))
			entities_encountered[7] = current_entity;
		else if (current_entity.equals("Entity 9"))
			entities_encountered[8] = current_entity;
		else if (current_entity.equals("Entity 10"))
			entities_encountered[9] = current_entity;

		return entities_encountered;
	}

	// This method updates the lists of levels/entities so the random method won't choose it twice
	// Use for levels_remaining and entities_remaining
	public static String[] updateRemainingLists(String[] element_list, String current_element) {
        if (current_element.equals("Level 1") || current_element.equals("Entity 1"))
            element_list[0] = "pass";
        else if (current_element.equals("Level 2") || current_element.equals("Entity 2"))
            element_list[1] = "pass";
        else if (current_element.equals("Level 3") || current_element.equals("Entity 3"))
            element_list[2] = "pass";
        else if (current_element.equals("Level 4") || current_element.equals("Entity 4"))
            element_list[3] = "pass";
        else if (current_element.equals("Level 5") || current_element.equals("Entity 5"))
            element_list[4] = "pass";
        else if (current_element.equals("Level 6") || current_element.equals("Entity 6"))
            element_list[5] = "pass";
        else if (current_element.equals("Level 7") || current_element.equals("Entity 7"))
            element_list[6] = "pass";
        else if (current_element.equals("Level 8") || current_element.equals("Entity 8"))
            element_list[7] = "pass";
        else if (current_element.equals("Level 9") || current_element.equals("Entity 9"))
            element_list[8] = "pass";
        else if (current_element.equals("Level 10") || current_element.equals("Entity 10"))
            element_list[9] = "pass";

        return element_list;
    }

	public static void runHelpProgram() {
	  	System.out.println("\n----------Description-----------");
	  	System.out.println("This game is heavily influenced by the expansive lore of the backrooms." + 
	  	    "\nIn short, the backrooms is an alternate dimension that victims enter by\n\"noclipping\"" +
	  	    " out of our reality.\nThe backrooms are characterized by its almost limitless number of random levels."
	  	    + "\nThese levels can lead to subequent ones leading to your escape." + 
	  	    "\nOr, if you're unlucky, can take you to undesirable locations.");
	  	System.out.println("\n----------Instructions----------");
	  	System.out.println("This game mainly incorporates the randomness of the backrooms. Although the first and last "
	  	    + "levels are fixed,\nit is intended to be a random experience through each playthrough.\nIn these levels, you may "
	  	    + "encounter items, new locations, or entities. Use your intuition as you play.");

	  	System.out.println("\n----------GAME STARTED----------");
	  	System.out.println();
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
