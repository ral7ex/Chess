import java.util.ArrayList;
import java.util.regex.*;

public class ChessGame {

	/* A class implementing the game of chess itself.
	 * Takes moves from each player and runs the game.
	 * most fields are not private
	 * */
	
	
	//variables
	
	//something to represent the chess board
	public char[][] board; //TODO make private after testing
	boolean gameover;
	boolean white; //who's turn
	
	//locations of pieces
	String[] R; //white rooks
	String[] N; //white knights
	String[] B; //...
	String[] K;
	String[] Q;
	String[] r; //black rooks
	String[] n; //...
	String[] b;
	String[] q;
	String[] k; //black king

	
	
 	
	//game move log.
	private ArrayList<String> log;
	
	
	public ChessGame() {
		board = new char[8][8]; // [A to H], [0 to 8] 
		gameover = false;
		log = new ArrayList<String>(100); //50 moves each to start, auto-resizes as necessary
		white = true;
		
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
		R = new String[]{"a1", "h1"};
		N = new String[]{"b1", "g1"};
		B = new String[]{"c1", "f8"};
		r = new String[]{"a8", "h8"};
		n = new String[]{"b8", "g8"};
		b = new String[]{"c8", "f8"};
		q = new String[]{"d8"};
		k = new String[]{"e8"};
		Q = new String[]{"d1"};
		K = new String[]{"e1"};
	}
	
	public int move(Move move ) { //numerical code where first two numbers specify the 2d array position of the piece
		//to be moved and the second two digits specify destination
		int res = 0;
		
		if (!playerOwnsPiece(move)) return 5;
		
		//if not valid return 1
		if (!isValid(move)) return 1;
		
		//if illegal move return 2
		else if (isIllegal(move)) return 2;
		
		//move the piece
		boolean capture = hasCapture(move); //save for later
		char replaced = board[move.r2][move.c2]; //what used to be on the destination
		board[move.r2][move.c2] = board[move.r1][move.c1]; //move piece to destination
		board[move.r1][move.c1] = '-'; //vacate previous location
		white = !white;
		
		String logEntry = move.toString()+ (capture ? "": (" Captured " +replaced));		
		
		//if checkmate return 4
		if (isCheckmate(move)) {
			res= 4;
			logEntry = logEntry+ ", Checkmate!";
		}
		// if Check return 3
		else if (isCheck(move)) { 
			res =  3;
			logEntry = logEntry+", Check!";
		}
		
		log.add(logEntry);
		return res;
		
	}
	
	//move processing methods
	
	public boolean isCheckmate(Move move) { //determines if the game is checkmate after this move is completed
		return false;
	}
	
	public boolean isIllegal(Move move) { //determines if this is an illegal move (King neglect)
		return false;
	}
	
	public boolean playerOwnsPiece(Move m) {
		char piece = board[m.r1][m.c1];
		//player owns piece
		if (isBlackPiece(piece)) {
			if (white) return false; //black piece on white turn
		}
		else {
			if (!white) return false; //white peice on black turn
		}
				
		return true;
	}
	
	public boolean isValid(Move m) { //determines if move is ok (player owns piece, follows movement rules, 
		
		//
		char piece = board[m.r1][m.c1];
		
		//is a move?
		if (piece == '-') return false; //move is no good if there is no piece.
		if (m.r1==m.r2 && m.c1==m.c2) return false; //move is no good if it doesn't move.
		
		//follows movement rules
		

		switch(piece) {
		case 'p':{
			return validPawnMove(m);
		}
		case 'P':{
			return validPawnMove(m);
		}
		case 'n': return validKnightMove(m);
		case 'N': return validKnightMove(m);
		case 'r': return validRookMove(m);
		case 'R': return validRookMove(m);
		case 'b': return validBishopMove(m);
		case 'B': return validBishopMove(m);
		case 'q': return validQueenMove(m);
		case 'Q': return validQueenMove(m);
		case 'K': return validKingMove(m);
		case 'k': return validKingMove(m);
	}
		
		
		return true;
	}
	
	public boolean isPossible(Move move) { //determines if move is possible, whether the appropriate piece exists and whether it has
		//the capability to move to the new location
		return true;
	}
	
	public boolean isCheck(Move move) {
		return false;
	}
	
	//other
	public char[][] getBoard(){
		return board;
	}
	
	public ArrayList<String> getLog() {
		return log;
	}
	
	public String boardToString(){//returns user friendly visual string for the board to be printed
		StringBuilder res = new StringBuilder();
		for(int i =7; i>=0; i--) {
			res.append("\n"+(i+1)+" ");
			for (char c: board[i]) {
				res.append(c);
				res.append(' ');
			}
		}
		res.append("\n  A B C D E F G H");
		return res.toString();
	}
	
	public boolean isDiagonalAndNoJump(Move m) { //returns if the move is diagonal and doens't jump
		int rowDiff = (m.r1 - m.r2);
	    int colDiff = (m.c1 - m.c2);
	    if (Math.abs(rowDiff) != Math.abs(colDiff)) return false; //not diagonal
	    
	    boolean rIncreasing = rowDiff<0;
	    boolean cIncreasing = colDiff<0;
	    
	    int offset=1;
	    while(offset<rowDiff) {
	    	if (board[m.r1+offset * (rIncreasing? 1:-1 )][m.c1+offset * (cIncreasing? 1:-1)] != '-') {
	    		return false; // diagonal encountered something 
	    	}
	    	offset++;
	    }
	    return true;
	}
	
	public boolean hasCapture(Move m) {
		if (board[m.r2][m.c2] != '-') return true;
		return false;
	}
	
	
	public boolean isStraightAndNoJump(Move m) { //returns if the move is straight along a row or column
		
		boolean sameRow = m.r1==m.r2;
		boolean sameCol = m.c1==m.c2;
		if (!sameRow && !sameCol) return false; //not straight
		
		int start, end; //arbitrary indexes for traverse
		if (sameCol) {
			start = (m.r1<m.r2) ? m.r1: m.r2;
			end = (m.r1<m.r2) ? m.r1: m.r2;
			for (int i=start+1; i<end; i++) {
				if (board[i][m.c1]!='-') return false; //has a jump because encountered something along the path
			}
		}
		else { //must be same row then
			start = (m.c1<m.c2) ? m.c1: m.c2;
			end = (m.c1<m.c2) ? m.c1: m.c2;
			for (int i=start+1; i<end; i++) {
				if (board[m.r1][i]!='-') return false; //has a jump because encountered something along the path
			}
		}
		return true;
	}
	
	
	private boolean isBlackPiece(char c) {
		if (c=='p' || c=='r' || c=='b' || c=='n' || c=='k' || c=='q') {
			return true;
		}
		return false;
	}
	
	private boolean validPawnMove(Move m) {
		if (!hasCapture(m) && m.r2-m.r1== (white? 1:-1)) return true; //pawn moved foward
		else if (hasCapture(m) && (white && m.r2-m.r1==1) || (!white && m.r2-m.r1==-1) && Math.abs(m.c2-m.c1)==1) {
			return true; //diagonal capture
		}
		else if((white && m.r1==1)||(!white && m.r1==6) && m.r2-m.r1 == (white? 2:-2)) { //pawn in starting position can go two foward
			return true;
		}
		return false;
	}
	
	private boolean validRookMove(Move m) {
		return false;
	}
	
	private boolean validKnightMove(Move m) {
		return false;
	}
	
	private boolean validBishopMove(Move m) {
		return false;
	}
	
	private boolean validKingMove(Move m) {
		//remember to castle
		return false;
	}
	
	private boolean validQueenMove(Move m) {
		return false;
	}
	
}
