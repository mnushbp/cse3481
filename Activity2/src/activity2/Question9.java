package activity2;

import java.security.Key;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import util.ByteWorks;

/*
 *  This is a programming question:*
 *
 * Encrypt the plaintext "Facebook" using DES without any padding or 
 * mode of operation using the key "universe" and output the ciphertext 
 * in binary (use the byteToBin method in util). Next, generate a random 
 * number between 0 and 63; flip that bit in the plaintext; encrypt; and 
 * compute the number of bits in the ciphertext that have flipped as a 
 * result. Re-do this avalanche effect computation several times; average 
 * the results; and write down (in the txt file of this question) the 
 * average number of flipped bits in the ciphertext.
 *
 */

public class Question9 {
	
	public static void main(String[] args) throws Exception{
		
		// Encrypt "HelloCSE" with key "MyOwnKey"
		Key secret = new SecretKeySpec("universe".getBytes(), "DES");
		// no IV, our text is 64b
		Cipher ce = Cipher.getInstance("DES");
		ce.init(Cipher.ENCRYPT_MODE, secret);
		byte[] pt = "Facebook".getBytes();
		byte[] ct = ce.doFinal(pt);
		System.out.println("Original");
		System.out.println("PT = " + ByteWorks.byteToBin(pt));
		System.out.println("CT = " + ByteWorks.byteToBin(ct));
		String old = ByteWorks.byteToBin(ct);
		Random rng = new Random();
		int[] diffs = new int[10];
		String newstr;
		for(int i = 0; i < diffs.length; i++) {
			int byteToFlip = rng.nextInt(7);
			int bitToFlip = rng.nextInt(7);
			pt[byteToFlip] = (byte) (pt[byteToFlip] ^ (1 << bitToFlip));
			ct = ce.doFinal(pt);
			System.out.println("PT = " + ByteWorks.byteToBin(pt));
			newstr = ByteWorks.byteToBin(ct);
			System.out.println("CT = " + newstr);
			System.out.println(ByteWorks.byteToBin(ct).length()/8.0);
			System.out.println(ct.length);
			for(int j = 0; j < ct.length; j++) {
				if(newstr.charAt(j) != old.charAt(j))
					diffs[i]++;
			}
			old = newstr;
		}
		double result = 0.0;
		for(int i : diffs) {
			result += i;
		}
		result /= diffs.length;
		
		System.out.println("The average number of bits changed is: " + result);
		//result seems to vary around 8
		
	}

}
