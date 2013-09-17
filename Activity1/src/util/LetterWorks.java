package util;

/** General utility methods useful for working with classical ciphers
 * @author
 * @version
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
	   return null;
   }

   /**
    * Compute the frequencies of letters in a byte array made up of caps
    **/
   public static int[] getFrequencies(byte[] ar) {
	   return null;
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
	   return 0;
   }

   /**
    * Compute Index of Coincidence via Monte Carlo
    **/
   public static double getMonteIC(byte[] ar, int draws) {
	   return 0;
   }
}