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
		
		//main game loop
		while (!game.gameover) {
			System.out.println("Enter " + (game.white? "white": "black")+ " move or enter \"board\" to \nview the game board or \"log\" for game log:");
			line = scan.nextLine();
			
			//if request to show board
			if (line.equals("board")){
				System.out.println(game.boardToString());
			}
			else if (line.equals("log")) {
				System.out.println("printing log: ");
				for (String s: game.getLog()) {
					System.out.println(s);
				}
			}
			
			else {
				//process move
				try {
				move = new Move(line);
					
					switch(game.move(move)) {
						case 0: { 
							System.out.println("Move executed!");
							break;
						}
						case 1: {
							System.out.println("Move is not possible, try again");
							break;
						}
						case 2: {
							System.out.println("Move Illegal, try again");
							break;
						}
						case 3: {
							System.out.println("Check!");
							break;
						}
						case 4: {
							System.out.println("Checkmate!");
							break;
						}
						case 5: {
							System.out.println("This is not one of your pieces.");
							break;
						}
					}
					
					
				} catch (IllegalArgumentException e) {
					System.out.println("Move is not in proper format (ex: a1h8) please try again.");
				}
				
			}
		
		}
		
		//print final game log
		System.out.println("printing log: ");
		for (String s: game.getLog()) {
			System.out.println(s);
		}

	}
	
}
