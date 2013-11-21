package util;

import java.io.*;
 
/** General utility methods useful for working with byte arrays
 * @author Matt Carr
 * @version 0.1
 */
public class ByteWorks
{

   /** Empty to prevent instantiation */
   private ByteWorks(){ 
	   
   }

   /** 
    * Read the given file into an array of bytes 
    **/
   public static byte[] fileToBytes(String filename) throws Exception {
	   File file = new File(filename);
	   int read;
	   FileInputStream in;
	   ByteArrayOutputStream out;
	   in = new FileInputStream(file);
	   out = new ByteArrayOutputStream();

	   read = in.read();
	   
	   while(read != -1) {
		   out.write(read);
		   read = in.read();
	   }
	   in.close();
	   return out.toByteArray();
	   
   }

   /** 
    * Create a file with the given name and write the given array of bytes to it 
    **/ 
   public static void bytesToFile(byte[] data, String filename) throws Exception {
	   File file = new File(filename);
	   FileOutputStream out = new FileOutputStream(file);
	   try {
		   if(!(file.exists()))
			   file.createNewFile();
		   if(!(file.canWrite()))
			   throw new IOException("Cannot write to target file");
		   out.write(data);
	   } finally {
		   out.close();
	   }
	   
   }
   
   public static String byteToHex(byte[] ar)
	{
		assert ar != null;
		String result = "";
		for (int i = 0; i < ar.length; i++)
		{
			int x = ar[i] & 0x000000FF;
			String tmp = Integer.toHexString(x);
			if (x < 16) tmp = "0" + tmp;
			result += tmp;
		}
		return result.toUpperCase();
	}
	
	public static byte[] hexToByte(String hex)
	{
		assert hex != null && hex.length() % 2 == 0;
		byte[] result = new byte[hex.length() / 2];
		for (int i = 0; i < hex.length(); i = i + 2)
		{
			result[i / 2] = (byte) Integer.parseInt(hex.substring(i, i + 2), 16);
		}
		return result;
	}
	
	//test this, not necessarily complete
	public static String byteToBin(byte[] ar) {
		
		assert ar != null;
		String result = "";
		for(int i = 0; i < ar.length; i++) {
			int x = ar[i];
			String tmp = Integer.toBinaryString(x);
			while(tmp.length() < 8){
				tmp = "0" + tmp;
			}
			while(tmp.length() > 8) {
				tmp = tmp.substring(1);
			}
			result += tmp;
		}
		
		return result;
		
	}

}