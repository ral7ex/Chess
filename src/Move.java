
public class Move {
	
	int r1; //board indexes
	int r2;
	int c1;
	int c2;
	
	public Move (String s) throws IllegalArgumentException {
		s = s.toLowerCase();
		if (s.length() != 4) throw new IllegalArgumentException();
		
		//convert string codes to it
		r1 = intToInt(s.charAt(1)); // -1 because index
		r2 = intToInt(s.charAt(3));
		c1 = letterToInt(s.charAt(0));
		c2 = letterToInt(s.charAt(2));
		if (c1==-1 || c2==-1 || r1 ==-1 || r2 ==-1) throw new IllegalArgumentException();
		
	}
	
	public Move(int r, int c, int r_dest, int c_dest) {
		r1 =r;
		r2 =r_dest;
		c1 = c;
		c2 = c_dest;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(intToLetter(c1));
		s.append(r1+1); //+1 because array index starts at 0
		s.append(intToLetter(c2));
		s.append(r2+1);
		return s.toString();
	}
	
	public int letterToInt(char c) {
		
		switch(c) {
		case 'a': return 0;
		case 'b': return 1;
		case 'c': return 2;
		case 'd': return 3;
		case 'e': return 4;
		case 'f': return 5;
		case 'g': return 6;
		case 'h': return 7;
		default: return -1;
		}
	}
	
	public int intToInt(char c) {
		switch(c) {
		case '1': return 0;
		case '2': return 1;
		case '3': return 2;
		case '4': return 3;
		case '5': return 4;
		case '6': return 5;
		case '7': return 6;
		case '8': return 7;
		default: return -1;
		}
	}
	
	public char intToLetter(int k) {
		switch(k) {
		case 0: return 'a';
		case 1: return 'b';
		case 2: return 'c';
		case 3: return 'd';
		case 4: return 'e';
		case 5: return 'f';
		case 6: return 'g';
		case 7: return 'h';
		default: return '!';
		}
	}
}
