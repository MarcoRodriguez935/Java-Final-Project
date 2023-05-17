import java.util.Scanner;
import java.util.Random;

public class Game{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		

		//create world
		String[][][] world = fillWorld();


		//playerMenu
		System.out.print("What do you want to do?: (move, search)");
		String choice = sc.nextLine();

		boolean moveMenu = false;
		boolean searchMenu = false;

		switch(choice){
		//case "move":
			//moveMenu = true;
			//moveMenu = moveMenu(moveMenu);
		case "search":
			searchMenu = true;
			searchMenu = searchMenu(world, searchMenu);
			break;
		}


	}
	public static boolean searchMenu(String[][][] world, boolean display){
		Scanner sc = new Scanner(System.in);
		int layer = 0;
		while(display){
			System.out.print("What do you want to search for?: ");
			String choice = sc.nextLine();

			switch(choice){
			case "coords":
				layer = 0;
				break;
			case "areas":
				layer = 1;
				break;
			case "rooms":
				layer = 2;
				break;
			case "descriptions":
				layer = 3;
				break;
			case "items":
				layer = 4;
				break;
			case "exit":
				display = false;
				return display;
			}
			System.out.println();
			int counter = 1;
			for(int i = 0; i < world[layer].length; i++){
				for(int j = 0; j < world[layer][i].length; j++){
					if(counter % 5 != 0){
						System.out.print(world[layer][i][j] + " ");
						counter++;
					}
					else{
						System.out.println(world[layer][i][j]);
						counter++;
					}
				}
			}
			System.out.println();
		}
		return display;
	}
	public static String[][][] fillWorld(){
		Random rn = new Random();
		String[][][] world = new String[5][5][5];

		//fill world with coords, area, room type, descriptions, items
		int settleCount = 0;
		int puzzleCount = 0;
		for(int posx = 0; posx < world[0].length; posx++){
			for(int posy = 0; posy < world[0][posx].length; posy++){
				
				//coords
				world[0][posx][posy] = (((char)('A' + posy) + "") + ((posx + 1) + ""));
				
				//area
				if(posx < 3 && posy < 3){
					world[1][posx][posy] = "Y" + " ";
				}
				else if(posx < 3 && posy > 2){
					world[1][posx][posy] = "A" + " ";
				}
				else if(posx > 2 && posy < 3){
					world[1][posx][posy] = "P" + " ";
				}
				else{
					world[1][posx][posy] = "U" + " ";
				}

				//room type - puzzle, settlement, normal 
				int roomType = rn.nextInt(3);

				if(posx == 0 && posy == 0){
					roomType = 0;
				}
				else if(posx == 4 && posy == 4){
					roomType = 0;
				}
				
					if(roomType == 2 && settleCount == 2){
						roomType = rn.nextInt(2);
					}
					if(roomType == 1 && puzzleCount == 4){
							roomType = 0;
					}
				
				switch(roomType){
					case 0:
						world[2][posx][posy] = "Normal";
						break;
					case 1:
						world[2][posx][posy] = "Puzzle";
						puzzleCount++;
						break;
					case 2:
						world[2][posx][posy] = "Settle";
						settleCount++;
						break;
				}

				
				//roomDescriptions
				//world[3][posx][posy] = 


				world[4][posx][posy] = itemChance(world, posx, posy);


	
				}
			}
			return world;
		}
		public static String itemChance(String[][][] world, int posx, int posy){
		Random rn = new Random();
		int itemCount = 0;
		int weaponCount = 0;
		int puzzleItemCount = 0;	
		

		int itemChance = rn.nextInt(6);
		if(itemCount == 11){ //keep track of numofitems
			return "empty";
		}
		else{
			if(itemChance == 2 || itemChance == 5 ){ //3 in 8 chance for item
				int itemType = rn.nextInt(3); //find item type (0 is food, 1 is weapon, 2 is puzzle)

				while(itemType == 1 && weaponCount == 4){
					itemType = rn.nextInt(3);
				}
				while(itemType == 2 && puzzleItemCount == 3){
					itemType = rn.nextInt(3);
				}

				if(itemType == 0){
					int food = rn.nextInt(4);
					switch(food){
					case 0:
						return "almondWtr";
					case 1:
						return "bkShrms";
					case 2: 
						return "bandage";
					case 3:
						return "healthPk";
					}
					itemCount++;
				}
				if(itemType == 1){
					int weapon = rn.nextInt(4);
					switch(weapon){
					case 0:
						return "metalPi";
					case 1:
						return "baseBaBt";
					case 2:
						return "tennisRkt";
					case 3: 
						return "chairLg";
					}
					weaponCount++;
					itemCount++;
				}
				if(itemType == 2){
					int puzzle = rn.nextInt(3);
					switch(puzzle){
					case 0:
						return "Chung";
					case 1:
						return "Korb";
					case 2:
						return "mongUs";
					}
					puzzleItemCount++;
					itemCount++;
				}
			}
		}
		return "empty";
	}

}