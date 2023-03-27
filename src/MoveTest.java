import org.junit.Assert;
import org.junit.Test;
public class MoveTest {

	//testing the move class
	
	//
	@Test
	public void testConstructor() {
		
		Move move = new Move("a1h8");
		Assert.assertEquals(0, move.c1);
		Assert.assertEquals(0, move.r1);
		Assert.assertEquals(7, move.c2);
		Assert.assertEquals(7, move.r2);
		
		move = new Move(1, 2, 8, 0);
		Assert.assertEquals(2, move.c1);
		Assert.assertEquals(1, move.r1);
		Assert.assertEquals(0, move.c2);
		Assert.assertEquals(8, move.r2);
		
	}
	@Test
	public void testToString() {
		Move move = new Move("a1h8");
		Assert.assertEquals("a1h8", move.toString());
		
		move.c1 = 15; //weird case
		Assert.assertEquals("!1h8", move.toString());
	}
	
	
	
	//exceptions
	@Test (expected=Exception.class)
	public void testConstructorException() throws IllegalArgumentException{
		new Move("");
	}
	@Test (expected=Exception.class)
	public void testConstructorException1() throws IllegalArgumentException{
		new Move("ab");
	}
	@Test (expected=Exception.class)
	public void testConstructorException2() throws IllegalArgumentException{
		new Move("abcd");
	}
	@Test (expected=Exception.class)
	public void testConstructorException3() throws IllegalArgumentException{
		new Move("a9b2");
	}
	@Test (expected=Exception.class)
	public void testConstructorException4() throws IllegalArgumentException{
		new Move("9ab2");
	}
}
