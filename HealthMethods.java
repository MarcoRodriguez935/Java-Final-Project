import java.util.Scanner;

public class HealthMethods {
	public static void main(String[] args) {
		int health = 100;
	}

	// Some of these methods need the inventory methods to work

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
}