import java.util.Scanner;
public class blackjack{
	public static void main(String[] args){
		Scanner inp = new Scanner(System.in);

		String s = "";
		boolean hit = hit(s);
		int p_card = 0;
		do{
			System.out.println("House \"Would you like to hit? (Y or N)\"");
			s = inp.next();
			cardGive(p_card);
		} while(hit == true ^ p_card < 22);

		int c_card = 0;
		do{
			cardGive(c_card);
		} while(hit == true ^ c_card < 22);
		System.out.print(hit);
	}

	public static void cardGive(int current_card){
		int rank_min = 1;
		int rank_max = 13;
		int rank = (int)(Math.random()*(rank_max-rank_min+1)+rank_min);
			switch (rank){
				case 2:
					current_card += 2;
					break;
				case 3:
					current_card += 3;
					break;
				case 4:
					current_card += 4;
					break;
				case 5:
					current_card += 5;
					break;
				case 6:
					current_card += 6;
					break;
				case 7:
					current_card += 7;
					break;
				case 8:
					current_card += 8;
					break;
				case 9:
					current_card += 9;
					break;
				case 10:
					current_card += 10;
					break;
				case 11:
					current_card += 10;
					break;
				case 12:
					current_card += 10;
					break;
				case 13:
					current_card += 10;
					break;
				}
	}
	public static boolean hit(String s){
		if(s.equalsIgnoreCase("y")){
			return true;
		}
		else if(s.equalsIgnoreCase("n")){
			return false;
		}
	}
}
