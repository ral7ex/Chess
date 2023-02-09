import java.util.Scanner;

public class Main {

	
	static ChessGame game;
	static Scanner scan;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Starting new game of Chess");
		game = new ChessGame();
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
	
	private void processMoveCode(int code) {
		switch(code) {
			case 0: return;
			case 1: {
				System.out.println("Move not valid, try again");
				String move = scan.nextLine();
				code = game.move(move);
				processMoveCode(code);
			}
		}
	}

}
