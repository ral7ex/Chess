import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Starting new game of Chess");
		ChessGame game = new ChessGame();
		boolean gameover = false;
		Scanner scan = new Scanner(System.in);
		String move;
		
		//main game loop
		while (!gameover) {
			System.out.println("Enter White move:");
			move = scan.nextLine();
			game.move(move);
			System.out.println("Enter White move:");
			move = scan.nextLine();
			game.move(move);
			
		}
		
		

	}

}
