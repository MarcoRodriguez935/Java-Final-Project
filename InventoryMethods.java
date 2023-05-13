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
			inventory(inventory, health);

		System.out.println("out of inventory method");
	}

	public static String[] inventory(String[] inventory, int health) {
		Scanner input = new Scanner(System.in);
		boolean inv = true;

		while (inv) {
			System.out.println("\nInventory:");
			displayList(inventory);
			System.out.println();
			System.out.println("What would you like to do?:\n");
			System.out.println("Add");
			System.out.println("Drop");
			System.out.println("Use");
			System.out.println("Exit");
			System.out.println();

			System.out.print("> ");
			String cmd = input.nextLine();
			cmd = cmd.trim();

			while (!cmd.equalsIgnoreCase("add") && !cmd.equalsIgnoreCase("drop")
				&& !cmd.equalsIgnoreCase("use") && !cmd.equalsIgnoreCase("exit")) {
				System.out.print("> ");
				cmd = input.nextLine();
				cmd = cmd.trim();
			}

			if (cmd.equalsIgnoreCase("add")) {
				addToInventory(inventory);
			}
			else if (cmd.equalsIgnoreCase("drop")) {
				removeFromInventory(inventory);
			}
			else if (cmd.equalsIgnoreCase("use")) {
				System.out.println("invoke heal method here");
			}
			else if (cmd.equalsIgnoreCase("exit")) {
				inv = false;
			}
		}
		return inventory;	
	}

	public static void displayList(String[] list) {
		for (int i = 0; i < list.length; i++) {
				System.out.println(" " + (i+1) + ")  " + list[i]);
		}
	}

	public static String[] addToInventory(String[] inv) {
		Scanner input = new Scanner(System.in);

		System.out.println("To exit, enter BACK\n");

		System.out.print("Enter an item to add: ");
		String addition = input.nextLine();
		addition = addition.trim();

		if (addition.equalsIgnoreCase("back"))
			return inv;
		else {
			// verify if the item is valid or if the item is available for pickup
			while (addition.equalsIgnoreCase("fists") || addition.equalsIgnoreCase("--empty--")) {
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

	public static String[] removeFromInventory(String[] inv) {
		Scanner input = new Scanner(System.in);

		System.out.println("To exit, enter BACK\n");

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
}
