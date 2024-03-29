import org.junit.Assert;
import org.junit.Test;

public class ChessGameTest {

	
	//testing move
	@Test
	public void testMove() {
		ChessGame game = new ChessGame();
		Move m = new Move("a2a4");
		game.move(m);
		System.out.println(game.board[1][0]);
		Assert.assertEquals('-', game.board[1][0]);
		Assert.assertEquals('P', game.board[3][0]);
		Assert.assertEquals("a2a4", game.getLog().get(0));
		
		/*TODO
		 * 
		 * 1. test upon capture
		 * 2. test upon check
		 * 3. test upon checkmate: validated
		 */
		
		
		Assert.assertFalse(game.isStraightAndNoJump(m));
		
	}
	
	
	ChessEngine a;
	
}
