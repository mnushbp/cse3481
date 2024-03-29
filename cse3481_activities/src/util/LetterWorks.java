package util;

/** General utility methods useful for working with classical ciphers
 * @author Matt Carr
 * @version 0.1
 */
public class LetterWorks
{

   /** Empty to prevent instantiation */
   private LetterWorks()
   {
   }

   /**
    * Clean away all the non-letters from an ANSI byte array and return a new
    * byte array with letters converted to upper-case.
    **/
   public static byte[] clean(byte[] in) {
	   
	   String toClean = new String(in);
	   char[] parseThrough = toClean.toCharArray();
	   StringBuffer cleaned = new StringBuffer();
	   for(char c : parseThrough) {   
		   if(c >= 'A' && c <= 'z') 
			   cleaned.append(c); 
	   }
	   return cleaned.toString().toUpperCase().getBytes();
   }

   /**
    * Compute the frequencies of letters in a byte array made up of caps
    **/
   public static int[] getFrequencies(byte[] ar) {
	   
	   int[] frequencies = new int[26];
	   String toExamine = new String(ar);
	   char[] charArray = toExamine.toCharArray();
	   for(char c : charArray) {
		   if(Ciphers.charToNum(c) != -1)
			   frequencies[Ciphers.charToNum(c)]++;
	   }
	      
	   return frequencies;
   }

   /**
    * Compute the hash of an array of bytes via xor every 16
    **/
   public static byte[] getXorHash(byte[] ar) {
	   
	   byte[] result = new byte[16];
	   byte[] temp = new byte[16];
	   int count = 0;
	   int length = ar.length;
	   while(count < length) {
		   if(count%16 == 0) {
			   for(int i = 0; i < 16; i++) {
				   result[i] = (byte) (result[i]^temp[i]);
			   }
		   }
		   temp[count%16] = ar[count];
		   count++;
	   }
	   
	   return result;
	   
   }

   /**
    * Compute the hash of an array of bytes via ascii sum mod 26 every 16
    **/
   public static byte[] getSumHash(byte[] ar) {
	   return null;
   }

   /**
    * Compute Index of Coincidence via frequencies
    **/
   public static double getFreqIC(byte[] ar) {
	   
	   int[] frequencies = getFrequencies(ar);
	   int n = ar.length;
	   double IoC = 0;
	   
	   for(int i : frequencies) {
		   
		   IoC += (((double)i*((double)i+1))/((double)n*((double)n-1)));
		   
	   }
	   
	   
	   return IoC;
   }

   /**
    * Compute Index of Coincidence via Monte Carlo
    **/
   public static double getMonteIC(byte[] ar, int draws) {
	   return 0;
   }
}