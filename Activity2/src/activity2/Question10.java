package activity2;

import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import util.ByteWorks;

/*
 * This is a programming question:*
 *
 * An English string is encrypted with 128-bit AES using 
 * PKCS5 padding, the CBC mode of operation, and the 
 * following parameters:
 *
 *     Key: 9F0DCEDB322F3C6873F9256E01376BA4
 *     IV:  20FC19123087BF6CAC8D0F1254123004
 *
 * Given that the ciphertext is:
 *
 *     F38ADBA8A7B4CC613578355032205D50
 *
 * write a program that determines the letters of the 
 * plaintext and outputs them as English letters, i.e. not in hex or binary. 
 */

public class Question10 {
	
	public static void main(String[] args) throws Exception {
		
		// Encrypt "HelloCSE" with key "MyOwnKey"
				Key secret = new SecretKeySpec(ByteWorks.hexToByte(
						"9F0DCEDB322F3C6873F9256E01376BA4"), "AES");
				AlgorithmParameterSpec aps = new IvParameterSpec(
						ByteWorks.hexToByte("20FC19123087BF6CAC8D0F1254123004"));
				Cipher ce = Cipher.getInstance("AES/CBC/PKCS5Padding");
				byte[] ct = ByteWorks.hexToByte("F38ADBA8A7B4CC613578355032205D50");
				System.out.println("CT = " + ByteWorks.byteToHex(ct));
				ce.init(Cipher.DECRYPT_MODE, secret, aps);
				byte[] back = ce.doFinal(ct);
				String english = "";
				for(byte b : back) {
					
					english += (char) b;
					
				}
				System.out.println("PT = " + english);

		
	}

}
