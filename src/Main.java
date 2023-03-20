import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	
		System.out.println("Starting new game of Chess. Moves are taken as starting coordinate to ending coordinate.\n For example,"
				+"in the game beginning, a2a4 would be a pawn moving two squares foward. "
				+ "\nWhite peices start on 1-2 and Black starts on 7-8");
		
		ChessGame game = new ChessGame();
		Scanner scan = new Scanner(System.in);
		String line; //for scanner input
		Move move;
		boolean white = true; //who's turn it is
		
		//main game loop
		while (!game.gameover) {
			System.out.println("Enter " + (white? "white": "black")+ " move or enter \"board\" to view the game board:");
			line = scan.nextLine();
			
			//if request to show board
			if (line.equals("board")){
				System.out.println(game.boardToString());
			}
			
			else {
				//process move
				try {
					move = new Move(line);
					
					switch(game.move(move)) {
					case 0: System.out.println("Move executed!");
					case 1: {
						System.out.println("Move not valid, try again");
					}
					case 2: {
						System.out.println("Move Illegal, try again");
					}
					case 3:
						System.out.println("Check!");
					case 4:
						System.out.println("Checkmate!");
					}
					
				} catch (IllegalArgumentException e) {
					System.out.println("Move is not in proper format (ex: a1h8) please try again.");
				}
				
			}
		
		}

	}
	
}
