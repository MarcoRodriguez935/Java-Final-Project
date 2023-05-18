import java.util.Scanner;
public class trivia{
	public static void main(String[] args){
		trivia1();
		trivia2();
		trivia3();
	}
	public static void triviaCS(){
		Scanner inp = new Scanner(System.in);
		String trivia_q1 = "The moment you step into this room, all of the doors close quickly. Looking around this room \n"+ 
						   "you notice something distinct. Written on the walls is what seems to be a question and a pencil \n"+
						   "on the floor below it. \n\n"+
						   "On the wall writes: \n\n"+ 
						   "\"If you have a 3 dimensional array and would want to print all data in the arrays, how many \n"+
						   "loops are required to do this?\"\n\n"+
						   "You pick up the pencil and make the assumption that to leave this room you have to answer this \n"+
						   "riddle by writing it on the wall.";
		

		int attempts = 3;
		System.out.println(trivia_q1);
		while(attempts > 0 ){
			System.out.print(">>>  ");
			String ans = inp.nextLine();
				if(!ans.equalsIgnoreCase("3")){
					if(attempts == 3){
					System.out.println("The walls shake when you answer and none of the doors "+
								 	 "open, meaning that answer was definitely wrong.");
					attempts--;
					}
					else if(attempts == 2){
						System.out.println("Cracks in the walls now start show as the room shakes more violently "+
										 " from your wrong answer.");
						attempts--;
					}
						
					else if(attempts == 1){
						System.out.println("The walls don't shake anymore, however none of the doors open. The "+
										   "lights begin to slowly fade into darkness. After a few moments the"+ 
										   "door behind you opens back into the room you came from.");
					attempts--;
					}
				}
				else{
					System.out.println("For a few moments, nothing happens. Shortly after all the doors to the "+
									 "room begin to open, allowing you to pass through.\n");
				}
		}
		
	}
	public static void triviaCalc(){
		Scanner inp = new Scanner(System.in);
		String trivia_q2 = "The moment you step into this room, all of the doors close quickly. Looking around this room \n"+ 
						   "you notice something distinct. Written on the walls is what seems to be a question and a pencil \n"+
						   "on the floor below it. \n\n"+
						   "On the wall writes: \n\n"+ 
						   "\"Given the position equation (5t^3)+9t, what is the acceleration equation?\"\n\n"+
						   "You pick up the pencil and make the assumption that to leave this room you have to answer this \n"+
						   "riddle by writing it on the wall.";
		

		int attempts = 3;
		System.out.println(trivia_q2);
		while(attempts > 0 ){
			System.out.print(">>>  ");
			String ans = inp.nextLine();
				if(!ans.equalsIgnoreCase("30t")){
					if(attempts == 3){
					System.out.println("The walls shake when you answer and none of the doors "+
								 	 "open, meaning that answer was definitely wrong.");
					attempts--;
					}
					else if(attempts == 2){
						System.out.println("Cracks in the walls now start show as the room shakes more violently "+
										 " from your wrong answer.");
						attempts--;
					}
					else if(attempts == 1){
						System.out.println("The walls don't shake anymore, however none of the doors open. The "+
										   "lights begin to slowly fade into darkness, and the door behind you "+
										   "opens back into the room you came from.");
					attempts--;
					}
				}
				else{
					System.out.println("For a few moments, nothing happens. Shortly after all the doors to the "+
									 "room begin to open, allowing you to pass through.");
				}
		}
	} 
	public static void triviaPhys(){
		Scanner inp = new Scanner(System.in);
		String trivia_q3 = "The moment you step into this room, all of the doors close quickly. Looking around this room \n"+ 
						   "you notice something distinct. Written on the walls is what seems to be a question and a pencil \n"+
						   "on the floor below it. \n\n"+
						   "On the wall writes: \n\n"+ 
						   "\"A metal rod with a radius of 0.4 metrs spins along a rotational axis. The axis goes through the \n"+
						   "rod's center of mass, creating a 90 degree angle with the rod. A force is applied to the rod at \n"+
						   "one of its ends parallel to the rod. How much torque is applied to the rod?\"\n\n"+
						   "You pick up the pencil and make the assumption that to leave this room you have to answer this \n"+
						   "riddle by writing it on the wall.";
		

		int attempts = 3;
		System.out.println(trivia_q3);
		while(attempts > 0 ){
			System.out.print(">>>  ");
			String ans = inp.nextLine();
			System.out.println();
				if(!ans.equalsIgnoreCase("0") ){
					if(attempts == 3){
					System.out.println("The walls shake when you answer and none of the doors "+
								 	 "open, meaning that answer was definitely wrong.");
					attempts--;
					}
					else if(attempts == 2){
						System.out.println("Cracks in the walls now start show as the room shakes more violently "+
										 " from your wrong answer.");
						attempts--;
					}
					else if(attempts == 1){
						System.out.println("The walls don't shake anymore, however none of the doors open. The "+
										   "lights begin to slowly fade into darkness, and the door behind you "+
										   "opens back into the room you came from.");
					attempts--;
					}
				}
				else{
					System.out.println("For a few moments, nothing happens. Shortly after all the doors to the "+
									 "room begin to open, allowing you to pass through.");
					System.exit(1);
				}
		}
	}
}





//---ANSWERS ARE RIGHT HERE-----
// CS QUESTION = 3
// CALC QUESTION = 30t
// PHYS QUESTION = 0