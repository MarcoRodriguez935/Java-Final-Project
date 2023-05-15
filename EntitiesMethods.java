public class EntitiesMethods {
	public static void main(String[] args) {
		
	}

	public static int entityEncounter(int health, String[] inventory, String current_level, 
		String[] entities_encountered) {

		String current_entity = "";
		int entity_health = 0;
		String entity_type = ""; //Hostile, or Neutral

		int r = (int)(Math.random() * (5 - 1 + 1) + 1)

		if (r == 1) {
			current_entity = "LIVING MANNEQUIN";
			entity_health = 50;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}	
		else if (r == 2) {
			current_entity = "SMILER";
			entity_health = 200;
			entity_type = "Neutral";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		else if (r == 3) {
			current_entity = "SKIN-STEALER";
			entity_health = 140;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		else if (r == 4) {
			current_entity = "HOUND";
			entity_health = 120;
			entity_type = "Hostile";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		else if (r == 5) {
			current_entity = "DEATHMOTH";
			entity_health = 140;
			entity_type = "Neutral";

			getEntityDescription(current_entity, entity_health, entity_type);
			updateElementsPassed(entities_encountered, current_entity);

			health = fightEntity(health, inventory, current_entity);
			return health;
		}
		return health;
	}

	public static void getEntityDescription(String current_entity, int entity_health,
		String entity_type) {

		System.out.println("\nENTITY ENCOUNTERED: " + current_entity);
		System.out.println("\nENTITY HEALTH: " + entity_health + "%");
		System.out.println("\nENTITY TYPE: " + entity_type);

		if (current_entity.equals("LIVING MANNEQUIN"))
			System.out.println(
				"\nA mannequin that resembles those typically found in department stores." + 
				"\nThey are normally hostile and will attack on sight. However, they are" +
				"\ngenerally easy to dispatch and can drop useful items.");
		else if (current_entity.equals("SMILER")) // Source: https://backrooms.fandom.com/wiki/Smilers
			System.out.println("\nSmilers are well known by their eerie luminescent smile." + 
				"\nThey mainly lurk in a level's dark areas. Because of this, it is often difficult to" +
				"\nidentify the rest of their physical features." + 
				"\nTherefore, be warned, they are often the most dangerous of entities" +
				"\nand will attack when provoked.");
		else if (current_entity.equals("SKIN-STEALER")) // Source: https://backrooms.fandom.com/wiki/Skin-Stealers
			System.out.println("\nSkin stealers are hostile entities that will normally attack wanderers" + 
				"\nwhen in a state of hunger. After killing their victims, they will absorb/eat the victim's" + 
				"\nflesh by \"wearing\" their skin. These entities are found on most levels and can imitate the " + 
				"\nvoices of human beings to lure potential victims.");
		else if (current_entity.equals("HOUND")) // Source: https://backrooms.fandom.com/wiki/Hounds
			System.out.println("\nHounds are hostile humanoids with animal-like characteristics." + 
				"\nThey are commonly found throughout much of the backrooms, are generally hostile" +
				"\ntowards wanderers, and will attack on sight. Be warned, like other entities, they are deadly." +
				"\nAs such, it is best to run or fend them off with long-ranged weapons.");
		else if (current_entity.equals("DEATHMOTH")) // Source: https://backrooms.fandom.com/wiki/Deathmoths
			System.out.println("\nDeathmoths resemble that of moths typically found in the normal world" +
				"\nwith the exception of their much larger appearances." + 
				"\nAlthough several deathmoths encounters have proven them to be neutral, they can still" + 
				"\nexhibit hostile tendancies including attacking those who wander close to their hives." + 
				"\nThese hives are typically found in certain levels and as such, the presence of deathmoths" + 
				"\nare higher and deadlier.");
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
			System.out.println("\nChoose an item:");
			weapon = chooseItem();

			while (!verifyItem(inventory, weapon) || !isWeapon(weapon)) {
				weapon = chooseItem();
			}

			health = getFightOutcome(health, weapon, current_entity);

		}
		else if (cmd.equalsIgnoreCase("flee")) {
			health = getFleeOutcome(health, current_entity);
		}

		return health;
	}
	
	public static String chooseItem() {
		Scanner input = new Scanner(System.in);
		System.out.print("> ");
		String item = input.nextLine();
		item = item.trim();

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
	
	public static boolean isWeapon(String weapon) {
		if (weapon.equalsIgnoreCase("fists") || weapon.equalsIgnoreCase("metal pipe") 
			|| weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket") ||
			weapon.equalsIgnoreCase("baseball bat"))
			return true;
		else 
			return false;
	}
	
	public static int getFightOutcome(int health, String weapon, String current_entity) {

		int health_lost = 0;

		// mannequin outcomes
		if (current_entity.equals("LIVING MANNEQUIN")) {
			if (weapon.equalsIgnoreCase("fists"))
				health_lost += (int)(Math.random() * (5 - 3 + 1) + 3);
			else if (weapon.equalsIgnoreCase("metal pipe") || weapon.equalsIgnoreCase("chair leg") ||
				weapon.equalsIgnoreCase("tennis racket") || weapon.equalsIgnoreCase("baseball bat"))
				health_lost += 0;
		}

		// smiler outcomes
		else if (current_entity.equalsIgnoreCase("SMILER")) {
			if (weapon.equalsIgnoreCase("fists") || weapon.equalsIgnoreCase("metal pipe") ||
				weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket") ||
				weapon.equalsIgnoreCase("baseball bat"))
				health_lost += (int)(Math.random() * (90 - 75 + 1) + 75);
		}

		// skin-stealer outcomes
		else if (current_entity.equalsIgnoreCase("SKIN-STEALER")) {
			if (weapon.equalsIgnoreCase("fists"))
				health_lost += (int)(Math.random() * (50 - 40 + 1) + 40);
			else if (weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket"))
				health_lost += (int)(Math.random() * (40 - 35 + 1) + 35);
			else if (weapon.equalsIgnoreCase("metal pipe") || weapon.equalsIgnoreCase("baseball bat"))
				health_lost += (int)(Math.random() * (25 - 20 + 1) + 20);
		}

		// hound outcomes
		else if (current_entity.equalsIgnoreCase("HOUND")) {
			if (weapon.equalsIgnoreCase("fists"))
				health_lost += (int)(Math.random() * (50 - 45 + 1) + 45);
			else if (weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket"))
				health_lost += (int)(Math.random() * (30 - 25 + 1) + 25);
			else if (weapon.equalsIgnoreCase("metal pipe") || weapon.equalsIgnoreCase("baseball bat"))
				health_lost += (int)(Math.random() * (15 - 10 + 1) + 10);
		}

		else if (current_entity.equalsIgnoreCase("DEATHMOTH")) {
			if (weapon.equalsIgnoreCase("fists"))
				health_lost += (int)(Math.random() * (60 - 55 + 1) + 55);
			else if (weapon.equalsIgnoreCase("chair leg") || weapon.equalsIgnoreCase("tennis racket"))
				health_lost += (int)(Math.random() * (35 - 30 + 1) + 30);
			else if (weapon.equalsIgnoreCase("metal pipe") || weapon.equalsIgnoreCase("baseball bat"))
				health_lost += (int)(Math.random() * (15 - 10 + 1) + 10);
		}

		System.out.println("\nHEALTH LOST: -" + health_lost + "%");

		health -= health_lost;

		if (playerIsDead(health)) {
			System.out.println("\nYou did not survive.\n");
			return health;
		}
		else {
			if (health >= 90)
				System.out.println("\nYou successfully dispatched the " + current_entity + "." +
					"\nYou may now proceed\n");
			else if (health >= 60)
				System.out.println("\nYou were able to fend off the " + current_entity + "." +
					"\nProceed with caution\n");
			else if (health >= 30)
				System.out.println("\nYou fought the " + current_entity + "." +
					"\nAlthough there was an struggle, at least you're still in one piece\n");
			else if (health >= 15)
				System.out.println("\nYou won, but you can't keep this up for much longer\n");
			else if (health > 0) 
				System.out.println("\nYou underestimated it");
		}
		return health;	
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
				"\nAfterwards, you ran as far as you could from the beast.");

		return health;
	}
}
