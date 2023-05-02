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


		String[] levels_passed = {"???", "???", "???", "???", "???", "???"};

		String[] entities_encountered = {"???", "???", "???", "???", "???", "???};

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


		String current_entity = randomEntityEncounter(current_level);
		updateElementsPassed(entities_encountered, current_entity);

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

	// randomEntityEncounter(inventory, entities_encountered, current_level);
	public static String randomEntityEncounter(String current_level) {

		String current_entity = "";
		int entity_health = 0;
		String entity_type = ""; //Hostile, or Safe

		if (current_level.equals("Level 1")) {
			current_entity = "Entity 1";
			entity_health = 100;
			entity_type = "Neutral";
			getEntityDescription(current_entity, entity_health, entity_type);
			return current_entity;
		}	
		else {
			int random_enc = (int)(Math.random() * 51);

			if (random_enc % 2 == 0) {
				if (current_level.equals("Level 2")) {
					current_entity = "Entity 2";
					entity_health = 100;
					entity_type = "Neutral";
					getEntityDescription(current_entity, entity_health, entity_type);
					return current_entity;
				}
				else if (current_level.equals("Level 3")) {
					current_entity = "Entity 3";
					entity_health = 100;
					entity_type = "Neutral";
					getEntityDescription(current_entity, entity_health, entity_type);
					return current_entity;
				}
				else if (current_level.equals("Level 4")) {
					current_entity = "Entity 4";
					entity_health = 100;
					entity_type = "Neutral";
					getEntityDescription(current_entity, entity_health, entity_type);
					return current_entity;
				}
				else if (current_level.equals("Level 5")) {
					current_entity = "Entity 5";
					entity_health = 100;
					entity_type = "Neutral";
					getEntityDescription(current_entity, entity_health, entity_type);
					return current_entity;
				}
			}
		}
		return "none";
	}

	public static void getEntityDescription(String current_entity, int entity_health,
		String entity_type) {
		System.out.println("\nENTITY ENCOUNTERED: " + current_entity);
		System.out.println("\nENTITY HEALTH: " + entity_health + "%");
		System.out.println("\nENTITY TYPE: " + entity_type);

		if (current_entity.equals("Entity 1"))
			System.out.println("\nDescription for Entity 1");
		else if (current_entity.equals("Entity 2"))
			System.out.println("\nDescription for Entity 2");
		else if (current_entity.equals("Entity 3"))
			System.out.println("\nDescription for Entity 3");
		else if (current_entity.equals("Entity 4"))
			System.out.println("\nDescription for Entity 4");
		else if (current_entity.equals("Entity 5"))
			System.out.println("\nDescription for Entity 5");
	}

	public static String[] updateElementsPassed(String[] element_list, String current_element) {
		if (current_element.equals("Level 1") || current_element.equals("Entity 1"))
			element_list[0] = current_element;
		else if (current_element.equals("Level 2") || current_element.equals("Entity 2"))
			element_list[1] = current_element;
		else if (current_element.equals("Level 3") || current_element.equals("Entity 3"))
			element_list[2] = current_element;
		else if (current_element.equals("Level 4") || current_element.equals("Entity 4"))
			element_list[3] = current_element;
		else if (current_element.equals("Level 5") || current_element.equals("Entity 5"))
			element_list[4] = current_element;

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
