import java.util.Scanner;

public class Main {

	
	static ChessGame game;
	static Scanner scan;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting new game of Chess. Moves are taken as starting coordinate to ending coordinate.\n For example,"
				+"in the game beginning, a2a4 would be a pawn moving two squares foward. "
				+ "\nWhite peices start on 1-2 and Black starts on 7-8");
		game = new ChessGame();
		Scanner scan = new Scanner(System.in);
		String move;
		boolean white = true; //who's turn it is
		
		//main game loop
		while (!game.gameover) {
			System.out.println("Enter " + (white? "white": "black")+ " move or enter \"board\" to view the game board:");
			move = scan.nextLine();
			if (move.equals("board")){
				System.out.println(game.boardToString());
			}
		
		}

	}
	
	private void processMoveCode(int code) {
		switch(code) {
			case 0: return;
			case 1: {
				System.out.println("Move not valid, try again");
				tryAnotherMove();
			}
			case 2: {
				System.out.println("Move Illegal, try again");
				tryAnotherMove();
			}
			case 3:
				System.out.println("Check!");
			case 4:
				System.out.println("Checkmate!");
			
		}
	}
	
	private void tryAnotherMove() {
		String move = scan.nextLine();
		code = game.move(move);
		processMoveCode(code);
	}

}
