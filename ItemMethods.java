public class ItemMethods {
	public static void main(String[] args) {
		
	}
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
}