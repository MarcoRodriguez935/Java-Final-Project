import java.util.Scanner;

public class GamePuzzles {
	public static void main(String[] args) {
		anagramPuzzle();
		System.out.println("Out of puzzle1");
	}

	public static void anagramPuzzle() {
		Scanner input = new Scanner(System.in);

		boolean puzzle1 = true;

		String ans = "";

		System.out.println("You are currently in the Scrambled Puzzle Room");
		System.out.println("You cannot leave until you successfully unscramble these words");
		System.out.println();

		while (puzzle1) {
			System.out.print("Unscramble this word: ");
			System.out.println("OLS GSELEAN");

			System.out.print("> ");
			ans = input.nextLine();
			ans = ans.trim();

			while (!ans.equalsIgnoreCase("los angeles")) {
				System.out.print("> ");
				ans = input.nextLine();
				ans = ans.trim();
			}
			System.out.println("\nYou are correct");

			System.out.print("Unscramble this word: ");
			System.out.println("UMPOETRC ESECCNI");

			System.out.print("> ");
			ans = input.nextLine();
			ans = ans.trim();

			while (!ans.equalsIgnoreCase("computer science")) {
				System.out.print("> ");
				ans = input.nextLine();
				ans = ans.trim();
			}
			System.out.println("\nYou are correct");

			System.out.print("Unscramble this word: ");
			System.out.println("YBBAOEOAB");

			System.out.print("> ");
			ans = input.nextLine();
			ans = ans.trim();

			while (!ans.equalsIgnoreCase("bababooey")) {
				System.out.print("> ");
				ans = input.nextLine();
				ans = ans.trim();
			}
			System.out.println("\nYou are correct");

			puzzle1 = false;
		}
	}
}