import java.util.Scanner;

public class InventoryMethods {
	public static void main(String[] args) {
		String[] inventory = {"FISTS", "--EMPTY--", "--EMPTY--", "--EMPTY--", "--EMPTY--"};
	}

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
}