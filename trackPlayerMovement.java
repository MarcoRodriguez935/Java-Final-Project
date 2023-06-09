import java.util.Scanner;

public class trackPlayerMovement{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[][] world = 
		{{"A1", "B1", "C1", "D1", "E1"}, 
		 {"A2", "B2", "C2", "D2", "E2"}, 
		 {"A3", "B3", "C3", "D3", "E3"}, 
		 {"A4", "B4", "C4", "D4", "E4"}, 
		 {"A5", "B5", "C5", "D5", "E5"}};


		while(true){
		 System.out.print("Do you want to move? ");
		 String confirmation = sc.nextLine();

		 switch(confirmation){
		 	case "Yes":
		 		String position = playerMovement(world);
		 		System.out.println("You are now in " + position);
 			default:
 				System.out.println("The program will now exit");
 				System.exit(0);
		 }		 
		}
	}
	public static String playerMovement(String[][] world){
		Scanner sc = new Scanner(System.in);
		int posx = 0;
		int posy = 0;
		String playerposition = world[posx][posy];
		System.out.print("You are currently in " + playerposition  + "\nWhere would you like to go? (N/E/S/W): ");
		String movement = sc.next();

		switch(movement){
			case "N":
				try{
					playerposition = world[posx + 1][posy];
				break;
				} catch(ArrayIndexOutOfBoundsException ex){
				
				System.out.println("Out of Bounds");
				System.exit(0);
				}
				
			case "E":
				try{
					playerposition = world[posx][posy + 1];
				break;
			} catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("Out of Bounds");
				System.exit(0);
			}
			case "S":
				try{
					playerposition = world[posx - 1][posy];
				break;
			} catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("Out of Bounds");
				System.exit(0);
			}
			case "W":
				try{
					playerposition = world[posx][posy - 1];
				break;
			} catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("Out of Bounds");
				System.exit(0);
			}
			default: 
				System.out.print("try again");
				movement = sc.next();
		}
		return playerposition;

	}
}