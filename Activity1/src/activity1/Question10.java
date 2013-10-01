package activity1;

import util.*;
import tests.Ciphers;

public class Question10 {
	
	public static void main(String[] args) {
		
		String fileName = "CT";
		String path = ClassLoader.getSystemResource(fileName+".txt").getPath();
		final int E_INDEX_ACTUAL = 4;
		
		try {
			
			byte[] cipherText = ByteWorks.fileToBytes(path);
			int keyLength = determineKeyLength(cipherText);
			if(keyLength < 0) {
				System.out.println("Could not find key length, operation stops.\n");
			} else {
				
				System.out.printf("Found key of length %d, proceeding with decryption.\n", keyLength);
				
				byte[] allSimilarlyShifted = new byte[cipherText.length/keyLength];
				int freqs[];
				int shift;
				int shifts[] = new int[keyLength];
				int currentIndex = 0;
				int estimatedEIndex = 0;
				
				while(currentIndex < keyLength) {
					
					for(int i = 0; i < allSimilarlyShifted.length; i++)						
						allSimilarlyShifted[i] = cipherText[currentIndex+i*keyLength];
					
					freqs = LetterWorks.getFrequencies(allSimilarlyShifted);
					int highestFreq = 0;
					
					for(int i = 0; i < freqs.length; i++) {
						
						if(freqs[i] > highestFreq)
						{
							highestFreq = freqs[i];
							estimatedEIndex = i;
						}
						
					}
					
					shift = estimatedEIndex - E_INDEX_ACTUAL;
					if(shift < 0)
						shift = 25 + shift;
					shifts[currentIndex] = shift;
					
					currentIndex++;
				}
				System.out.print("Shifts: ");
				for(int i : shifts){
					System.out.printf(" %c :", Ciphers.numToChar(i));
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static int determineKeyLength(byte[] ar) {
		
		int keyLength = 1;
		int cipherIndex = 0;
		double indexOfCoincidence = 0;
		byte[] comparison;
		int arraySize;
		
		while (keyLength != ar.length) {
			
			arraySize = ar.length / keyLength;
			
			comparison = new byte[arraySize];
			for(int i = 0; i < comparison.length; i++) {;
				comparison[i] = ar[cipherIndex];
				cipherIndex += keyLength;
			}
			indexOfCoincidence = LetterWorks.getFreqIC(comparison);
			System.out.printf("KeyLength %d produced IoC %f\n", keyLength, indexOfCoincidence);
			if(indexOfCoincidence > 0.06) {
				return keyLength;
			}
			cipherIndex = 0;
			keyLength++;			
		}
		
		return -1;
	}

}
