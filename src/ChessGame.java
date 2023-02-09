
public class ChessGame {

	/* A class implementing the game of chess itself.
	 * Takes moves from each player and runs the game.
	 * */
	
	
	//variables
	ChessEngine e;
	
	//something to represent the chess board
	public char[][] board;
	public String[] locations; //list of piece locations, set by original chess mapping,
	/*
	 * If anyone has a better mapping system, open to suggestions
	 * [0]: rook -white
	 * [1]: knight -white
	 * [2]  bishop
	 * [3] ...
	 * 
	 * [7] other white rook
	 * [8]-[15] white pawns
	 * [16]-[23] black pawns
	 * [24] black rook
	 * ...
	 * [31] other black rook
	 * 
	 */
	
	
 	
	//game move log.
	private String[] log;
	
	
	public ChessGame() {
		board = new char[8][8];
		locations = new String[32];
		
		//initialize board
		board[0][0] = 'R';
		board[0][1] = 'N';
		board[0][2] = 'B';
		board[0][3] = 'K';
		board[0][4] = 'Q';
		board[0][5] = 'B';
		board[0][6] = 'N';
		board[0][7] = 'R';
		
		
		
		
		//initialize locations
		
		
		
	}
	
	public int move(String code) {
		//if not valid return 1
		//if illegal move return 2
		//if check return 3=
		//if checkmate return 4
		
		return 0;
		
	}
	
	public boolean isCheckmate(String move) { //determines if the game is checkmate after this move is completed
		return false;
	}
	
	public boolean isIllegal(String move) { //determines if this is an illegal move (King neglect)
		return false;
	}
	
	public boolean isValid(String s) { //determines if string is in proper format
		return true;
	}
	
	public boolean isPossible(String move) { //determines if move is possible, whether the appropriate piece exists and whether it has
		//the capability to move to the new location
		return true;
	}
	
}
