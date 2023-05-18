import java.util.Scanner;
import java.util.Random;

public class Game{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();

		// Runs the help program
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase("-help")) {
		    	runHelpProgram();
		    }
		}

		//create world
		String[][][] world = fillWorld();

		//tracking movement health inv
		String[] inventory = {"FISTS", "--EMPTY--", "--EMPTY--", "--EMPTY--", "--EMPTY--"};
		int health = 100;
		int posx = 0, posy = 0;

		
		//--------------------------------------------------------------------------------

		//introductions
		String name = readName();
		introMessage(name);
		messageOrDesc("starting_desc");
		System.out.print("You see some kind of map on the wall.\n");
		
		System.out.println(
							"  \t        N      \n" + 
							"  \t  A1 B1 C1 D1 E1\n" + 
							"  \t  A2 B2 C2 D2 E2\n" +
							"       W  A3 B3 C3 D3 E3  E\n" +
							"  \t  A4 B4 C4 D4 E4\n" +
							"  \t  A5 B5 C5 D5 E5\n" + 	
							"  \t        S		");

		//gameplay loop
		// boolean boss = false;


		
		boolean playerMenu = true;
		while(playerMenu){				
			int monsterRoll = rn.nextInt(10);

			if(monsterRoll == 3){
				messageOrDesc("entity_encounter" + (rn.nextInt(5)));
				health = entityEncounter(health, inventory);
			}

			if(world[0][posx][posy].equals("E5")){
				messageOrDesc("under_desc3");
				//initiateBlackJack();
			}

			System.out.print( 
						"Health: " + health + "%\n" +
						" - Move\n" + 
						" - Search\n" + 
						" - Inventory\n" +
						" - Cry\n" + 
						"\nWhat do you want to do?\n");

			System.out.print("\n> ");
			String cmd = sc.nextLine();
			cmd = cmd.trim();
			System.out.println();

			//playerMenu
			boolean searchMenu = false;


			if(cmd.equalsIgnoreCase("move")){
				boolean display = true;
				while(display){
					String playerPosition = world[0][posx][posy];
					System.out.print("You are currently in: " + playerPosition + ".\n\n");

					System.out.print("To return, enter BACK\n" + 
									 "Where do you want to move? (N/E/S/W): ");	
					String move = sc.nextLine();
					move = move.trim();
					System.out.println();


					if(move.equalsIgnoreCase("n")){
						try{
							posx -= 1;
							posy = posy;
							playerPosition = world[0][posx][posy];
							System.out.println("You walk into room " + playerPosition);

							printRoomDesc(world, posx, posy);
						if(world[2][posx][posy].equals("Puzzle")){
							boolean puzzleDone = false;
							int random1 = rn.nextInt(2);
							int random2 = rn.nextInt(2);
							int random3 = rn.nextInt(2);
							puzzleDone = puzzleRoom(random1, random2, random3);				
					
							if(puzzleDone){
								world[2][posx][posy] = "Normal";
							}
						}
						else if(world[2][posx][posy].equals("Settle")){
							settlement(inventory);
						}
							display = false;

						} catch(ArrayIndexOutOfBoundsException ex){
							System.out.println("You bumped into a wall. Try again.\n");
							posx += 1;
							posy = posy;
						}

					}
					else if(move.equalsIgnoreCase("e")){
						try{
							posx = posx;
							posy += 1;
							playerPosition = world[0][posx][posy];
							System.out.println("You walk into room " + playerPosition + "\n");

							printRoomDesc(world, posx, posy);
						if(world[2][posx][posy].equals("Puzzle")){
							boolean puzzleDone = false;
							int random1 = rn.nextInt(2);
							int random2 = rn.nextInt(2);
							int random3 = rn.nextInt(2);
							puzzleDone = puzzleRoom(random1, random2, random3);				
				
							if(puzzleDone){
								world[2][posx][posy] = "Normal";
							}
						}
						else if(world[2][posx][posy].equals("Settle")){
							settlement(inventory);
						}

							display = false;
						} catch(ArrayIndexOutOfBoundsException ex){
							System.out.println("You bumped into a wall. Try again.\n");
							posx = posx;
							posy -= 1;
						}
					}
					else if(move.equalsIgnoreCase("s")){
						try{
							posx += 1;
							posy = posy;
							playerPosition = world[0][posx][posy];
							System.out.println("You walk into room " + playerPosition + "\n");

							printRoomDesc(world, posx, posy);
						if(world[2][posx][posy].equals("Puzzle")){
							boolean puzzleDone = false;
							int random1 = rn.nextInt(2);
							int random2 = rn.nextInt(2);
							int random3 = rn.nextInt(2);
							puzzleDone = puzzleRoom(random1, random2, random3);				
				
							if(puzzleDone){
								world[2][posx][posy] = "Normal";
							}
						}
						else if(world[2][posx][posy].equals("Settle")){
							settlement(inventory);
						}


							display = false;
						} catch(ArrayIndexOutOfBoundsException ex){
							System.out.println("You bumped into a wall. Try again.\n");
							posx -= 1;
							posy = posy;
						}
					}
					else if(move.equalsIgnoreCase("w")){
						try{
							posx = posx;
							posy -= 1;
							playerPosition = world[0][posx][posy];
							System.out.println("You walk into room " + playerPosition + "\n");

							printRoomDesc(world, posx, posy);
							if(world[2][posx][posy].equals("Puzzle")){
							boolean puzzleDone = false;
							int random1 = rn.nextInt(2);
							int random2 = rn.nextInt(2);
							int random3 = rn.nextInt(2);
							puzzleDone = puzzleRoom(random1, random2, random3);				
				
							if(puzzleDone){
								world[2][posx][posy] = "Normal";
							}
						}
						else if(world[2][posx][posy].equals("Settle")){
							settlement(inventory);
						}


							display = false;
						} catch(ArrayIndexOutOfBoundsException ex){
							System.out.println("You bumped into a wall. Try again.\n");
							posx = posx;
							posy += 1;
						}
					}
					else if(move.equalsIgnoreCase("back")){
						display = false;
					}
				}
			}
			if(cmd.equalsIgnoreCase("search")){
				searchMenu = true;
				searchMenu = searchMenu(world, posx, posy, searchMenu);
			}
			else if(cmd.equalsIgnoreCase("inventory")){
				health = inventory(inventory, health, posx, posy, world);
			}
			else if(cmd.equalsIgnoreCase("cry")){
				int cryChance = rn.nextInt(10000);
				System.out.print("You descend to your knees and somber, anguished at the dreadful revalation of the unfortunate \n"+
						 "situation that has been misfortunately happened upon your woeful being. In your episoede of \n"+
						 "despondency, your hands cover your eyes, as if to prevent a mutual acknowledgement between you \n"+
						 "whatever else roamsn these halls of your current state. However, you are wholly unaware of your \n"+
						 "immediate surrounding environment. \n\n"+
						 "You're not in those rooms anymore. \n"+
						 "The reprivation of the bewildering emotions delivered from what was just once total helplessness \n"+
						 "pushes your body to the grass around you. You lay there, contemplating this most recent occurrence, \n"+
						 "breathing in air that is recognizable to the body.\n\n"+
						 "Whatever just happened, you hope that nothing like that ever happens again.\n\n"+
						 "At least for now...\n");
				
				if(cryChance == 8375){
					System.out.println("By some miracle, your sobbing convinced the backrooms that you had completely surrendered to it, and decided it was done toying with you. ");
					System.out.print(holdArt(3));
					System.exit(0);
				}
			}
		}
	}
	public static void settlement(String[] inv){
		Scanner sc = new Scanner(System.in);
		System.out.println("You come across a group of people that seem to have a camp set up.");
		System.out.print("Do you want to sit with the group? (Y/N): ");
		String choice = sc.nextLine();
		choice = choice.trim();
		System.out.println();
		
		while(!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N")){
			System.out.print("Do you want to sit with the group? (Y/N): ");
			choice = sc.nextLine();
			choice.trim();
			System.out.println();
		}

		if(choice.equalsIgnoreCase("Y")){
			System.out.println("After spending some time with the group, you decided it's time to go.\n" + 
								"Before you leave, the group gives you some bandages.\n");
			for (int i = 0; i < inv.length; i++) {
				if (inv[i].equals("--EMPTY--")) {
					inv[i] = "bandages";
					break;
				}
			}
		}
		else if(choice.equalsIgnoreCase("N")){
			System.out.println("You decide to keep to yourself. \n");
		}
	}
	public static boolean puzzleRoom(int r1, int r2, int r3){
		System.out.println("Breh\n");
		return true;
	}
	public static boolean searchMenu(String[][][] world, int posx, int posy, boolean display){
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		while(display){
			String playerPosition = world[0][posx][posy];
			

			System.out.print(
				"Search: \n" + 
				" - Look at Map\n" +
				" - Search for Items\n\n" + 
				" To return, enter BACK\n\n" + 
				" What do you want to do?: ");	
			String search = sc.nextLine();
			search = search.trim();

			if(search.contains("map")){
				
				System.out.println(
							"  \t        N      \n" + 
							"  \t  A1 B1 C1 D1 E1\n" + 
							"  \t  A2 B2 C2 D2 E2\n" +
							"       W  A3 B3 C3 D3 E3  E\n" +
							"  \t  A4 B4 C4 D4 E4\n" +
							"  \t  A5 B5 C5 D5 E5\n" + 	
							"  \t        S		");

				System.out.println();
				System.out.println("You are currently in room: " + playerPosition + "\n");
			}
			else if(search.contains("items")){
				String itemList = "";
				messageOrDesc(("desc_header" + rn.nextInt(3)));

				if(world[3][posx][posy].equals("--EMPTY--")){
					messageOrDesc(("desc_absent" + rn.nextInt(3)));
					break;
				}
				else{
					messageOrDesc(("desc_present" + rn.nextInt(3)));
					itemList += world[3][posx][posy] + "\n";
					System.out.println(itemList);
					break;
				}
			}
			else if(search.equalsIgnoreCase("back")){
				display = false;
			}
		}
		return display;
	}
	public static void printRoomDesc(String[][][] world, int posx, int posy){
		String playerPosition = world[0][posx][posy];
		if(world[1][posx][posy].contains("Y")){
			switch(playerPosition){	
			case "A1":
				messageOrDesc("yellow_desc0");
				break;
			case "A2":
				messageOrDesc("yellow_desc1");
				break;
			case "A3":
				messageOrDesc("yellow_desc2");
				break;
			case "B1":
				messageOrDesc("yellow_desc3");
				break;
			case "B2":
				messageOrDesc("yellow_desc4");
				break;
			case "B3":
				messageOrDesc("yellow_desc5");
				break;
			case "C1":
				messageOrDesc("yellow_desc6");
				break;
			case "C2":
				messageOrDesc("yellow_desc7");
				break;
			case "C3":
				messageOrDesc("yellow_desc8");
				break;
			}
		}
		if(world[1][posx][posy].contains("P")){
			switch(playerPosition){
			case "A4":
				messageOrDesc("pool_desc0");
				break;
			case "A5":
				messageOrDesc("pool_desc1");
				break;
			case "B4":
				messageOrDesc("pool_desc2");
				break;
			case "B5":
				messageOrDesc("pool_desc3");
				break;
			}
		}
		if(world[1][posx][posy].contains("A")){
			switch(playerPosition){
			case "D1":
				messageOrDesc("apt_desc0");
				break;
			case "D2":
				messageOrDesc("apt_desc1");
				break;
			case "D3":
				messageOrDesc("apt_desc2");
				break;
			case "E1":
				messageOrDesc("apt_desc3");
				break;
			case "E2":
				messageOrDesc("apt_desc4");
				break;
			case "E3":
				messageOrDesc("apt_desc5");
				break;
			}
		}
		if(world[1][posx][posy].contains("U")){
			switch(playerPosition){
			case "D4":
				messageOrDesc("under_desc0");
				break;
			case "D5":
				messageOrDesc("under_desc1");
				break;
			case "E4":
				messageOrDesc("under_desc2");
				break;
			}
		}
}
	public static String[][][] fillWorld(){
		Random rn = new Random();
		String[][][] world = new String[6][5][5];

		//fill world with coords, area, room type, items
		int settleCount = 0;
		int puzzleCount = 0;
		int y = 0;
		int a = 0;
		int p = 0;
		int u = 0;
		for(int posx = 0; posx < world[0].length; posx++){
			for(int posy = 0; posy < world[0][posx].length; posy++){
				
				//coords
				world[0][posx][posy] = (((char)('A' + posy) + "") + ((posx + 1) + ""));
				
				//area
				if(posx < 3 && posy < 3){
					world[1][posx][posy] = "Y" + " ";
				}
				else if(posx < 3 && posy > 2){
					world[1][posx][posy] = "A" + " ";
				}
				else if(posx > 2 && posy < 3){
					world[1][posx][posy] = "P" + " ";
				}
				else{
					world[1][posx][posy] = "U" + " ";
				}

				//room type - puzzle, settlement, normal 
				int roomType = rn.nextInt(3);

				if(posx == 0 && posy == 0){
					roomType = 0;
				}
				else if(posx == 4 && posy == 4){
					roomType = 0;
				}
				
					if(roomType == 2 && settleCount == 2){
						roomType = rn.nextInt(2);
					}
					if(roomType == 1 && puzzleCount == 4){
							roomType = 0;
					}
				
				switch(roomType){
					case 0:
						world[2][posx][posy] = "Normal";
						break;
					case 1:
						world[2][posx][posy] = "Puzzle";
						puzzleCount++;
						break;
					case 2:
						world[2][posx][posy] = "Settle";
						settleCount++;
						break;
				}


				world[3][posx][posy] = itemChance(world, posx, posy);

				}
			}
			return world;
		}
	public static String itemChance(String[][][] world, int posx, int posy){
		Random rn = new Random();
		
		if(posx == 0 && posy == 0){
			return "--EMPTY--";
		}
		else if(posx == 4 && posy == 4){
			return "--EMPTY--";
		}

		int itemsInRoom = rn.nextInt(5);

		switch(itemsInRoom){
		case 0:
			return "--EMPTY--";
		case 1:
			return holdItems(1);
		case 2:
			return holdItems(1);
		case 3:
			return "--EMPTY--";
		case 4:
			return holdItems(1);
		}
		return "--EMPTY--";
		}
	public static String holdItems(int itemNum){
		Random rn = new Random();
		int itemCount = 0;
		int weaponCount = 0;
		int puzzleItemCount = 0;	

		String[] weapons = {"baseball bat", "metal pipe", "tennis racket", "chair leg"};
		String[] health = {"almond water", "backshrooms", "bandages", "health pack"};

		if(itemNum == 1){
			int itemType = rn.nextInt(2);

			//validation
			if(itemCount == 8){
				return "--EMPTY--";
			}
			if(weaponCount == 4){
				itemType = 0;
			}

			//choose item
			switch(itemType){
			case 0: 
				weaponCount++;
				itemCount++;
				return (weapons[rn.nextInt(4)]);
			case 1: 
				itemCount++;
				return (health[rn.nextInt(4)]);
			}

		}
			return "--EMPTY--";
	}
	public static int inventory(String[] inventory, int health, int posx, int posy, String[][][] world) {
		Scanner input = new Scanner(System.in);
		boolean inv = true;

		while (inv) {
			System.out.println("\nInventory:");
			displayList(inventory);
			System.out.println();
			System.out.println("- Add");
			System.out.println("- Drop");
			System.out.println("- Heal");
			System.out.println("- Exit");
			System.out.println();

			System.out.print("What would you like to do?: ");
			String cmd = input.nextLine();
			cmd = cmd.trim();

			while (!cmd.equalsIgnoreCase("add") && !cmd.equalsIgnoreCase("drop")
				&& !cmd.equalsIgnoreCase("heal") && !cmd.equalsIgnoreCase("exit")) {
				System.out.print("What would you like to do?: ");
				cmd = input.nextLine();
				cmd = cmd.trim();
			}

			if (cmd.equalsIgnoreCase("add")) {
				addToInventory(inventory, posx, posy, world);
			}
			else if (cmd.equalsIgnoreCase("drop")) {
				removeFromInventory(inventory, posx, posy, world);
			}
			else if (cmd.equalsIgnoreCase("heal")) {
				health = heal(health, inventory);
			}
			else if (cmd.equalsIgnoreCase("exit")) {
				inv = false;
			}
		}
		return health;	
	}

	public static void displayList(String[] list) {
		for (int i = 0; i < list.length; i++) {
				System.out.println(" " + (i+1) + ")  " + list[i]);
		}
	}

	public static String[] addToInventory(String[] inv, int posx, int posy, String[][][] world) {
		Scanner input = new Scanner(System.in);

		System.out.println("\nTo return, enter BACK\n");

		System.out.print("Enter an item to add: ");
		String addition = input.nextLine();
		addition = addition.trim();

		if (addition.equalsIgnoreCase("back")){
			return inv;
		}
		else {
			// verify if the item is valid or if the item is available for pickup
			while (addition.equalsIgnoreCase("fists") || addition.equalsIgnoreCase("--empty--") || 
				!isValidItem(addition, posx, posy, world)) {
				System.out.println("Cannot add item");
				System.out.print("\nEnter an item to add: ");
				addition = input.nextLine();
				addition = addition.trim();

				if (addition.equalsIgnoreCase("back")){
				return inv;
				}
			}

			for (int i = 0; i < inv.length; i++) {
				if (inv[i].equals("--EMPTY--")) {
					inv[i] = addition;
					break;
				}
			}
				if (world[3][posx][posy].equalsIgnoreCase(addition)) {
					world[3][posx][posy] = "--EMPTY--";
				}
		}	
		return inv;
	}

	// To allow the user to drop items
	public static String[] removeFromInventory(String[] inv, int posx, int posy, String[][][] world) {
		Scanner input = new Scanner(System.in);

		System.out.println("\nTo return, enter BACK\n");

		System.out.print("Enter an item to drop: ");
		String removal = input.nextLine();
		removal = removal.trim();

		if (removal.equalsIgnoreCase("back"))
			return inv;
		else {
			// verify if the item is valid or present in inventory
			while (removal.equalsIgnoreCase("fists") || removal.equalsIgnoreCase("--empty--")) {
				System.out.println("Cannot drop item");
				System.out.print("\nEnter an item to drop: ");
				removal = input.nextLine();
				removal = removal.trim();
			}

			for (int i = 0; i < inv.length; i++) {
				if (inv[i].equalsIgnoreCase(removal)) {
					world[3][posx][posy] = removal;
				}
			}

			for (int i = 0; i < inv.length; i++) {
				if (inv[i].equalsIgnoreCase(removal)) {
					inv[i] = "--EMPTY--";
					break;
				}
			}
			

			System.out.println("You dropped: " + removal);
		}		
		return inv;
	}

	// To remove items manually
	public static String[] remove(String[] inv, String removal) {
		for (int i = 0; i < inv.length; i++) {
			if (inv[i].equalsIgnoreCase(removal)) {
				inv[i] = "--EMPTY--";
				break;
			}
		}
		return inv;
	}

	public static int heal(int health, String[] inventory) {
		Scanner input = new Scanner(System.in);

		boolean heal = true;

		while (heal) {

			System.out.println("\nTo return, enter BACK");
			displayInventoryItems(inventory, "health");
			System.out.print("\nChoose an item: ");
			String health_item = input.nextLine();
			health_item = health_item.trim();

			while (!isHealthItem(health_item) && !health_item.equalsIgnoreCase("back")) {
				System.out.print("Item not valid");
				System.out.print("\nChoose an item: ");
				health_item = input.nextLine();
				health_item = health_item.trim();
			}

			while (!verifyItem(inventory, health_item) && !health_item.equalsIgnoreCase("back")) {
				System.out.println("Item not in inventory");
				System.out.print("\nChoose an item: ");
				health_item = input.nextLine();
				health_item = health_item.trim();
			}
			if (health_item.equalsIgnoreCase("back")) {
				heal = false;
			}
			else if (health_item.equalsIgnoreCase("almond water")) {
				health += 20;
				remove(inventory, health_item);
				System.out.println("\nHEALTH ADDED: +20%");
			}
			else if (health_item.equalsIgnoreCase("backshroom")) {
				health += 30;
				remove(inventory, health_item);
				System.out.println("\nHEALTH ADDED: +30%");
			}
			else if (health_item.equalsIgnoreCase("bandages")) {
				health += 40;
				remove(inventory, health_item);
				System.out.println("\nHEALTH ADDED: +40%");
			}
			else if (health_item.equalsIgnoreCase("health pack")) {
				health += 50;
				remove(inventory, health_item);
				System.out.println("\nHEALTH ADDED: +50%");
			}
		}

			if (health > 100) 
				health = 100;

			System.out.println("\nCurrent Health: " + health + "%");
			return health;
	}

	public static boolean isHealthItem(String item) {
		if (item.equalsIgnoreCase("almond water") || item.equalsIgnoreCase("bandages") ||
			item.equalsIgnoreCase("backshroom") || item.equalsIgnoreCase("health pack"))
			return true;
		else
			return false;
	}

	public static boolean isValidItem(String item, int posx, int posy, String[][][] world){
		if ((item.equalsIgnoreCase("metal pipe") || item.equalsIgnoreCase("chair leg") ||
			item.equalsIgnoreCase("tennis racket") || item.equalsIgnoreCase("baseball bat") ||
			item.equalsIgnoreCase("almond water") || item.equalsIgnoreCase("bandages") ||
			item.equalsIgnoreCase("backshroom") || item.equalsIgnoreCase("health pack")) && world[3][posx][posy].contains(item)) {
			return true;
		} 
		else
			return false;
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
				if (inv[i].equalsIgnoreCase("almond water") || inv[i].equalsIgnoreCase("bandages") ||
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
	
	public static boolean lowHealth(int health) {
		if (health < 50 && health > 0)
			return true;
		else 
			return false;
	}
	public static String holdArt(int choice){
		String title = "▄▄▄█████▓██░ ██▓█████     ▄▄▄▄   ▄▄▄      ▄████▄  ██ ▄█▀██▀███  ▒█████  ▒█████  ███▄ ▄███▓ ██████    \n" + 
					   "▓  ██▒ ▓▓██░ ██▓█   ▀    ▓█████▄▒████▄   ▒██▀ ▀█  ██▄█▒▓██ ▒ ██▒██▒  ██▒██▒  ██▓██▒▀█▀ ██▒██    ▒    \n" + 
					   "▒ ▓██░ ▒▒██▀▀██▒███      ▒██▒ ▄█▒██  ▀█▄ ▒▓█    ▄▓███▄░▓██ ░▄█ ▒██░  ██▒██░  ██▓██    ▓██░ ▓██▄      \n" + 
					   "░ ▓██▓ ░░▓█ ░██▒▓█  ▄    ▒██░█▀ ░██▄▄▄▄██▒▓▓▄ ▄██▓██ █▄▒██▀▀█▄ ▒██   ██▒██   ██▒██    ▒██  ▒   ██▒   \n" +
					   "  ▒██▒ ░░▓█▒░██░▒████▒   ░▓█  ▀█▓▓█   ▓██▒ ▓███▀ ▒██▒ █░██▓ ▒██░ ████▓▒░ ████▓▒▒██▒   ░██▒██████▒▒   \n" + 
					   "  ▒ ░░   ▒ ░░▒░░░ ▒░ ░   ░▒▓███▀▒▒▒   ▓▒█░ ░▒ ▒  ▒ ▒▒ ▓░ ▒▓ ░▒▓░ ▒░▒░▒░░ ▒░▒░▒░░ ▒░   ░  ▒ ▒▓▒ ▒ ░   \n" + 
					   "    ░    ▒ ░▒░ ░░ ░  ░   ▒░▒   ░  ▒   ▒▒ ░ ░  ▒  ░ ░▒ ▒░ ░▒ ░ ▒░ ░ ▒ ▒░  ░ ▒ ▒░░  ░      ░ ░▒  ░ ░   \n" + 
					   "  ░      ░  ░░ ░  ░       ░    ░  ░   ▒  ░       ░ ░░ ░  ░░   ░░ ░ ░ ▒ ░ ░ ░ ▒ ░      ░  ░  ░  ░     \n" + 
					   "         ░  ░  ░  ░  ░    ░           ░  ░ ░     ░  ░     ░        ░ ░     ░ ░        ░        ░     \n" + 
					   "                               ░         ░                                                           \n";
		String death = "  ▄████ ▄▄▄      ███▄ ▄███▓█████     ▒█████  ██▒   █▓█████ ██▀███  \n" + 
					   " ██▒ ▀█▒████▄   ▓██▒▀█▀ ██▓█   ▀    ▒██▒  ██▓██░   █▓█   ▀▓██ ▒ ██▒\n" + 
					   "▒██░▄▄▄▒██  ▀█▄ ▓██    ▓██▒███      ▒██░  ██▒▓██  █▒▒███  ▓██ ░▄█ ▒\n" +
					   "░▓█  ██░██▄▄▄▄██▒██    ▒██▒▓█  ▄    ▒██   ██░ ▒██ █░▒▓█  ▄▒██▀▀█▄  \n" + 
					   "░▒▓███▀▒▓█   ▓██▒██▒   ░██░▒████▒   ░ ████▓▒░  ▒▀█░ ░▒████░██▓ ▒██▒\n" +
					   " ░▒   ▒ ▒▒   ▓▒█░ ▒░   ░  ░░ ▒░ ░   ░ ▒░▒░▒░   ░ ▐░ ░░ ▒░ ░ ▒▓ ░▒▓░\n" + 
					   "  ░   ░  ▒   ▒▒ ░  ░      ░░ ░  ░     ░ ▒ ▒░   ░ ░░  ░ ░  ░ ░▒ ░ ▒░\n" +
					   "░ ░   ░  ░   ▒  ░      ░     ░      ░ ░ ░ ▒      ░░    ░    ░░   ░ \n" + 
					   "      ░      ░  ░      ░     ░  ░       ░ ░       ░    ░  ░  ░     \n" + 
					   "                                                 ░                 \n";
		String esc =   "▓██   ██▓▒█████  █    ██    ▓█████  ██████ ▄████▄  ▄▄▄      ██▓███ ▓█████▓█████▄ \n" +
					   " ▒██  ██▒██▒  ██▒██  ▓██▒   ▓█   ▀▒██    ▒▒██▀ ▀█ ▒████▄   ▓██░  ██▓█   ▀▒██▀ ██▌\n" + 
					   "  ▒██ ██▒██░  ██▓██  ▒██░   ▒███  ░ ▓██▄  ▒▓█    ▄▒██  ▀█▄ ▓██░ ██▓▒███  ░██   █▌\n" + 
					   "  ░ ▐██▓▒██   ██▓▓█  ░██░   ▒▓█  ▄  ▒   ██▒▓▓▄ ▄██░██▄▄▄▄██▒██▄█▓▒ ▒▓█  ▄░▓█▄   ▌\n" + 
					   "  ░ ██▒▓░ ████▓▒▒▒█████▓    ░▒████▒██████▒▒ ▓███▀ ░▓█   ▓██▒██▒ ░  ░▒████░▒████▓ \n" + 
					   "   ██▒▒▒░ ▒░▒░▒░░▒▓▒ ▒ ▒    ░░ ▒░ ▒ ▒▓▒ ▒ ░ ░▒ ▒  ░▒▒   ▓▒█▒▓▒░ ░  ░░ ▒░ ░▒▒▓  ▒ \n" +
					   " ▓██ ░▒░  ░ ▒ ▒░░░▒░ ░ ░     ░ ░  ░ ░▒  ░ ░ ░  ▒    ▒   ▒▒ ░▒ ░     ░ ░  ░░ ▒  ▒ \n" + 
					   " ▒ ▒ ░░ ░ ░ ░ ▒  ░░░ ░ ░       ░  ░  ░  ░ ░         ░   ▒  ░░         ░   ░ ░  ░ \n" + 
					   " ░ ░        ░ ░    ░           ░  ░     ░ ░ ░           ░  ░          ░  ░  ░    \n" + 
					   " ░ ░                                      ░                               ░      \n";
		String man = 
					"NNNNNNNNNNNNNNNNNNNNNNNNNNXKx:'',,'';:;;;;;::;;;::;;:::::;:;,'',;:;,;;cd0XXXXXXXXXXXXXKKXXXXXXXXXXXX\n" +
					"kkkkkkkkkkkkkkkkkkkkkkOkkdl:;,,,,;;,'';:;;;:clc::cllolccc:;;;,;:;;::;,;;:llccc:;;;;;;;;;;;;;;;;;;;;;\n" +
					"kkkkkkkkkkkkkkkkkkOOkOOxl:;,,,,'',;;ldoodxkO0KXXXNNNXXKK0OOOd:;,,,;,,,',;:cc:;,'....................\n" +
					"OOOOOOOOOOOOOOO0OO000Oxc;'...',,;:cd0XXNNNNNNNWWNNNNNNWWWNNNXKOxc:::c:;;:;,,;cc;;;;;;;;;;;;;;;;;;;;;\n" +
					"OOOOOO0000000000000O0kc,,'''';:cok0XNNNNNNWWWWWWWWWWWWWWWNWNNNXXKxl:;;loc;,',cc;,,,,,,,,,,,,,,,,,,,,\n" +
					"OOOOOOOOOOOOOOO0OOOOOo,':c:;,,,lOXXXNNNWWWWWWWWWWWWWWWWWWWNNNNNXXXk:..;lc'',;:;'....................\n" +
					"OOOOOOO00000000O000Oo;',,''''.:kXNXNNNNWWWWWWWWWWWWWWWWWWWWNNNNNXXX0o,..''.',;:,'...................\n" +
					"OOOOOOO000000000000xc;;:;,'..:kKXXNNNNWWWWWWWWWWWWWWWWWWWWWWWNNNXXXKKk:,,''''..;,...................\n" +
					"OOOOOO000000000000kc,;;::::;:xKXXXNNNNWWWWWWWWWWWWWWWWWNWWWWWWNXXXXXXOoc::;;;'.''...................\n" +
					"OOO000000000000000d'....,,;;lOKXNXXNNNWWWWNNWNNNNNNNNNNNNNNNWWNNXXXKKOl;;::;'.......................\n" +
					"OOO000000000000000k:..'..'''lOKXXXNNNWWWWWWWNNNNNNNNNNNNNNWWNNNNXXXK00o'............................\n" +
					"OO0000000000000000Oc,,,,;lllkKXXNNNXK000KXXNNNNNNNNNNNNNNWNNNNNNNNXXKOOd,''.........................\n" +
					"OO0000000000000000x,.'..';,cOKXNKOxxdooooodk0XNNNNNNNNXKOxddddxkkkOXX00kc:c:;,,'....................\n" +
					"OOOOO00000000000O0d;,''''.'lO0KOdxO00OkkxxddxOKXNNNNXKOxddxkOO00OxddkOOx:,'.......................''\n" +
					"OOOOOOO0000000000k:,'.',;,;d0KkxOO000KK0Okxxxk0XNNNNNKOOOkk0KKK00OOkdoxko:,.....................''''\n" +
					"OOOOOOOOOOOOOOOO0d;'',;;::ck0OOO0OkkxxkO0K0OO0KXNWWWNXK0000OkxxxdxOOOdoxo,''..................'''',,\n" +
					"OOOOOOOOOOOOOOOOOx:,;,'...:k00000Oxolok00KXNXXXXNNNNNXXXNNKOOOxlldkkOkxxo;'......'''........''''',,,\n" +
					"OOOOOOOOOOOOOOOOOOkkx;...,oOXXKKKK0kxk0KXXNNNNXXNWWNXXNNNNXKKKOkxO0kO0Okxl:;',:,''''''''''''''',,,,;\n" +
					"OOOOOOOOOOOOOOOOOOxdxd,..cx0XNNNXXXXKKXXNNWNNNXXNWWNXKXNNWNNXXKKK0OO0KKOd:,..lkl,''''''''''''',,,;;,\n" +
					"OOOOOOOOOOOOOOOOOOxodxo;;ok0XXNNNNNNNNNNNNNNNXXKKKKKKKKXNNNNWWNNXXXXXXX0dc..,lc;,,''''''''',,,,,;;;;\n" +
					"OOOOOOOOOOOOOOOOOOkxkxdodxxOKXXNNNWWNNNNNNNXXK0koxkkkkOKXNNNNNNNWNNXXXKOxl;;odl:,,,,,'',,,,,,,;;;;;;\n" +
					"OOOOOOOOOOOOOOOOOOOxdolodclkO0KXXNNNNNNXXNXKOd:,,;,;;';d0XXXNNXNNNNNKK0kddooxkdc,,,,,,,,,,,,;;;;;:::\n" +
					"OOOOOOOOOOOOOOOOOOOkkkxxl':xkO0KKXNNXXNNNNXk:''cxocoo'.,o0XXXNXXXXNX0Okxoooclddc,,,,,,,,,,;;;;;;::::\n" +
					"kOOOOOOOOOOOOkkkkkkkxkkxl,;odloooooooooodddc;;clllcllc,':dxkkkkkOOkkxddd::ddool:;;;;;;;;;;;;;;::::::\n" +
					"kkkkkkkkkkkkkkkkkkkkxxkko:,..............,:odo;..   .;coc'............',;lkOkoc;;;;;;;;;;;;;:::::cc:\n" +
					"kkkkkkkkkkkkkkkkkkkkkxkkxo:.  ...'',;;;:::oxoll:'..,:loxd:,'''''....   .;dkOxl:;;;;;;;;;;;::::::ccc:\n" +
					"kkkkkkkkkkkkkkkkkkkkkkxkkxl.  .. ......',.';'.''.....','.','.'''...    .cdkxl:;;:;;;;;;;;::::::ccccc\n" +
					"kkkkkkkkkkkkkkkkkkkkkkkkkkl.   .        ....          .   .            'lxdl::::::::::::::::::cccccc\n" +
					"kkkkkkkkkkkkkkkkkkkkkkkxxx:.  ..                                     ..'lxdc::;:::::::::::::cccccccc\n" +
					"kkkkkkkkkkkkkkkkkkkkkkkxxo:;:'...                              ..   .;;,:ll:::;:::::::::::cccccccccc\n" +
					"kkkkkkkkkkkkkkkkkkkkkkkkkxxxkd,... ..                          ..  .:lcc::c::::::::::::::ccccccccllc\n" +
					"kkkkkkkkkkkkkkkkkkkxxxxxxkxxxxdc;.....                         ..  ,lccccc:::::::::::::ccccccccccllc\n" +
					"kkkkkkkkkkkkkxxxxxxxxxxxxxxxxdc;;;'.  ..                       .. .clccccc:c:::::c:::ccccccccccclllc\n" +
					"kkkkkkkkkkxxxxxxxxxxxxxxxxxxxddl,';,.. ...      .......   .  .....,ccccccc::::::cccccccccccccclllllc\n" +
					"kkkkkkkkxxxxxxxxxxxxxxxxxxxxxxxd;.';;,....     ........  .. ......clccccc:::::::cccccccccccccclllllc\n" +
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxd;..',::'.............  . ......'clllcccc:::::::cccccccccccccllllllc\n" +
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxl....,cl:,'...................'ldlcccccc:::::::cccccccccccccllllllc\n" +
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxdxxkd:....',,''...........'.....;oddoccccc::::::::cccccccccccclllllllc\n" +
					"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxddxxkkxdc'.....................,oxxxxoccccc:::::::ccccccccccccclllllllc\n" +
					"xxxxxxxxxxxxxxxxxxxxxxxxxdxxddxxkkkkkkxo;...... .....    .;ldkkkxxdlcccc:::::::ccccccclllclllllllllc\n" +
					"xxxxxxxxxxxxxxxxxxxxxdddddddddxkkkkkkkkkxl'....      ...:dxkkkkkkkdlccc::::::::ccccccllllllllllllllc\n" +
					"xxxxxxxxxxxxxxxxxxxxdddddddddxkOkOkkOOOkkl'............,lkkkkkkkkkxlcc:::::::::ccccccclllllllllllllc\n";

		String smi = "                                                                                                    \n" +
					"                                                                                                    \n" +
					"                                                                   ..                               \n" +
					"                           ....                                .,:clc:,..                           \n" +
					"                        .':loool;.                           .,oxkkkkxdc,.                          \n" +
					"                       .;oxOO00Okd;.                         'lkOOOOOOkdc..  ....                   \n" +
					"                       .cxO000000Oo'                         'lkOOOOOOkxc'..';:,.                   \n" +
					"                       .ck00KKKKKOo.                         .;dO00OOOxo;.,cool;.                   \n" +
					"                        .cx0KKKK0x,                           .,ldddlc,...cdxxo;.                   \n" +
					"                  .:l:.   .;:clc:.                               ...    .,ldxdc.                    \n" +
					"                  ,oxd:.                                               .,lddo:.                     \n" +
					"                  .:xxdc'                                             .;oddl;.                      \n" +
					"                  .;dO0Od,                                          .,lxxdl;.                       \n" +
					"                   .cxO0Od:.                                      .,codxxo,.                        \n" +
					"                    .;dO00kxo,.                               ..';lxOOkdl;.                         \n" +
					"                     .'ldkO00Oo::,..,.     .  .'. ...   . ...'okk000OOOd;.                          \n" +
					"                       .'ck00Ok00Ok0XOxdlcdkoo0KkdxO0o,ckolkOxOKK000Oxo:.                           \n" +
					"                         .:ldx0XXXXNNNNNXXNNXXNNXXXXNXO0XX00XKKK00Oxd:.                 ';          \n" +
					"                           .,d0KXXNNNXXNXXNNNNNNXXNNNX0KXXK00KK0OOx;..                  ':.         \n" +
					"                            .,lxOKXXKKXXKKXXXXNX0KXXXK00KKK0000koc:.                    .'.         \n" +
					"                              ..;xOxkKXKKKXX0KXKO0KXK0000O00kxxc.                                   \n" +
					"                                .',,lkkkOOK0k0XK0KKK0O0K0Okdl;,.                                    \n" +
					"                                   ...':coOdlkK0O0KKOxxOkdc'..                                      \n" +
					"                                         .,..;odllddo:,;'..                                         \n" +
					"                                              .. .....                                              \n" +
					"                                                                                                    \n";
		String skin = "''''''''''''''''''.'......        ..'''........    ........................,;:lool:,;ccc:;;;;;;,;;:c\n" +
					"'''''''''''''''''....       ..    .''''........   .........................',;:lol:;;;:::::::::;;;;c\n" +
					"''''''''''.'''''''..        .........''.......   ..........',,,,',,'.''......,;:llc:;;,,;::::c:;;;,;\n" +
					"''''''''''''''''.'...               .........   ........,;:cooolcc::::;,'''...',:clc::;,,;;,,;;'',,;\n" +
					"''''''''''''''''.'............            ...    .....':lodxxxxdodoccll:,'''....,:cccccc::;,,;;'',;:\n" +
					"'''''''''''''''..''...........             .       ..;lodxkxxxxxxkkdoodoc;,''''..',,;;:cc:;,,;:;::cc\n" +
					"''''''''''''''...,,..........             ..  .. ...:coxkxxxkkkkkOkkxdlll:,,;,'''..'',,,,,;;;,,,;;::\n" +
					"'''''''''''''...',,..........            ..     ..',::lxxxxxkOOOOkxxkdocc:;;::;;,'...',,,,,,,,'''',:\n" +
					"''''''''''''....';,.........             ..     .'',;;;cdxxxkkO0Okxxxdolc:;;,;;;::;''.',;;,;;,,,,',:\n" +
					"''''''''''''....,,'.   .                ..     .......  ..,coddxxdxxddolc:;,''''',,,;;,,,,;;:ccc:,,'\n" +
					"''''''''''''....''.........        .    ..     ..','.  .....':::lddxddol:;,,;;,,'''',,'',,;;:ccllc:;\n" +
					"'''''''''''''.'.....,:c:;,'..........  ..       .;ll;'......,;,.....',::;,,,;,,;;;;;;,,,',;;;::clllc\n" +
					"..'.'',,',;:::::,'...',,;:;'''',,,;;,'.....     .';colc;'.';::,. ...   ..,;;,,;::c::::::;;;,,,,,;;::\n" +
					".......'',;:ccc:,....';;,,;;,,,,,'',,;;;,,,.     ..,;;,,',,..',..... ....,;:::::cccccccc:::;,;;,,,,,\n" +
					"        ...',,,,'......;:;,',;,,,'',,,,,,,,.   . ..';,'';,...';,:c;'....'';;::;:ccc:,,,'',,,,,;,;;;;\n" +
					"..   ..............  ...'',,,,;;;;;;;;::;'..  ....'.',;;,;;,,:;',;,'.....',,;;::;;,,'''',;;;;;;;;;;;\n" +
					" .....'................''..',,;cc;;,,,:c:'...........,;,.',;c:',;'.. ...''',;,;;;;:;;;::::ccccclllc:\n" +
					"...'''..................''...';;,..''';,,''.......'.       .:;.,'.......,;::;;;;:ccc::ccccccclllllcc\n" +
					"''''.....................'''...'''...':,.....';,.           ........',,,:ccc:::;,;ccc::;:ccc::cccc:;\n" +
					"'''''................. ....''....'.......    ':'             ......;::;,;ll;,;::,':c:::;;;;;;;;;;,,'\n" +
					"'''''................   .....,,,'',;,....   ..'........     .......'''',;::,'''',,,,,,,,;;;;;;,,'.',\n" +
					"'''''...............     ........''',,'...  ......',,,,..  ............''.......',,,''',,,;;,,,',,,;\n" +
					"'''''................    .......';:,......  ..''.;ll:'''...... ..'...............;::;;,,'''.....'',,\n" +
					",,'''................ .. ........;cl:,....  .','.:lc,.'.    .......'''.'........;ccc::c:;;:,'.......\n" +
					",,,''..''''''''.............''....',;;;::,...''..''..,;.   .......'''.......''',clc::::::cc:;;,''...\n" +
					",,,''.'''''''''.. ..........,,,'''...';;;'.........'......'';,'........';;..,,'';::::;,:ccc:;;;,,,,,\n" +
					",,,''''''''''''.......'.....,,,,',''''''............  ...''''.........,:lc..,,'',;;::::cccc:;;;;;::;\n" +
					",,''''''''''''.. .....''..''',,,,,,'.''''.',..'.........','''........,:llc..';'':cllcc::ccc::;;;:::;\n" +
					",,''',,,''''''.  .......''''''''',,'''''...,;;;,'....''',,'',,'....';:cll:......,ldolc:::cc:::;;:::;\n" +
					",''',,,,,,,,,'.   .......'.''''''.....',''''';:,.......','',;,....,:::ccl:'......:dddoll:::;;;;;::;;\n" +
					",'',,,,,,,,,,'.. ...........'''',,'....',,'',:;'.......',,,;,...';;::ccloc'..  ..;oooolc:;;;;;;;;;;,\n" +
					",,,;;;;,,,,,,..............'...,;;;,,'.';,.';;,.......',,,,'..',;;::cccllc,.    .,cllc:;;;,;;;,,,;;,\n" +
					",;;;;;;;;;,'.............'..',,,,,;;;;;::,,:c:,''''',',,,'...,;;;;::clllll:.......'::::;;;;;;;,,,,,'\n" +
					";::::;;;;;'''............''.',,,'',,'',,,',;;,'','''''''...';;;::::ccllooolc,. .','',::;;;;;;;,,,,'.\n" +
					":ccc:::::,';,.    .........',,'....',''............''....',,;:::;::cccllllll:'. .';,.';;;;,;,,,,''..\n" +
					"ccccccc:;,:;'.    .......'...''''............''.........'',;;:::;::ccclllc:cc:....','..,,,,'''''....\n" +
					"::ccccc;';:...     ..................    .............',,,,;::;;;::ccccccccccc:,........,,''''......\n" +
					";;:cccc;.,,.          ....       ...       ....  .....','',,:c;,,;::ccc::ccclc::,. .....',,'''......\n";
		String hou = 
					"                                                              ...''..                               \n" +
					"                                                         ..,;:loooooc;,.                            \n" +
					"                                                     ...':lllllllcccccll;.                          \n" +
					"                                               .,;:ccccloc:cccc::;;;,,;;c,                          \n" +
					"                                            .,cddddoc:codo:;,'...'......,:.                         \n" +
					"                                        .';ldxdddoll:::ldo;'.    ....   .:'                         \n" +
					"                                 ..',;:oxkxdddddoc:c;,,;:;'... .......  .'.                         \n" +
					"                              .;coddkOOxxxdddxdolcc:,'............   .....                          \n" +
					"                            .:oddxxkOkdllloddoolcc:;,..      .....   .....                          \n" +
					"                           'looodxkxxdolloollcccc:;,'.        ..........                            \n" +
					"                          ,lllloxkkdoooooolccc::::;;,'.      ..........                             \n" +
					"                         ,lclloodkxollllllcc:::;;:::::;,'.     .'''..                               \n" +
					"                        .clclloodxdllllcccc::;;,;;;:cccccl;                                         \n" +
					"                        :dccclloddollllcc::;;,,,,,;;;:ccccl'                                        \n" +
					"                       .locccclodolccccc:;;,,'''',,;;,;clloc.                                       \n" +
					"                       ;oc:cccldolc::c:;;,,''''',,,,''';clod,                                       \n" +
					"                      .,::::::cooc::cc:;,''''''''.......;clxl.                                      \n" +
					"                      .,,;:;;;cllc::cc:;,'',,''....... ..;cod'                                      \n" +
					"                       .,,cc:;:cll:;;:;,,,;:,....       .':lo,                                      \n" +
					"                       .,',c:,,:llc;:lc,,,;:;...        .';co;                                      \n" +
					"                        ...''..;ccc::cc;,;;;,..          .,:l:.                                     \n" +
					"                         . .....,cc:;:c:,,;,'..          .';cc.                                     \n" +
					"                        ..  ....'cc;;:c:;,,'...          ..,ll.                                     \n" +
					"                        ..  ....';:;;:;;;'''.....        ..';l'                                     \n" +
					"                        ........';;,;:;,,,'......      .....';;.                                    \n" +
					"                        .'...'..,;,,;::;;,,'''.,'      .''....''.                                   \n" +
					"                         ',',;'',,,,;:;,;;;;,,,:;.      ','....''..                                 \n" +
					"                          ;ll:,,',,,;;;,,,,;;,,:c.      .,,,'....';'                                \n";
	  	String moth = 
					  ",,,,,,'''''''''''''''''''''''''''''''''''''''''''''''...'''''...''..................................\n" +
					  "'''''',,''''''.'''''''''''''''''''''',,'''''....'''''...'''''....'..................................\n" +
					  ".''...'''',,,''''''''''',,;;;;:;;::;,,,,''''''''.''''''''''...........''............................\n" +
					  "''.'''''''''',,,''''',;:ccllccccccc:,,;::;,,''.''....''.............................................\n" +
	   				  "''''.''''''''''',,,,:cllcccccccccc:,;:ccc:::;,,,,'''..'.............................................\n" +
 					  "'''''''''''''''',::;;cllc::cc::ccc;;clllcccc:;:::;;,''.'............................................\n" +
					  "'''''''''''''',;cccc::clc::cccccolcllllllcccc:cccccc:;''............................................\n" +
					  ",,''''''''''',:ccllllldoccccccccoooddoollllllclolcccc:;''''.........................................\n" +
					  ",,,,,,,,''',;:cllllolodocccccccccclooooollllllloolccc::ccc:;,''.....................................\n" +
					  ",,,,,,,,,,,;:cllollolcccclccclllccooc:lolllolllccclc::::llooolc:;,'.'...............................\n" +
					  ",,,,,,,,,,;::cllollc:lkxoooooooooONNOc;:clddllcc:;:::;:::coollooolc:;,'.............................\n" +
					  ",,,,,,,,,;:cccllllc::d0OdddodddllONXkc;:clodoloolc:::;;;;:coolcclloollc:,''.........................\n" +
					  ",,,,,,,,;:ccccclllcc::lollllooocclol::cllldddoodxdooolc::;:clolc::ccllooolc;,.......................\n" +
					  ",,,,,;;,;:clodlccllllc::lollloolccccllloolllolooodxxkdl:::::cloolcccccccllollc;,'...................\n" +
					  ",,,,,;;;;:ccloolloddoloollollloolllooodolooollooollodxdo::cc:cllllllllc:::clllllc:,'................\n" +
					  ",,,,,,,;:llcloolclllllloooooccloollooddooddoollooolllodxdllc:::lllooooolc::::ccclllc:;,''...........\n" +
					  ",,,,,,;:lc:lxdllllclllooooodolloolloddddoooodooodoolllodoc:;;;;::cloooooolc::::::ccllllc:;,'........\n" +
					  ",,,;,;:cc;:dOxoooooooodddddddoodddddxdodddddxdooollllooolc:c;,,;::clooodooolc::::;;;:cclllcc;,'.....\n" +
					  ";;;,,;ccccokxllodooooooddddxdodddxxxkxxddddxxdooolllllclooccl:;,;;;:coddooooolc::;;;;;::cclllc:;,...\n" +
					  ";;;;;:llcoxkl;cllooooooddddxddxxxkxxxxdxxxxxxdolccccloolodollc;,,,;;clddooooooolcc:;;;;;;::cllcc:;,'\n" +
					  ";;;;:cooldxd:;:llloooooodddddxxxxddxxxddxxxxxdocclllodolcloolc:;,,;;;:loddoodooooolc:;;;;;;:clllccc:\n" +
					  ";;;:cloolddc;;cloolllcloddxxxxxxxxxxxxxxddxddolcoooodoolc:clool;;;;;;;:lddddddoooolllc:;;;;::clllccc\n" +
					  "::;:loooodo:;:cloollcccodddxxxddxxxdxxxxdxxdoodddddddollclolllc::cc:;;;;coodddoooolclllc:;;;::cclccc\n" +
					  ":;:cloloddl:::coooollllclooddxxxxxxdxxxxdddoodxxddddddlccllol::::cll:;,,;:looooooollloolc:;;;;:cclll\n" +
					  ";;:lllloddc;::cooodollllllloddxxxxxdddddoooooddddddollcclllll::ccllloc;,,,;cloooolllloollcc:;;::ccll\n" +
					  ":ccoolodxxoc;:cloollllloolloddxxddddooooooloooooooolcclllllcc:::cccclol:,,,,;cllllllloollcc:;:::cccc\n" +
					  ":cloolddolloc:cclodoollllllloooddoooooooolooooooollllllodolcc:;:cclcccldo:,,,,;:clllllcllcc:::::cccc\n" +
					  ":clolcloccc:cllllloooooc:::clooddooooooooooooooolloooloddolc:cc::clc;::cl:;,,,,,;:::ccccccc:::::cccc\n" +
					  ":cllllolccc::loooollloolcc::cloooooooddddddooooooooooooooll:cll:;;::::c:;;;;;:::;,,,;;;:::::::::::::\n" +
					  "cccccccccc::ccllccccccccccc::cccclllloooooollllloollllllllcc:ccc:;;:::clc::;;::c:;',;,,,,;;;;;;;::::\n" +
					  "ccccc:::ccccccc:::ccc::::ccc::cccccccccc::cccccccccccc:::::::::::;;::;:cc::;;;;;:;,,;;;;;,,,,,,,,,,,\n" +
					  "lllllcccllllllllccccc::cccllccclccccccccc:ccccccc:::::::::::::::::::;;:;;;;;;;;;;;,;;;;;;;;;;;,,,,,,\n";

		switch(choice){
		case 0: 
			return title;
		case 1:
			return death;
		case 2:
			return esc;
		case 3:
			return man;
		case 4:
			return smi;
		case 5:
			return skin;
		case 6:
			return hou;
		case 7:
			return moth;
		}
		return "error";

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

		System.out.print(holdArt(0));
	}
	public static void messageOrDesc(String message){
		//-------------------------------------------------------------messages-----------------------------------------------------------------------------------------------------------
		String starting_desc = "\nYou pick yourself up off the floor, dazed and disoriented from what had just occurred. \n"+
					  "You can feel the dampness of the water on your hands from the sodden tan carpet that seemingly \n"+
					  "lines every square inch of this place. From where you stand, every wall in view is covered \n"+
					  "by this lifeless, drab yellow wallpaper thats emitting a smell similar to that of paper mache. \n"+
					  "The low hum of the flourescent lights overhead is the only sign of activity in this stale place.\n\n"+

					  "In the current room, there is only you and your sense of direction, which, at the moment, is completely \n"+
					  "at a loss. You look around and see that you're able to go down or left \n";
		//----------------------------------------------------------room desc------------------------------------------------------------------------------------------------------------------
		String[] yellow_desc= new String[9];
		yellow_desc[0] = "\nEntering this new room, the smell of wallpaper remains as pungent as it has beem, but there aree\n"+
					  	 "pillars situated across the room.\n";

		yellow_desc[1] = "\nThis room looks to be the same as the last, except there's a set of pits across the floor \n"+
						 "and these pits seemingly go on forever. Luckily, there are slim passageways that seperate \n"+
						 "that you can walk across, but seeing as the room is relatively larger, you know to take caution.\n";

		yellow_desc[2] = "\nSome of the wallpaper in here has been torn off, lacerated by something big. These signs give you a \n"+
		                 "sense of uneasiness. The smell of the wet carpet doesn't help with the situation\n";

		yellow_desc[3] = "\nThis room looks to be pretty small, with narrow passageways allowing access in here. The flourescent lights \n"+
						 "are also slightly dimmer that usual.\n";

		yellow_desc[4] = "\nAs you enter this room, you can see writing on the wall. As far you can make out, its mostly \n"+
						 "indiscnernable scribbles and markings, but there some shapes drawn together in make some structure.\n";

		yellow_desc[5] = "\nThe room you enter is much darker than before, with the flourescnet lights flickering on and off. THe \n"+
						 "doesn't look to be too large and between the flickering of the lights you can see what appears to be \n"+
						 "two chairs.\n";

		yellow_desc[6] = "\nThe new room you walk into has a higher ceiling than what you've seen so far. There's three holes in \n"+
						 "the wall, but they're situated higher than normal, rendering them impossible to look in to. The \n"+
						 "wall farthest from you looks to have been smeared with some sort of black substance, fortunately \n"+
						 "its not giving off a smell.\n";

		yellow_desc[7] = "\nThis room wreaks of wet carpet and glue from the ripped wallpaper. There's small divider that don't \n"+
						 "connect with the ceiling which block off your vision from some of the rooms corners.\n";

		yellow_desc[8] = "\nYou can immediateley hear that the flourescnet lights are humming at a greater volume. Nestled in \n"+
						 "lies three discarded chairs torn apart viciously. You notice that there are stains around these chairs, \n"+
						 "and these stains are smeared along the carpet leading towards one of the doorways.\n";
		
		String[] pool_desc = new String[6];
		pool_desc[0] = "\nThis room doesn't look the same as what you've seen; in here there are tiles lining the entirety of the \n"+
					   "room. The floor is still wet, however.\n";

		pool_desc[1] = "\nThis room looks to be some sort of large pool area, with the telltale sign given by the giant hole in the \n"+
					   "center of the room. Each step you take in this room reverberates, the room wreaks of chlorine.\n";

		pool_desc[2] = "\nThe smell of chlorine hits your senses as you enter this room. Lights from over head beam through square holes \n"+
					   "in the ceiling emit down into the room and reflect off the white tiled walls and floor. Faint sounds from other \n"+
					   "rooms resonate softly throughout the room, giving you an uneasy feeling.\n";

		pool_desc[3] = "\nEntering this new room you immediately notice that there are scratch markings engraved all across walls here. \n"+
					   "Some of the tiles that are in this room are cracked or completely removed, seemingly by force.\n";

		pool_desc[4] = "\nWhen you enter this room, the first thing that catches your eye are the small pockets of water situated in \n"+
					   "each corner of the room and reflects a mosaic of light onto all surfaces of the room. Because of the presence \n"+
					   "of the water, the tile below your feet is slippery.\n";

		pool_desc[5] = "\nThis room looks to be a something out of pool locker room. The chlorine smell in the air assures you that there \n"+
					   "may be some source of water here in these rooms. In here, the lights that are in this room are somewhat more dimmer.\n";
		
		String[] apt_desc = new String[6];
		apt_desc[0] = "\nThe air in here is noticeably more stagnant as you step onto the wooden floors of what might be an apartment complex.\n";

		apt_desc[1] = "\nEntering this room, the walls are completely covered in white paint, and there exists several printers set up \n"+
					  "against those walls.\n";

		apt_desc[2] = "\nThe air in this room is much colder than usual. Looking around you notice that there are now windows in the \n"+
					  "walls, however the windows only show complete darkness on the other side, giving you an increasing amount \n"+
					  "of concern given the strange circumstances you're in\n";

		apt_desc[3] = "\nThe room is noticeably empty in here, the only exception being one table and a dumpster sitting in here. Each \n"+
					  "step you take in here causes the floorboards to creak under your feet. The overhead lamps are fortunately working.\n";

		apt_desc[4] = "\nThere is no smell in here, but you feel much colder than before, as if a draft from a window was left open. \n"+
					  "Scanning the room you find that there are two windows that don't show anything on the other side, and one of \n"+
					  "these windows is cracked open, asuumedly causing the breeze.\n";

		apt_desc[5] = "\nWalking into this room, you find several dumpsters lining the walls of the room, but they're not giving off \n"+
					  "any smell. The one window that's to your right shows what seems to be some living complex.\n";

		String[] under_desc = new String[4];
		under_desc[0] = "\nThe thin layer of dirt crunches beneath your feet as you enter this room. This place looks to be in some \n"+
						"underground area. The lights overhead are the flourescnet type again, connected by a a black wire to other \n"+
						"lights. Large industrial pipes line the walls of this room.\n";

		under_desc[1] = "\nThis room is covered in white, polished brick, and there's a weathered sign painted on one of the walls. \n"+
						"It says \"4th & LaFayette\", giving the assumption that you're might be in a subway area, but you're not \n"+
						"completely sure\n";

		under_desc[2] = "\nWhen you enter this room, you notice that walls are a mix between white brick and rock. This confuses you \n"+
						"seeing that the previous rooms were, for the most part, put together. But here it looks like run-down \n"+
						"maintainence area in side of some basement or cave complex\n";

		//This description is for the final room
		under_desc[3] = "\nAs you enter this particular room, every direction you look at is poorly lit and thus you can't really \n"+
						"make see anything that's in the room. The sounds in this room put you in a state of uneasiness that \n"+
						"surpasses any feeling that you've felt so far in this place. \n\n"+
						"After a minute of trying to understand where you are, the lights in the room suddenly turn on, blinding \n"+
						"you momentarily. As your vision reestablishes itself, you're face to face to, much to your surprise, JACK BLACK!"+
						"By far this is the most confused you've been in your life. Seeing THE actor from timeless classics such as \n"+
						"\"Kung Fu Panda\", \"Jumanji\", \"School of Rock\" & \"Goosebumps\" is very much a surprise, however there's \n"+
						"something... uncanny about this whole thing. He does not seem to be in the same state of delirium being \n"+
						"within this place, unlike you.\n\n"+
						"Mr. Black says nothing other than this: \n"+
						"\"To free yourself from these rooms, you must defeat me, Jack Black in a game of black-jack.\" \n"+
						"Seeing as you haven't found a single exit in this place, the guarantee of escape attracts you to the table \n"+
						"in the center of the room, reluctantly complying to Mr. Black's wishes.\n";

		//item descriptions---------------------------------------------------------------------------------------------------------------
		String[] desc_header = new String[3];
		desc_header[0] = "\nAfter scowering the room for anything useful, ";
		desc_header[1] = "\nAfter thoroughly searching the room, ";
		desc_header[2] = "\nLooking around the room for anything to use, ";

		String[] desc_present = new String[5];
		desc_present[0] = "you come across: \n";
		desc_present[1] = "you find: \n";
		desc_present[2] = "you happen upon: \n";
		desc_present[3] = "you happen to find: \n";
		desc_present[4] = "you find that there is: \n";

		String[] desc_absent = new String[4];
		desc_absent[0] = "you don't find anything that you can use.\n";
		desc_absent[1] = "you couldn't find anything\n";
		desc_absent[2] = "you find that there is nothing else in the room.\n";
		desc_absent[3] = "you don't find anything in here.\n";

		String[]  item_water = new String[3];
		item_water[0] = "an unopened bottle of almond water.";
		item_water[1] = "some almond water.";
		item_water[2] = "a bottle of almond water";

		String[] item_bandage = new String[2];
		item_bandage[0] = "a roll of bandages.";
		item_bandage[1] = "some bandages.";

		String[] item_pack = new String[2];
		item_pack[0] = "a first aid kit.";
		item_pack[1] = "a trauma kit.";

		String[] item_pipe = new String[3];
		item_pipe[0] = "a bent metal pipe.";
		item_pipe[1] = "a metal pipe brokem off at one of its ends.";
		item_pipe[2] = "a pipe with one of its ends crushed.";

		String[] item_leg = new String[3];
		item_leg[0] = "a chair leg that's been ripped off from the rest of the chair. "+
					   "Its nail is still intact.";
		item_leg[1] = "a leg of a chair. The base of the leg looks to be torn off, "+
		              "leaving exposed sharp splints of laminated wood.";
		item_leg[2] = "a chair leg. Looks to still be intact.";

		String[] item_bat = new String[2];
		item_bat[0] = "a baseball bat. The side of the bat has been bent inward.";
		item_bat[1] = "what looks to be a baseball bat, and you can still see the faded "+
					  "marker from its signature.";

		String[] item_racket = new String[3];
		item_racket[0] = "a tennis racket which looks to be contorted from some previous "+
						 "previous altercation.";
		item_racket[1] = "a bent tennis racket.";
		item_racket[2] = "a tennis racket. Half of it has been broken, leaving only two "+
		                 "prongs exposed from the rim of the racket.";

	
		String[] item_shroom = new String[2];
		item_shroom[0] = "a strange thing growing from the ground in the dark corner. \n"+
						 "They look to be some type of fungus, and the smell of them "+
						 "strangely smells like parmesean.";
		item_shroom[1] = "what seems to be mushrooms growing from some of the cracks "+
						 "in the wall.";

		String[] entity_encounter = new String[5];
		entity_encounter[0] = "\nThe moment you step into this new room, your heart drops as you come face to face \n"+
							  "with some kind of... indescribable thing.\n";
		entity_encounter[1] = "\nYou have no time to react entering this room, as suddenly an entity that towers over \n"+
							  "you becomes aware of your presence.\n";
		entity_encounter[2] = "\nThe room you enter feels different. The flourescent lights flicker, the air grows thinner. \n" +
							  "In the dark corner of the room, a pair of eyes stares you down, ensnaring you to this room.\n";
		entity_encounter[3] = "\nWalking into this room you feel that you're not alone. Your assumptions are proven correct, \n"+
							  "as some kind of crawling entity shambles across the floor towards you.\n";
		entity_encounter[4] = "\nThis new room seems to appear vacant at the moment. After a few seconds, some wretched entity \n"+
							  "enters the room from another doorway, letting out an ear-piercing yell.\n";

		switch(message){
		case "starting_desc":
			System.out.println(starting_desc);
			break;
		case "yellow_desc0":
			System.out.println(yellow_desc[0]);
			break;
		case "yellow_desc1":
			System.out.println(yellow_desc[1]);
			break;
		case "yellow_desc2":
			System.out.println(yellow_desc[2]);
			break;
		case "yellow_desc3":
			System.out.println(yellow_desc[3]);
			break;
		case "yellow_desc4":
			System.out.println(yellow_desc[4]);
			break;
		case "yellow_desc5":
			System.out.println(yellow_desc[5]);
			break;
		case "yellow_desc6":
			System.out.println(yellow_desc[6]);
			break;
		case "yellow_desc7":
			System.out.println(yellow_desc[7]);
			break;
		case "yellow_desc8":
			System.out.println(yellow_desc[8]);
			break;
		case "pool_desc0":
			System.out.println(pool_desc[0]);
			break;
		case "pool_desc1":
			System.out.println(pool_desc[1]);
			break;
		case "pool_desc2":
			System.out.println(pool_desc[2]);
			break;
		case "pool_desc3":
			System.out.println(pool_desc[3]);
			break;
		case "pool_desc4":
			System.out.println(pool_desc[4]);
			break;
		case "pool_desc5":
			System.out.println(pool_desc[5]);
			break;
		case "apt_desc0":
			System.out.println(apt_desc[0]);
			break;
		case "apt_desc1":
			System.out.println(apt_desc[1]);
			break;
		case "apt_desc2":
			System.out.println(apt_desc[2]);
			break;
		case "apt_desc3":
			System.out.println(apt_desc[3]);
			break;
		case "apt_desc4":
			System.out.println(apt_desc[4]);
			break;
		case "apt_desc5":
			System.out.println(apt_desc[5]);
			break;
		case "under_desc0":
			System.out.println(under_desc[0]);
			break;
		case "under_desc1":
			System.out.println(under_desc[1]);
			break;
		case "under_desc2":
			System.out.println(under_desc[2]);
			break;
		case "under_desc3":
			System.out.println(under_desc[3]);
			break;
		case "desc_header0":
			System.out.print(desc_header[0]);
			break;
		case "desc_header1":
			System.out.print(desc_header[1]);
			break;
		case "desc_header2":
			System.out.print(desc_header[2]);
			break;
		case "desc_present0":
			System.out.print(desc_present[0]);
			break;
		case "desc_present1":
			System.out.print(desc_present[1]);
			break;
		case "desc_present2":
			System.out.print(desc_present[2]);
			break;
		case "desc_present3":
			System.out.print(desc_present[3]);
			break;
		case "desc_present4":
			System.out.print(desc_present[4]);
			break;
		case "desc_absent0":
			System.out.print(desc_absent[0]);
			break;
		case "desc_absent1":
			System.out.print(desc_absent[1]);
			break;
		case "desc_absent2":
			System.out.print(desc_absent[2]);
			break;
		case "desc_absent3":
			System.out.print(desc_absent[3]);
			break;
		case "item_water0":
			System.out.println(item_water[0]);
			break;
		case "item_water1":
			System.out.println(item_water[1]);
			break;
		case "item_water2":
			System.out.println(item_water[2]);
			break;
		case "item_bandage0":
			System.out.println(item_bandage[0]);
			break;
		case "item_bandage1":
			System.out.println(item_bandage[1]);
			break;
		case "item_pack0":
			System.out.println(item_pack[0]);
			break;
		case "item_pack1":
			System.out.println(item_pack[1]);
			break;
		case "item_pipe0":
			System.out.println(item_pipe[0]);
			break;
		case "item_pipe1":
			System.out.println(item_pipe[1]);
			break;
		case "item_pipe2":
			System.out.println(item_pipe[2]);
			break;
		case "item_leg0":
			System.out.println(item_leg[0]);
			break;
		case "item_leg1":
			System.out.println(item_leg[1]);
			break;
		case "item_leg2":
			System.out.println(item_leg[2]);
			break;
		case "item_bat0":
			System.out.println(item_bat[0]);
			break;
		case "item_bat1":
			System.out.println(item_bat[1]);
			break;
		case "item_racket0":
			System.out.println(item_racket[0]);
			break;
		case "item_racket1":
			System.out.println(item_racket[1]);
			break;
		case "item_racket2":
			System.out.println(item_racket[2]);
			break;
		case "item_shroom0":
			System.out.println(item_shroom[0]);
			break;
		case "item_shroom1":
			System.out.println(item_shroom[1]);
			break;
		case "entity_encounter0":
			System.out.println(entity_encounter[0]);
			break;
		case "entity_encounter1":
			System.out.println(entity_encounter[1]);
			break;
		case "entity_encounter2":
			System.out.println(entity_encounter[2]);
			break;
		case "entity_encounter3":
			System.out.println(entity_encounter[3]);
			break;
		case "entity_encounter4":
			System.out.println(entity_encounter[4]);
			break;
		}	
	}
	//inventory actions---------------------------------------------------------------------------------------------------------------------
	public static void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {}
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

		if (current_entity.equals("LIVING MANNEQUIN")){
			
			System.out.println(holdArt(3));

			System.out.println(
				"\nA mannequin that resembles those typically found in department stores." + 
				"\nThey are normally hostile and will attack on sight. However, they are" +
				"\ngenerally easy to dispatch and can drop useful items.");
		}
		else if (current_entity.equals("SMILER")){ // Source: https://backrooms.fandom.com/wiki/Smilers
			
			System.out.println(holdArt(4));

			System.out.println("\nSmilers are well known by their eerie luminescent smile." + 
				"\nThey mainly lurk in a level's dark areas. Because of this, it is often difficult to" +
				"\nidentify the rest of their physical features." + 
				"\nTherefore, be warned, they are often the most dangerous of entities" +
				"\nand will attack when provoked.");
		}
		else if (current_entity.equals("SKIN-STEALER")){ // Source: https://backrooms.fandom.com/wiki/Skin-Stealers
		
			System.out.println(holdArt(5));

			System.out.println("\nSkin stealers are hostile entities that will normally attack wanderers" + 
				"\nwhen in a state of hunger. After killing their victims, they will absorb/eat the victim's" + 
				"\nflesh by \"wearing\" their skin. These entities are found on most levels and can imitate the " + 
				"\nvoices of human beings to lure potential victims.");
		}
		else if (current_entity.equals("HOUND")){ // Source: https://backrooms.fandom.com/wiki/Hounds
		
			System.out.println(holdArt(6));

			System.out.println("\nHounds are hostile humanoids with animal-like characteristics." + 
				"\nThey are commonly found throughout much of the backrooms, are generally hostile" +
				"\ntowards wanderers, and will attack on sight. Be warned, like other entities, they are deadly." +
				"\nAs such, it is best to run or fend them off with long-ranged weapons.");
		}
		else if (current_entity.equals("DEATHMOTH")){ // Source: https://backrooms.fandom.com/wiki/Deathmoths
			
			System.out.println(holdArt(7));

			System.out.println("\nDeathmoths resemble that of moths typically found in the normal world" +
				"\nwith the exception of their much larger appearances." + 
				"\nAlthough several deathmoths encounters have proven them to be neutral, they can still" + 
				"\nexhibit hostile tendancies including attacking those who wander close to their hives." + 
				"\nThese hives are typically found in certain levels and as such, the presence of deathmoths" + 
				"\nare higher and deadlier.");
		}
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
			System.out.println("\nWise choice\n");
		}

		else if (current_entity.equalsIgnoreCase("LIVING MANNEQUIN")) {
			System.out.println("\nYou successfully ran from the mannequin.\n" +
							   "But remember, they are also easy to take down\n");
		}

		else if (current_entity.equalsIgnoreCase("SKIN-STEALER")) { 
			System.out.println("\nRunning was a good choice. Skin-stealers are unpleasant creatures\n");
		}

		else if (current_entity.equalsIgnoreCase("HOUND")) {
			System.out.println("\nYou walked away slowly and stayed calm until you were out of sight.\n" + 
							   "Afterwards, you ran as far as you could from the beast.\n");
		}

		else if (current_entity.equalsIgnoreCase("DEATHMOTH")) {
			System.out.println("\nDeathmoths can fly quickly.\n" + 
							   "It outpaced you but you were able to lose it during the struggle\n") ;
		}
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

	  	System.exit(0);
	}
}