import java.util.regex.*;

public class ChessGame {

	/* A class implementing the game of chess itself.
	 * Takes moves from each player and runs the game.
	 * */
	
	
	//variables
	
	//something to represent the chess board
	private char[][] board;
	private String[] locations; //list of piece locations, set by original chess mapping,
	boolean gameover;
	/*
	 * If anyone has a better mapping system, open to suggestions
	 * Capital letters are white, lowercase is black
	 * 
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
		board = new char[8][8]; // [A to H], [0 to 8] 
		locations = new String[32];
		gameover = false;
		
		//initialize board
		board[0][0] = 'R';
		board[0][1] = 'N';
		board[0][2] = 'B';
		board[0][3] = 'Q';
		board[0][4] = 'K';
		board[0][5] = 'B';
		board[0][6] = 'N';
		board[0][7] = 'R';
		
		board[1][0] = 'P';
		board[1][1] = 'P';
		board[1][2] = 'P';
		board[1][3] = 'P';
		board[1][4] = 'P';
		board[1][5] = 'P';
		board[1][6] = 'P';
		board[1][7] = 'P';
		
		for (int i=2; i<6; i++) {
			for (int j=0; j<8; j++) {
				board[i][j] = '-';
			}
		}
		
		board[6][0] = 'p';
		board[6][1] = 'p';
		board[6][2] = 'p';
		board[6][3] = 'p';
		board[6][4] = 'p';
		board[6][5] = 'p';
		board[6][6] = 'p';
		board[6][7] = 'p';
		
		board[7][0] = 'r';
		board[7][1] = 'n';
		board[7][2] = 'b';
		board[7][3] = 'q';
		board[7][4] = 'k';
		board[7][5] = 'b';
		board[7][6] = 'n';
		board[7][7] = 'r';
		
		
		
		//initialize locations
		
		
		
	}
	
	public int move(Move code ) { //numerical code where first two numbers specify the 2d array position of the piece
		//to be moved and the second two digits specify destination
		int res;
		//if not valid return 1
		if (!isValid(int r1, int c1, int r2, int c2)) return 1;
		//if illegal move return 2
		if (isIllegal(int r1, int c1, int r2, int c2)) return 2;
		//if check return 3=
		if (isCheck(code)) res =  3;
		//if checkmate return 4
		if (isCheckmate(code)) res= 4;
		// if impossible return 5
		if (!isPossible(code)) res = 5;
		//else return 0
		res = 0;
		
		//move piece and destroy any piece already on that spot.
		board[]
		return res;
		
	}
	
	//move processing methods
	
	public boolean isCheckmate(Move move) { //determines if the game is checkmate after this move is completed
		return false;
	}
	
	public boolean isIllegal(Move move) { //determines if this is an illegal move (King neglect)
		return false;
	}
	
	public boolean isValid(Move s) { //determines if string is in proper format
		
		return true;
	}
	
	public boolean isPossible(String move) { //determines if move is possible, whether the appropriate piece exists and whether it has
		//the capability to move to the new location
		return true;
	}
	
	public boolean isCheck(String move) {
		return false;
	}
	
	public int[] getPosition(char piece) { //returns the array position for a piece
		int[] position = new int[2]; //array with two spots two hold row and column
		
		switch(piece){
		case 'r':
			position = [][]
		}
	}
	
	public String[] getStringPosition(int[] position) { //maps numerical position to string position code for output
		switch(int[] 0)
	}

	
	
	//other
	public char[][] getBoard(){
		return board;
	}
	
	public String[] getLog() {
		return log;
	}
	
	public String[] getLocations() {
		return locations;
	}
	
	public String boardToString(){//returns user friendly visual string for the board to be printed
		StringBuilder res = new StringBuilder();
		for(int i =7; i>=0; i--) {
			res.append("\n"+i+" ");
			for (char c: board[i]) {
				res.append(c);
				res.append(' ');
			}
		}
		res.append("\n  A B C D E F G H");
		return res.toString();
	}
	
}
