package tests;

public class Ciphers {
	
	public static void main(String[] args) {
		
		String toEncrypt = "hello";
		
		toEncrypt = toEncrypt.toUpperCase();
		
		System.out.printf("%s", caesarEncrypt(toEncrypt, 1));
		
	}
	
	public static String affineEncrypt(String plaintext, int alpha, int beta) {
		
		StringBuffer ciphertext = new StringBuffer();
		String toReturn;
		int encrypting;
		
		for(int i = 0; i < plaintext.length(); i++) {
			
			encrypting = charToNum(plaintext.charAt(i));
			encrypting = (encrypting * alpha + beta) % 26;
			ciphertext.append(numToChar(encrypting));
			
		}
		toReturn = ciphertext.toString();
		return toReturn;
	}
	
	public static String caesarEncrypt(String plaintext, int offset) {
		
		StringBuffer ciphertext = new StringBuffer();
		String toReturn;
		int encrypting;
		
		for(int i = 0; i < plaintext.length(); i++) {
			
			encrypting = charToNum(plaintext.charAt(i));
			encrypting = (encrypting + offset) % 26;
			ciphertext.append(numToChar(encrypting));
			
		}
		toReturn = ciphertext.toString();
		return toReturn;
		
	}
	
	public static int charToNum(char c) {
		switch(c) {
		case 'A':
			return 0;
		case 'B':
			return 1;
		case 'C':
			return 2;
		case 'D':
			return 3;
		case 'E':
			return 4;
		case 'F':
			return 5;
		case 'G':
			return 6;
		case 'H':
			return 7;
		case 'I':
			return 8;
		case 'J':
			return 9;
		case 'K':
			return 10;
		case 'L':
			return 11;
		case 'M':
			return 12;
		case 'N':
			return 13;
		case 'O':
			return 14;
		case 'P':
			return 15;
		case 'Q':
			return 16;
		case 'R':
			return 17;
		case 'S':
			return 18;
		case 'T':
			return 19;
		case 'U':
			return 20;
		case 'V':
			return 21;
		case 'W':
			return 22;
		case 'X':
			return 23;
		case 'Y':
			return 24;
		case 'Z':
			return 25;
		default:
			return -1;
		
		}
	}
	
	public static char numToChar(int i) {
		switch(i) {
		case 0:
			return 'A';
		case 1:
			return 'B';
		case 2:
			return 'C';
		case 3:
			return 'D';
		case 4:
			return 'E';
		case 5:
			return 'F';
		case 6:
			return 'G';
		case 7:
			return 'H';
		case 8:
			return 'I';
		case 9:
			return 'J';
		case 10:
			return 'K';
		case 11:
			return 'L';
		case 12:
			return 'M';
		case 13:
			return 'N';
		case 14:
			return 'O';
		case 15:
			return 'P';
		case 16:
			return 'Q';
		case 17:
			return 'R';
		case 18:
			return 'S';
		case 19:
			return 'T';
		case 20:
			return 'U';
		case 21:
			return 'V';
		case 22:
			return 'W';
		case 23:
			return 'X';
		case 24:
			return 'Y';
		case 25:
			return 'Z';
		default:
			return ' ';
		
		}
	}

}
