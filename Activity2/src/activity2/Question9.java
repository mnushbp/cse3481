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
		Cipher ce = Cipher.getInstance("DES/ECB/NoPadding");
		ce.init(Cipher.ENCRYPT_MODE, secret);
		byte[] pt = "Facebook".getBytes();
		byte[] ct = ce.doFinal(pt);
		System.out.println("Original");
		System.out.println("PT = " + ByteWorks.byteToBin(pt));
		System.out.println("CT = " + ByteWorks.byteToBin(ct));
		Random rng = new Random();		
		for(int i = 0; i < 10; i++) {
			int byteToFlip = rng.nextInt(7);
			int bitToFlip = rng.nextInt(7);
			pt[byteToFlip] = (byte) (pt[byteToFlip] ^ (1 << bitToFlip));
			ct = ce.doFinal(pt);
			System.out.println("Flipped bit " + (byteToFlip+1)*(bitToFlip+1));
			System.out.println("PT = " + ByteWorks.byteToBin(pt));
			System.out.println("CT = " + ByteWorks.byteToBin(ct));
		}
		
		
	}

}
