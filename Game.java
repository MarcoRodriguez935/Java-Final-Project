import java.util.Scanner;
import java.util.Random;

public class Game{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();

		//create world
		String[][][] world = fillWorld();

		//tracking movement health inv
		String[] inventory = {"FISTS", "--EMPTY--", "--EMPTY--", "--EMPTY--", "--EMPTY--"};
		int health = 100;
		int posx = 0;
		int posy = 0;
		//--------------------------------------------------------------------------------

		String name = readName();
		introMessage(name);

		startingRoomDesc();
		System.out.print("You see some kind of map on the wall.\n");

		int counter = 1;
		for(int i = 0; i < world[0].length; i++){
			for(int j = 0; j < world[0][i].length; j++){
				if(counter % 5 != 0){
					System.out.print(world[0][i][j] + " ");
					counter++;
				}
				else{
					System.out.println(world[0][i][j]);
					counter++;
				}
			}
		}
		System.out.println();

		boolean playerMenu = true;
		while(playerMenu){
			System.out.print( 
						"\nWhat do you want to do?\n" + 
						"> Move\n" + 
						"> Search\n" + 
						"> Inventory\n" +
						"> Cry\n");

			System.out.print("\n> ");
			String cmd = sc.nextLine();
			cmd = cmd.trim();

			//playerMenu
			boolean searchMenu = false;


			if(cmd.equalsIgnoreCase("move")){
				boolean display = true;
				while(display){

					String playerPosition = world[0][posx][posy];
					System.out.print("You are currently in: " + playerPosition + ".\n" +
								 "You are facing: " + world[0][posx + 1][posy] + ".\n");

					System.out.print("Where do you want to move? (N/E/S/W): ");	
					String move = sc.nextLine();
					move = move.trim();

					if(move.equalsIgnoreCase("n")){
						try{
							posx -= 1;
							posy = posy;
							playerPosition = world[0][posx][posy];

							display = false;
						} catch(ArrayIndexOutOfBoundsException ex){
							System.out.println("You bumped into a wall. Try again.");
							posx += 1;
							posy = posy;
						}

					}
					else if(move.equalsIgnoreCase("e")){
						try{
							posx = posx;
							posy += 1;
							playerPosition = world[0][posx][posy];

							display = false;
						} catch(ArrayIndexOutOfBoundsException ex){
							System.out.println("You bumped into a wall. Try again.");
						}
						

					}
					else if(move.equalsIgnoreCase("s")){
						try{
							posx += 1;
							posy = posy;
							playerPosition = world[0][posx][posy];

							display = false;
						} catch(ArrayIndexOutOfBoundsException ex){
							System.out.println("You bumped into a wall. Try again.");
						}
					

					}
					else if(move.equalsIgnoreCase("w")){
						try{
							posx = posx;
							posy -= 1;
							playerPosition = world[0][posx][posy];

							display = false;
						} catch(ArrayIndexOutOfBoundsException ex){
							System.out.println("You bumped into a wall. Try again.");
						}
					}
				}
			}
			if(cmd.equalsIgnoreCase("search")){
				searchMenu = true;
				searchMenu = searchMenu(world, searchMenu);
			}
			else if(cmd.equalsIgnoreCase("inventory")){
				health = inventory(inventory, health);
				System.out.println("out of inventory method");
			}
			else if(cmd.equalsIgnoreCase("cry")){
				int cryChance = rn.nextInt(10001);
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
						 "At least for now...");
				
				if(cryChance == 8375){
					System.out.println("By some miracle, your sobbing convinced the backrooms that you had completely surrendered to it, and decided it was done toying with you. ");
					System.out.print(holdArt(3));
					System.exit(0);
				}
			}
		}

	}
	public static void moveMenu(String[][][] world, boolean display){
		
	}

	public static boolean searchMenu(String[][][] world, boolean display){
		Scanner sc = new Scanner(System.in);
		int layer = 0;
		while(display){
			System.out.print("What do you want to search for?: ");
			String choice = sc.nextLine();

			switch(choice){
			case "coords":
				layer = 0;
				break;
			case "areas":
				layer = 1;
				break;
			case "rooms":
				layer = 2;
				break;
			case "descriptions":
				layer = 3;
				break;
			case "items":
				layer = 4;
				break;
			case "exit":
				display = false;
				return display;
			}
			System.out.println();
			int counter = 1;
			for(int i = 0; i < world[layer].length; i++){
				for(int j = 0; j < world[layer][i].length; j++){
					if(counter % 5 != 0){
						System.out.print(world[layer][i][j] + " ");
						counter++;
					}
					else{
						System.out.println(world[layer][i][j]);
						counter++;
					}
				}
			}
			System.out.println();
		}
		return display;
	}
	public static String[][][] fillWorld(){
		Random rn = new Random();
		String[][][] world = new String[5][5][5];

		//fill world with coords, area, room type, descriptions, items
		int settleCount = 0;
		int puzzleCount = 0;
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

				
				//roomDescriptions
				//world[3][posx][posy] = 


				world[4][posx][posy] = itemChance(world, posx, posy);
				}
			}
			return world;
		}
	public static String itemChance(String[][][] world, int posx, int posy){
		Random rn = new Random();
		
		if(posx == 0 && posy == 0){
			return "empty";
		}
		else if(posx == 4 && posy == 4){
			return "empty";
		}

		int itemsInRoom = rn.nextInt(5);

		switch(itemsInRoom){
		case 0:
			return "empty";
		case 1:
			return holdItems(1);
		case 2:
			return holdItems(2);
		case 3:
			return "empty";
		case 4:
			return holdItems(1);
		}
		return "empty";
		}
	public static String holdItems(int itemNum){
		Random rn = new Random();
		int itemCount = 0;
		int weaponCount = 0;
		int puzzleItemCount = 0;	

		String[] weapons = {"baseball bat", "metal pipe", "tennis racket", "chair leg"};
		String[] health = {"almond water", "backshrooms", "bandage", "health pack"};
		String[] puzzle = {"kirby", "sussy plush", "fat bunny"};

		if(itemNum == 1){
			int itemType = rn.nextInt(3);

			//validation
			if(itemCount == 8){
				return "empty";
			}
			else if(puzzleItemCount == 3){
				itemType = rn.nextInt(2);
			}

			if(weaponCount == 4 && puzzleItemCount == 3){
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
			case 2: 
				itemCount++;
				puzzleItemCount++;
				return (puzzle[rn.nextInt(3)]);
			}

		}
		else if(itemNum == 2){
			String output = "";

			int itemType1 = rn.nextInt(3);
			int itemType2 = rn.nextInt(2);

			//validation
			if(itemCount == 8){
				return "empty";
			}
			else if(puzzleItemCount == 3){
				itemType1 = rn.nextInt(2);
				itemType2 = rn.nextInt(2);
			}

			if(weaponCount == 4){
				if(puzzleItemCount == 3){
					itemType1 = 1;
					itemType2 = 1;
				}
			}

			//choose item
			switch(itemType1){
			case 0: 
				itemCount++;
				itemCount++;
				output += (weapons[rn.nextInt(4)]);
				weaponCount++;
				break;
			case 1: 
				itemCount++;
				itemCount++;
				output += (health[rn.nextInt(4)]);
				break;
			case 2: 
				itemCount++;
				itemCount++;
				output += (puzzle[rn.nextInt(3)]);
				puzzleItemCount++;
				break;
			}
			switch(itemType2){
			case 0: 
				output += (weapons[rn.nextInt(4)]);
				weaponCount++;
				break;

			case 1: 
				output += (health[rn.nextInt(4)]);
				break;
			}	
		}
		return "empty";
	}
	public static int inventory(String[] inventory, int health) {
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
				addToInventory(inventory);
			}
			else if (cmd.equalsIgnoreCase("drop")) {
				removeFromInventory(inventory);
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

	public static String[] addToInventory(String[] inv) {
		Scanner input = new Scanner(System.in);

		System.out.println("\nTo return, enter BACK\n");

		System.out.print("Enter an item to add: ");
		String addition = input.nextLine();
		addition = addition.trim();

		if (addition.equalsIgnoreCase("back"))
			return inv;
		else {
			// verify if the item is valid or if the item is available for pickup
			while (addition.equalsIgnoreCase("fists") || addition.equalsIgnoreCase("--empty--") || 
				!isValidItem(addition)) {
				System.out.println("Cannot add item");
				System.out.print("\nEnter an item to add: ");
				addition = input.nextLine();
				addition = addition.trim();
			}

			for (int i = 0; i < inv.length; i++) {
				if (inv[i].equals("--EMPTY--")) {
					inv[i] = addition;
					break;
				}
			}
		}	
		return inv;
	}

	// To allow the user to drop items
	public static String[] removeFromInventory(String[] inv) {
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
					inv[i] = "--EMPTY--";
					break;
				}
			}
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
			else if (health_item.equalsIgnoreCase("bandage")) {
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
		if (item.equalsIgnoreCase("almond water") || item.equalsIgnoreCase("bandage") ||
			item.equalsIgnoreCase("backshroom") || item.equalsIgnoreCase("health pack"))
			return true;
		else
			return false;
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
	
	public static boolean lowHealth(int health) {
		if (health < 50 && health > 0)
			return true;
		else 
			return false;
	}
	public static String startingRoomDesc(){
		String starting_desc = "You pick yourself up off the floor, dazed and disoriented from had just occurred. \n"+
					  "You can feel the dampness of the water on your hands from the sodden tan carpet that seemingly \n"+
					  "lines every square inch of this place. From where you stand, every wall in view is covered \n"+
					  "by this lifeless, drab yellow wallpaper thats emitting a smell similar to that of paper mache. \n"+
					  "The low hum of the flourescent lights overhead is the only sign of activity in this stale place.\n\n"+

					  "In the current room, there is only you and your sense of direction, which, at the moment, is completely \n"+
					  "at a loss. You look around and see that you're able to go down or left \n"+
					  "\n You decide to go ________.\n";
		return starting_desc;
	}
	public static String altar(String item1, String item2, String item3){
		//the "items" in the message prompt are there just in case
		String altar = "The lights in this room are all turned off; the only source of light coming from the candle of an altar \n"+
					   "that exists in the center of the room. Out of curiosity, you continue to search around this altar, discovering \n"+ 
					   "a small box with a padlock on it and an empty backpack. On top of the altar lies the aforementioned \n"+
					   "candles, with only one being lit, along with an item lying on one of the altar pillars. You can see \n"+
					   "a small key locked at the base of the altar, which you assume can only be for the padlock on the box.\n\n"+
					   "You then see through the dim light of the candle that there is writing next to each pillar.\n\n"+
					   "One pillar writes \""+item1+"\", the second pillar writes \""+item2+"\", and on the third pillar \n"+
					   "lies a "+item3+".";
		return altar;
	}
	public static String[] yellowRoomDesc(){
		String[] yellow_desc= new String[9];
		yellow_desc[0] = "Entering this new room, the smell of wallpaper remains as pungent as it has beem, but there aree\n"+
					  	 "pillars situated across the room.";

		yellow_desc[1] = "This room looks to be the same as the last, except there's a set of pits across the floor \n"+
						 "and these pits seemingly go on forever. Luckily, there are slim passageways that seperate \n"+
						 "that you can walk across, but seeing as the room is relatively larger, you know to take caution.";

		yellow_desc[2] = "Some of the wallpaper in here has been torn off, lacerated by something big. These signs give you a \n"+
		                 "sense of uneasiness. The smell of the wet carpet doesn't help with the situation";

		yellow_desc[3] = "This room looks to be pretty small, with narrow passageways allowing access in here. The flourescent lights \n"+
						 "are also slightly dimmer that usual.";

		yellow_desc[4] = "As you enter this room, you can see writing on the wall. As far you can make out, its mostly \n"+
						 "indiscnernable scribbles and markings, but there some shapes drawn together in make some structure.";

		yellow_desc[5] = "The room you enter is much darker than before, with the flourescnet lights flickering on and off. THe \n"+
						 "doesn't look to be too large and between the flickering of the lights you can see what appears to be \n"+
						 "two chairs.";

		yellow_desc[6] = "The new room you walk into has a higher ceiling than what you've seen so far. There's three holes in \n"+
						 "the wall, but they're situated higher than normal, rendering them impossible to look in to. The \n"+
						 "wall farthest from you looks to have been smeared with some sort of black substance, fortunately \n"+
						 "its not giving off a smell.";

		yellow_desc[7] = "This room wreaks of wet carpet and glue from the ripped wallpaper. There's small divider that don't \n"+
						 "connect with the ceiling which block off your vision from some of the rooms corners.";

		yellow_desc[8] = "You can immediateley hear that the flourescnet lights are humming at a greater volume. Nestled in \n"+
						 "lies three discarded chairs torn apart viciously. You notice that there are stains around these chairs, \n"+
						 "and these stains are smeared along the carpet leading towards one of the doorways.";
		return yellow_desc;
	}
	public static String[] poolDesc(){
		String[] pool_desc = new String[6];
		pool_desc[0] = "This room doesn't look the same as what you've seen; in here there are tiles lining the entirety of the \n"+
					   "room. The floor is still wet, however.";

		pool_desc[1] = "This room looks to be some sort of large pool area, with the telltale sign given by the giant hole in the \n"+
					   "center of the room. Each step you take in this room reverberates, the room wreaks of chlorine.";

		pool_desc[2] = "The smell of chlorine hits your senses as you enter this room. Lights from over head beam through square holes \n"+
					   "in the ceiling emit down into the room and reflect off the white tiled walls and floor. Faint sounds from other \n"+
					   "rooms resonate softly throughout the room, giving you an uneasy feeling.";

		pool_desc[3] = "Entering this new room you immediately notice that there are scratch markings engraved all across walls here. \n"+
					   "Some of the tiles that are in this room are cracked or completely removed, seemingly by force.";

		pool_desc[4] = "When you enter this room, the first thing that catches your eye are the small pockets of water situated in \n"+
					   "each corner of the room and reflects a mosaic of light onto all surfaces of the room. Because of the presence \n"+
					   "of the water, the tile below your feet is slippery.";

		pool_desc[5] = "This room looks to be a something out of pool locker room. The chlorine smell in the air assures you that there \n"+
					   "may be some source of water here in these rooms. In here, the lights that are in this room are somewhat more dimmer.";
		return pool_desc;
	}
	public static String[] aptDesc(){
		String[] apt_desc = new String[6];
		apt_desc[0] = "The air in here is noticeably more stagnant as you step onto the wooden floors of what might be an apartment complex.";

		apt_desc[1] = "Entering this room, the walls are completely covered in white paint, and there exists several printers set up \n"+
					  "against those walls.";

		apt_desc[2] = "The air in this room is much colder than usual. Looking around you notice that there are now windows in the \n"+
					  "walls, however the windows only show complete darkness on the other side, giving you an increasing amount \n"+
					  "of concern given the strange circumstances you're in";

		apt_desc[3] = "The room is noticeably empty in here, the only exception being one table and a dumpster sitting in here. Each \n"+
					  "step you take in here causes the floorboards to creak under your feet. The overhead lamps are fortunately working.";

		apt_desc[4] = "There is no smell in here, but you feel much colder than before, as if a draft from a window was left open. \n"+
					  "Scanning the room you find that there are two windows that don't show anything on the other side, and one of \n"+
					  "these windows is cracked open, asuumedly causing the breeze.";

		apt_desc[5] = "Walking into this room, you find several dumpsters lining the walls of the room, but they're not giving off \n"+
					  "any smell. The one window that's to your right shows what seems to be some living complex.";
		return apt_desc;

	}
	public static String[] underDesc(){
		String[] under_desc = new String[4];
		under_desc[0] = "The thin layer of dirt crunches beneath your feet as you enter this room. This place looks to be in some \n"+
						"underground area. The lights overhead are the flourescnet type again, connected by a a black wire to other \n"+
						"lights. Large industrial pipes line the walls of this room.";

		under_desc[1] = "This room is covered in white, polished brick, and there's a weathered sign painted on one of the walls. \n"+
						"It says \"4th & LaFayette\", giving the assumption that you're might be in a subway area, but you're not \n"+
						"completely sure";

		under_desc[2] = "When you enter this room, you notice that walls are a mix between white brick and rock. This confuses you \n"+
						"seeing that the previous rooms were, for the most part, put together. But here it looks like run-down \n"+
						"maintainence area in side of some basement or cave complex";

		//This description is for the final room
		under_desc[3] = "As you enter this particular room, every direction you look at is poorly lit and thus you can't really \n"+
						"make see anything that's in the room. The sounds in this room put you in a state of uneasiness that \n"+
						"surpasses any feeling that you've felt so far in this place. \n\n"+
						"After a minute of trying to understand where you are, the lights in the room suddenly turn on, blinding \n"+
						"you momentarily. As your vision reestablishes itself, you're face to face to, much to your surprise, JACK BLACK!"+
						"By far this is the most confused you've been in your life. Seeing THE actor from timeless classics such as \n"+
						"\"Kung Fu Panda\", \"Jumanji\", \"School of Rock\" & \"Goosebumps\" is very much a surprise, however there's \n"+
						"something... uncanny about this whole thing. He does not seem to be in the same state of delirium being \n"+
						"within this place, unlike you.\n\n"+
						"Mr. Black says nothing other than this: \n"+
						"\"To free yourself from these rooms, become the victor from a simple game of poker\" \n"+
						"Seeing as you haven't found a single door in this place, the guarantee of escape attracts you to the table \n"+
						"in the center of the room, reluctantly complying to Mr. Black's wishes.";
		return under_desc;
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
		String man =  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣾⣿⣷⣶⣄⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣷⡀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠘⠿⢻⣿⣿⡄\n" +
				      "⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠸⠋⢿⣇\n" +
					  "⠀⢀⣾⣿⣿⢿⣿⣿⠟⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠁\n" +
					  "⣶⣿⣿⢿⣯⣼⡿⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀\n" +
					  "⠘⠻⠟⠀⠉⡿⠁⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⡇⢿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⡟⠀⠸⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⡇⠀⠀⢿⣿⣿⣧⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⣿⠋⠀⠀⠀⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⣿⣿⣿⠄⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⢿⣿⣿⡄⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⢘⣿⣿⣧⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢿⣿⣷⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n";
		String smi =  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⢠⣺⢿⢖⡄⠀⠀⠀⠀⠀⠀⠀⠀⣠⡲⣿⢗⠄⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠸⢟⣵⣮⠃⠀⠀⠀⠀⠀⠀⠀⠀⠸⣟⣤⡝⠇⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⢀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⡀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠠⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠈⠙⢳⡆⡆⣤⢠⡄⣤⢠⣤⡤⣦⣴⢰⠸⠈⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⡇⣿⢸⡇⣿⢸⣿⡇⣿⡿⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡆⠙⠸⡇⣿⢸⢿⠇⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠁⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n";
		String skin = "⠀⠀⠀⠀⢶⡆⠀⠀⣴⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⢠⣾⣿⣦⣤⣭⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⣰⠏⠀⢹⣻⣭⣭⡧⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⢠⠏⠀⠴⠚⣷⣿⣿⠀⠀⢀⡤⠖⠛⠹⠶⠤⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⡏⠀⠀⠀⡼⠉⠉⠁⢀⡴⠋⠀⠀⠤⢄⡀⠀⠀⠈⢢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⡇⠀⠀⠀⢧⡀⠀⢠⠎⠀⢠⣤⡞⠒⠲⡌⠃⠀⠀⠀⠱⢤⡀⠀⢀⣀⣀⣀⠀⠀\n" +
					  "⠀⣧⠀⠀⠀⠀⠙⠲⠏⠀⢀⡀⠙⣇⠀⠀⢘⡶⠆⣤⠤⠔⢲⣯⡖⠉⠀⠀⠈⢧⠀\n" +
					  "⠀⢺⣦⡀⠀⠂⠀⠀⠀⠀⠀⢠⣄⠼⣗⠒⠋⠀⠀⠹⣄⣠⣿⡋⡀⢠⣤⡆⠀⢸⠀\n" +
					  "⠀⠀⠀⣇⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠈⠦⣠⠴⣄⢀⣠⣄⣸⠇⠀⣳⣿⣧⠈⢹⠁\n" +
					  "⠀⠀⠀⠘⠶⡆⠀⠆⢶⣴⠀⢾⠀⠀⠀⠀⠀⠀⠈⠉⡼⡭⣭⡴⠖⠼⠛⣿⣿⠏⠀\n" +
					  "⠀⠀⠀⠀⠀⢻⠀⠀⠀⠁⠀⠘⡄⠀⣠⢤⣀⡤⡄⢸⣿⣿⠋⠀⠀⠀⠀⠙⠁⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⣏⠀⠀⠀⠀⠀⠀⠈⠉⠁⠀⠀⠀⠘⠛⢱⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⣸⠁⠀⠀⠸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠚⠃⠀⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠹⡆⠀⠀⠀⣷⣄⢠⡀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⢸⠃⠀⡄⠀⠀⠺⠾⠃⠀⠀⠀⠀⠾⠀⢹⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⣀⣀⡴⠋⠀⠛⠁⠀⠀⠀⠀⠀⠀⢀⡄⠀⠀⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠃⠀⢀⣾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⢸⠁⠀⠀⠀⠀⣤⡄⠀⠀⠀⡴⠛⠲⡄⠀⠀⠀⠀⠸⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⡇⠀⠀⠀⣀⠀⠘⠀⠀⣠⠞⠁⠀⠀⢣⠀⠀⠀⠀⠠⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠘⠒⠒⠶⠁⠉⠉⠉⠉⠁⠀⠀⠀⠀⡞⠀⠀⠰⠇⠐⠛⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣼⠁⠀⠀⠀⠀⠀⠀⠈⢳⡄⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠙⠷⠤⠤⠤⠤⠿⠉⠁⠀⠀⠀⠀⠀⠀⠀\n";
		String hou = "⠀⠀⠀⢀⣠⣤⣶⣷⣿⣾⣦⣤⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⢴⣾⣿⣿⠟⠛⠛⠻⠿⣿⣿⣿⣿⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣶⣶⣶⣶⣦⡤⠀⠀⠀\n" +
					  "⠀⣴⣿⣿⡟⣡⣴⣶⣶⣶⣤⣄⠉⢿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⠿⠿⣿⣿⣿⣿⣿⣿⣷⡀⠀\n" +
					  "⣼⣿⣿⡟⣰⣿⣿⣿⣿⣿⣿⣿⣷⡀⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⠟⠉⠀⠀⠀⠀⠀⠈⠙⠻⣿⣿⣷⡄\n" +
					  "⣻⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠸⣿⡇⠀⠀⠀⠀⣠⠀⠀⠀⣿⣿⣿⠃⠀⠀⣠⣾⣿⣿⣿⣶⣤⡀⣿⣿⣿⡄\n" +
					  "⠿⣿⣿⣿⣌⠻⣿⣿⣿⣿⣿⣿⣿⠟⠀⢠⣿⠇⠀⠀⠀⣤⣯⠀⠀⠀⣿⣿⡇⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⡇⣿⣿⣿⡇\n" +
					  "⠐⢿⣿⣿⣿⣷⣌⡙⠛⠻⠛⠋⢁⣠⣴⣿⠏⠀⢀⣴⣿⣿⣿⣷⡀⠀⢹⣿⣷⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⢡⣿⣿⣿⠀\n" +
					  "⠀⠝⢻⣿⣿⣿⣿⣿⣿⣶⣶⣾⣿⣿⣿⠋⢀⣴⣿⣿⣿⣿⣿⣿⣷⠀⠙⣿⣿⣷⣄⡈⠛⠛⠛⠛⢛⣫⣵⣿⣿⣿⡇⠀\n" +
					  "⠀⠄⠀⠛⣿⢿⣿⣿⣿⣿⣿⠟⠉⠀⠁⠠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠐⠿⢿⣿⣿⣿⣷⣶⣶⣿⣿⣿⣿⣿⣿⣿⠃⠀\n" +
					  "⠀⢠⣤⣄⣛⣹⣿⣇⣙⡏⠁⠀⠀⠀⠀⠀⠻⢿⠛⠻⢿⢿⣿⣿⣿⡇⠀⠀⠀⠙⠿⣿⡟⠭⣿⣿⣿⣿⣿⣿⡿⠃⠀⠀\n" +
					  "⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣶⣶⣤⣤⣀⣀⣀⡘⠀⠀⠀⠀⠐⢿⡿⠁⠀⠀⠀⠀⠀⣸⠃⠀⣨⣴⣿⣿⣿⣿⠇⠀⠀⠀\n" +
					  "⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⣧⡟⠹⣉⡿⠋⠻⡿⠻⢷⡶⠦⣾⣇⣀⣀⣀⣴⣶⣶⣿⣷⣾⣿⣿⡿⢿⣿⠏⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠸⣿⣿⣿⣾⣿⣩⣷⣤⣨⣧⡀⢀⠇⠀⠀⡇⠀⠀⢿⠀⢿⣭⣿⣿⣼⣿⣿⣿⡿⠋⠀⢸⡟⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣾⣿⣶⣶⣧⣤⣼⣷⣿⣿⣿⣿⣿⠏⠀⠀⠀⠈⠇⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⣿⡈⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠈⠣⠀⠘⠻⣿⣿⣿⢿⣿⣿⣿⣿⡿⢿⣿⢿⣿⣿⣿⣿⣿⣿⠿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣷⣤⣧⣀⠀⡇⠀⠀⣧⠀⠸⠀⠘⢿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣶⣶⣿⣦⣾⣷⣾⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣿⠟⠉⠁⠀⣸⡟⠑⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
					  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⠃⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n";
	  	String moth = ".-\"\"\"\"\"\"\"---,.               n,                                      ..--------..\n" +
					  "\\-          ,,\'\'\'-..      n   \'\\.                ,.n           ..--\'\'           )\n" +
					  " \\-     . .,;))     \'\'-,   \\     \'\'.. .\'\"\'. .,-\'\'    .n   ..-\'\'   (( o         _/\n" +
					  "  \\- ' ''''':'          ''-.'\"|'--_  '     '  ,.--'''..-''         ' ' ' - .  _/\n" +
					  "   \\-                       ''->.  \'   ,--. '/' >..''                        _/\n" +
					  "    \\                     (,       /  /.  .\\ \\ ''    ,)                     ./\n" +
					  "     ''.    .  ..         ')          \\ .. /         ('          ..       ./\n" +
					  "        ''-... . ._ .__         .''.  //..\\  ,'.            __ _ _,__.--'\n" +
					  "            /' ((    ..'' ' ' '-'  6  \\/__\\/  ' '- - -' ' ',''   - '\\\n" +
					  "           '(.  6,    '..          /.   ''  .'          ,,'     ) )  )\n" +
					  "            '\\  \'C_,_   ==,      / '_      _|\\       ,'', ,,_.;-' _/\n" +
					  "              '._ ,   ')   E     /'|_ ')()('_' \\     C  ,I'''  _.-'\n" +
					  "                 ''''''\\ (('   ,/  ''  (()) ''  '-._ _ __---'''\n" +
					  "                        '' '' '    '==='()'=='\n" +
					  "                                   '(       )'    \n" +
					  "                                   '6        '\n" +
					  "                                    \\       /\n" +
					  "                                   '          '\n" +
					  "                                    '        '\n" +
					  "                                     '      '\n" +
					  "                                      '    '\n" +
					  "                                       '..'\n";




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
}

	