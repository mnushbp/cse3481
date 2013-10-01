package activity1;

import util.*;
import tests.Ciphers;

public class Question9B {
	
	public static void main(String[] args) {
		
		String fileName = "Sh1949";
		
		try {
		
			byte[] byteArray = ByteWorks.fileToBytes("C:/temp/"+fileName+".PT");
			String plaintext = new String(byteArray);
			String caesarEncrypted;
			int[] freqs = LetterWorks.getFrequencies(byteArray);
			for(int i : freqs) {
				System.out.printf("%d ; ", i);
			}
			System.out.println();
			caesarEncrypted = Ciphers.caesarEncrypt(plaintext, 1);

			ByteWorks.bytesToFile(caesarEncrypted.getBytes(), "C:/temp/"+fileName+".CT");
			
			byteArray = ByteWorks.fileToBytes("C:/temp/"+fileName+".CT");
			plaintext = new String(byteArray);
			freqs = LetterWorks.getFrequencies(byteArray);
			for(int i : freqs) {
				System.out.printf("%d ; ", i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
