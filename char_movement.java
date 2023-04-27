import java.util.Scanner;
public class charMovement{
	public static void main(String[] args){
		System.out.println("--------------------");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t||\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("--------------------\n");
		horizontal();
	}
	public static void horizontal(){
		Scanner inp = new Scanner(System.in);
		
		String test_string = "IDK go somehwere>> ";
		System.out.print(test_string);
		String dir = inp.nextLine();

		String r = "right";
		String l = "left";

		if(dir.equals(r)){
		System.out.println("--------------------");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t   ||\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("--------------------");
		}
		else if(dir.equals(l)){
			System.out.println("--------------------");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|     ||  \t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("|\t\t  |");
		System.out.println("--------------------");
		}
		
	}
}