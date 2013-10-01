package activity1;

import util.*;

public class Question9A {
	
	public static void main (String[] args) {
		
		String fileName = "Sh1949";
		String path = ClassLoader.getSystemResource(fileName+".txt").getPath();
		
		try {
			byte[] byteArray = ByteWorks.fileToBytes( ClassLoader.getSystemResource(fileName+".txt").getPath()  ); //"./"+fileName+".txt");
			byteArray = LetterWorks.clean(byteArray);
			ByteWorks.bytesToFile(byteArray, path.substring(0, path.length()-4)+".PT"  );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
