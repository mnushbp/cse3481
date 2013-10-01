package activity1;

import java.util.Random;

import util.*;
import tests.Ciphers;

public class Question9B {
	
	public static void main(String[] args) {
		
		String fileName = "Sh1949";
		String path = ClassLoader.getSystemResource(fileName+".txt").getPath();
		
		try {
		
			byte[] byteArray = ByteWorks.fileToBytes(path.substring(0, path.length()-4)+".PT");
			String plaintext = new String(byteArray);
			String caesarEncrypted;
			int[] freqs = LetterWorks.getFrequencies(byteArray);
			System.out.print("Plaintext Frequencies: ");
			for(int i : freqs) {
				System.out.printf("%d ; ", i);
			}
			System.out.println();
			//E is obviously the most frequently used letter.
			
			caesarEncrypted = Ciphers.caesarEncrypt(plaintext, 1);
			ByteWorks.bytesToFile(caesarEncrypted.getBytes(), path.substring(0, path.length()-4)+".CT");
			byte[] byteArray2 = ByteWorks.fileToBytes(path.substring(0, path.length()-4)+".CT");
			plaintext = new String(byteArray2);
			freqs = LetterWorks.getFrequencies(byteArray2);
			System.out.print("Caesar Ciphertext Frequencies: ");
			for(int i : freqs) {
				System.out.printf("%d ; ", i);
			}
			System.out.println();
			//As expected, the distributions are the same, but shifted.
			
			byte[] hash = new byte[16];
			int counter = 0;
			for(byte b : byteArray) {
				
				hash[counter] = (byte) ((hash[counter] + b) % 26);
				counter++;
				if(counter==16)
					counter=0;
			}
			System.out.print("York Hash: ");
			for(byte b : hash) {
				System.out.printf("%d ", b);
			}
			System.out.println();
			
			double IoC = LetterWorks.getFreqIC(byteArray);
			System.out.println("Incidence of Coincidence (Plaintext): "+IoC);
			
			byte[] byteArray3 = new byte[byteArray.length];
			Random rng = new Random();
			char randomChar;
			for(int i = 0; i < byteArray.length; i++) {	
				randomChar = Ciphers.numToChar((int)(rng.nextDouble() * 26));
				byteArray3[i] = (byte)randomChar;
			}
			System.out.println();
			IoC = LetterWorks.getFreqIC(byteArray3);
			System.out.println("Incidence of Coincidence (Random Text): "+IoC);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
