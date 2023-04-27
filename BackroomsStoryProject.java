import java.util.Scanner;

public class BackroomsStoryProject {
	public static void main(String[] args) {
		introMessage();
		displayTitle();

	}
	
	public static void displayTitle() {
		System.out.println();

		System.out.println("▄▄▄█████▓██░ ██▓█████     ▄▄▄▄   ▄▄▄      ▄████▄  ██ ▄█▀██▀███  ▒█████  ▒█████  ███▄ ▄███▓ ██████    ");
		System.out.println("▓  ██▒ ▓▓██░ ██▓█   ▀    ▓█████▄▒████▄   ▒██▀ ▀█  ██▄█▒▓██ ▒ ██▒██▒  ██▒██▒  ██▓██▒▀█▀ ██▒██    ▒    ");
		System.out.println("▒ ▓██░ ▒▒██▀▀██▒███      ▒██▒ ▄█▒██  ▀█▄ ▒▓█    ▄▓███▄░▓██ ░▄█ ▒██░  ██▒██░  ██▓██    ▓██░ ▓██▄      ");
		System.out.println("░ ▓██▓ ░░▓█ ░██▒▓█  ▄    ▒██░█▀ ░██▄▄▄▄██▒▓▓▄ ▄██▓██ █▄▒██▀▀█▄ ▒██   ██▒██   ██▒██    ▒██  ▒   ██▒   ");
		System.out.println("  ▒██▒ ░░▓█▒░██░▒████▒   ░▓█  ▀█▓▓█   ▓██▒ ▓███▀ ▒██▒ █░██▓ ▒██░ ████▓▒░ ████▓▒▒██▒   ░██▒██████▒▒   ");
		System.out.println("  ▒ ░░   ▒ ░░▒░░░ ▒░ ░   ░▒▓███▀▒▒▒   ▓▒█░ ░▒ ▒  ▒ ▒▒ ▓░ ▒▓ ░▒▓░ ▒░▒░▒░░ ▒░▒░▒░░ ▒░   ░  ▒ ▒▓▒ ▒ ░   ");
		System.out.println("    ░    ▒ ░▒░ ░░ ░  ░   ▒░▒   ░  ▒   ▒▒ ░ ░  ▒  ░ ░▒ ▒░ ░▒ ░ ▒░ ░ ▒ ▒░  ░ ▒ ▒░░  ░      ░ ░▒  ░ ░   ");
		System.out.println("  ░      ░  ░░ ░  ░       ░    ░  ░   ▒  ░       ░ ░░ ░  ░░   ░░ ░ ░ ▒ ░ ░ ░ ▒ ░      ░  ░  ░  ░     ");
		System.out.println("         ░  ░  ░  ░  ░    ░           ░  ░ ░     ░  ░     ░        ░ ░     ░ ░        ░        ░     ");
		System.out.println("                               ░         ░                                                           ");

		System.out.println();
	}

	public static void introMessage () {
		Scanner input = new Scanner (System.in);

		System.out.print("Enter your name: ");
		String name = input.nextLine();
		name = name.trim();

		System.out.println();
		System.out.println("Hello " + name);
		System.out.println("You were having a normal day when you tripped and miraculously noclipped through " +
			"the ground in broad daylight.");
		System.out.println("You are now in an unknown place.\nYou see nothing ahead but an endless number " +
			"of seemingly randomly generated rooms.\nThis place does not seem real, yet you stand here in disbelief.");
		System.out.println("Are you alone? Perhaps stuck here for eternity? Only time can tell.");
		System.out.println("Still, there's no guarantee time passes normally here.");
		System.out.println("Welcome to.......");
		System.out.println();

	}
}
