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
	   RandomAccessFile f = new RandomAccessFile(file, "r");
	   try {
		   //get file size, error if > 2GB
		   long longlength = f.length();
		   int length = (int) longlength;
		   if(length != longlength)
			   throw new IOException("File size >= 2 GB");
		   byte[] data = new byte[length];
		   f.readFully(data);
		   return data;
	   } finally {
		   f.close();
	   }  
   }

   /** 
    * Create a file with the given name and wWrite the given array of bytes to it 
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

}