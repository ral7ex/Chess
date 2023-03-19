
public class Move {
	int r1;
	int r2;
	int c1;
	int c2;
	public Move (String s) throws IllegalArgumentException {
		if (s.length() != 4) throw new IllegalArgumentException();
		//convert string codes to it
		
		
		
		
	}
	
	public Move(int r, int c, int r_dest, int c_dest) {
		r1 =r;
		r2 =r_dest;
		c1 = c;
		c2 = c_dest;
	}
}
