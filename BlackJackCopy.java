import java.util.Scanner;
import java.util.Random;

public class BlackJackCopy {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println(" Welcome to Black Jack");
		System.out.println("!----------------------!");
		System.out.println("\n");

		String[] cardsArray = {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."};
		String[] nmeCardsArray = {".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", ".", "."};

		System.out.println("Enemy Cards: ");
		for (int n = 0; n < 2; n++) {
			nmeCardsArray[n] = cardPile();
			System.out.println(nmeCardsArray[n] + " ");
		}

		System.out.println(" ");
		System.out.println("Enemy Card Count: " + cardCount(nmeCardsArray));

		System.out.println(" ");
		System.out.println("Player Cards: ");
		for (int i = 0; i < 2; i++) {
			cardsArray[i] = cardPile();
			System.out.println(cardsArray[i] + " ");
		}

		int cardInArray = 2;
		int playerCardCount = cardCount(cardsArray);

		do {
			System.out.println(" ");
			System.out.println("Player Card Count: " + playerCardCount);
			System.out.println(" ");

			System.out.println("> Hit\n" +
							   "> Stand");

			String playerIn = input.next();
			if (playerIn.equalsIgnoreCase("stand")) {
				break;
			}

			for (int a = 0; a <= cardInArray; a++) {
				System.out.println(playerHit(cardsArray, playerIn, cardInArray)[a] + " ");
			}
			cardInArray++;
		} while (cardInArray <= 12);

		check21(playerCardCount);

	}

	public static String[] playerHit(String[] cardsArray, String playerIn, int cardInArray) {

		if (playerIn.equalsIgnoreCase("hit")) {
			for (int i = 0; i <= cardInArray; i++) {
				if (cardsArray[i].contains(".")) {
					cardsArray[i] = cardPile();
				}
			}
		}

		return cardsArray;

	}

	public static void check21(int playerCardCount) {

		if (playerCardCount < 21) {
			System.out.println("Your card count is at" + playerCardCount + "!\n" + 
							   "You are under 21;");
		}
		else if (playerCardCount > 21) {
			System.out.println("You are over 21\n" +
							   "You lose!");
		}
		else if (playerCardCount == 21) {
			System.out.println("21!");
		}

	}

	public static String cardPile() {

		Random randCard = new Random();
		String result = "";

		int card = randCard.nextInt(52 - 1) + 1;

		String[] deckOfCards = {"Ace of Diamonds", "Ace of Hearts", "Ace of Spades", "Ace of Clubs",
								"2 of Diamonds", "2 of Hearts", "2 of Spades", "2 of Clubs",
								"3 of Diamonds", "3 of Hearts", "3 of Spades", "3 of Clubs",
								"4 of Diamonds", "4 of Hearts", "4 of Spades", "4 of Clubs",
								"5 of Diamonds", "5 of Hearts", "5 of Spades", "5 of Clubs",
								"6 of Diamonds", "6 of Hearts", "6 of Spades", "6 of Clubs",
								"7 of Diamonds", "7 of Hearts", "7 of Spades", "7 of Clubs",
								"8 of Diamonds", "8 of Hearts", "8 of Spades", "8 of Clubs",
								"9 of Diamonds", "9 of Hearts", "9 of Spades", "9 of Clubs",
								"10 of Diamonds", "10 of Hearts", "10 of Spades", "10 of Clubs",
								"Jack of Diamonds", "Jack of Hearts", "Jack of Spades", "Jack of Clubs",
								"Queen of Diamonds", "Queen of Hearts", "Queen of Spades", "Queen of Clubs",
								"King of Diamonds", "King of Hearts", "King of Spades", "King of Clubs"};

		result += deckOfCards[card];

		return result;

	}

	public static int cardCount(String[] cardsArray) {

		int count = 0;

		for (int i = 0; i < cardsArray.length; i++) {
			if (cardsArray[i].contains("Ace")) {
				count += 1;
			}
			else if (cardsArray[i].contains("2")) {
				count += 2;
			}
			else if (cardsArray[i].contains("3")) {
				count += 3;
			}
			else if (cardsArray[i].contains("4")) {
				count += 4;
			}
			else if (cardsArray[i].contains("5")) {
				count += 5;
			}
			else if (cardsArray[i].contains("6")) {
				count += 6;
			}
			else if (cardsArray[i].contains("7")) {
				count += 7;
			}
			else if (cardsArray[i].contains("8")) {
				count += 8;
			}
			else if (cardsArray[i].contains("9")) {
				count += 9;
			}
			else if (cardsArray[i].contains("10")) {
				count += 10;
			}
			else if (cardsArray[i].contains("Jack")) {
				count += 10;
			}
			else if (cardsArray[i].contains("Queen")) {
				count += 10;
			}
			else if (cardsArray[i].contains("King")) {
				count += 10;
			}
			else if (cardsArray[i].contains(".")) {
				count += 0;
			}

		}

		return count;

	}



}



