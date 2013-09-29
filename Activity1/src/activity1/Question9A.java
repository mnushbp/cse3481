package activity1;

import util.*;

public class Question9A {
	
	public static void main (String[] args) {
		
		String fileName = "Sh1949";
		
		try {
			byte[] byteArray = ByteWorks.fileToBytes("C:/"+fileName+".txt");
			byteArray = LetterWorks.clean(byteArray);
			ByteWorks.bytesToFile(byteArray, "C:/temp/"+fileName+".PT");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
