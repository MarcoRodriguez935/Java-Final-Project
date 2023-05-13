import java.util.Scanner;

public class InventoryMethods {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String[] inventory = {"FISTS", "--EMPTY--", "--EMPTY--", "--EMPTY--", "--EMPTY--"};
		int health = 100;

		System.out.print("> ");
		String cmd = input.nextLine();
		cmd = cmd.trim();

		if (cmd.equalsIgnoreCase("inventory"))
			health = inventory(inventory, health);

		System.out.println("out of inventory method");
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
}
