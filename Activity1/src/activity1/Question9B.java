package activity1;

import util.*;

public class Question9B {
	
	public static void main(String[] args) {
		
		String fileName = "Sh1949";
		
		try {
		
			byte[] byteArray = ByteWorks.fileToBytes("C:/temp/"+fileName+".PT");
			String string = new String(byteArray, "UTF8");
			System.out.println(string);
			//int[] freqs = LetterWorks.getFrequencies(byteArray);
			
			//for(int i : freqs) {
			//	System.out.printf("%d ; ", i);
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
