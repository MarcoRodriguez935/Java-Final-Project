import java.util.Scanner;

public class BackroomsStoryProject {
  public static void main(String[] args) {
    introMessage();

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

  public static void introMessage() {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter your name: ");
    String name = input.nextLine();
    name = name.trim();

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

    System.out.print("Enter any key to begin: ");
    char key = input.next().charAt(0);

    System.out.println();

    int health = 100;

    int num_of_levels_passed = 0;

    int entities_encountered = 0;

    // Placeholder for inventory
    String[] inventory = {"FISTS", "empty", "empty", "empty", "empty", "empty"};

    firstLevel(name, health, inventory, num_of_levels_passed);

  }

  public static void firstLevel(String name, int health, String[] inventory, 
		int num_of_levels_passed) {
  	System.out.println("LEVEL 1\n");

  	currentStats(name, health, inventory);

  	String current_level = "Level1";
  	num_of_levels_passed++;


  }

  public static void final_level(String name, int health, String[] inventory) {
  	return;
  }

  public static String getRandomRoom(String current_level) {

    String[] levels = { "Level2", "Level3", "Level4", "Level5", "Level6",
        "Level7", "Level8", "Level9" };

    int random_level = (int)(Math.random() * (7+1));

   	String next_level = levels[random_level];

    return next_level;
  }

  public static void currentStats(String player_name, int health, String[] inventory) {

  	System.out.println("----------" + player_name + "----------");
  	System.out.println("\nHealth: " + health + "%");
  	System.out.println("\nInventory: ");

  	for (int i = 0; i < inventory.length; i++) {
  		System.out.println("\t" + (i+1) + ") " + inventory[i]);
  	}

  	System.out.println();
  }

  public static boolean playerIsDead(int health) {
  	if (health <= 0) 
  		return true;
  	else 
  		return false;
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
  	System.out.println("██████╗ ██╗      █████╗ ██╗   ██╗███████╗██████╗     ██╗    ██╗██╗███╗   ██╗███████╗");
  	System.out.println("██╔══██╗██║     ██╔══██╗╚██╗ ██╔╝██╔════╝██╔══██╗    ██║    ██║██║████╗  ██║██╔════╝");
  	System.out.println("██████╔╝██║     ███████║ ╚████╔╝ █████╗  ██████╔╝    ██║ █╗ ██║██║██╔██╗ ██║███████╗");
  	System.out.println("██╔═══╝ ██║     ██╔══██║  ╚██╔╝  ██╔══╝  ██╔══██╗    ██║███╗██║██║██║╚██╗██║╚════██║");
  	System.out.println("██║     ███████╗██║  ██║   ██║   ███████╗██║  ██║    ╚███╔███╔╝██║██║ ╚████║███████║");
  	System.out.println("╚═╝     ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝     ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚══════╝");
  	System.out.println("                                                                                    ");
  }
 
}
