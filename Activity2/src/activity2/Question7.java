package activity2;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.ByteWorks;

public class Question7 {
	
	public static void main(String[] args) throws Exception {
		
        // Encrypt "HelloCSE" with key "MyOwnKey"
		byte[] key = "universe".getBytes();
		byte[] key2 = new byte[key.length];
		
		for(int i = 0; i < key.length; i++) {
			key2[i] = (byte)(key[i] ^ 255);
		}
		
		Key secret = new SecretKeySpec(key, "DES");
		Key flipped = new SecretKeySpec(key2, "DES");
		
		byte[] pt = "Facebook".getBytes();
		byte[] pt2 = new byte[pt.length];
		
		for(int i = 0; i < pt.length; i++) {
			pt2[i] = (byte)(pt[i] ^ 255);
		}
		
		Cipher ce = Cipher.getInstance("DES");
		
		ce.init(Cipher.ENCRYPT_MODE, secret);
		byte[] ct = ce.doFinal(pt);
		System.out.println("Original");
		System.out.println("PT = " + ByteWorks.byteToBin(pt));
		System.out.println("CT = " + ByteWorks.byteToBin(ct));
		
		ce.init(Cipher.ENCRYPT_MODE, flipped);
		byte[] ct2 = ce.doFinal(pt2);
		System.out.println("Flipped");
		System.out.println("PT = " + ByteWorks.byteToBin(pt2));
		System.out.println("CT = " + ByteWorks.byteToBin(ct2));
		
	}

}

/*
 * Original
PT = 0100011001100001011000110110010101100010011011110110111101101011
CT = 01010001010101100001011111001110001010011110110110110100110011100--Stops being a mirror here...--100110011110111110001010110000010101110101001001011111100101100
Flipped
PT = 1011100110011110100111001001101010011101100100001001000010010100
CT = 10101110101010011110100000110001110101100001001001001011001100011--Stops being a mirror here...--101100110011100101101011011001001100101110110100101101000110101 */
