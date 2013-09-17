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
   public static byte[] clean(byte[] in)

   /**
    * Compute the frequencies of letters in a byte array made up of caps
    **/
   public static int[] getFrequencies(byte[] ar)

   /**
    * Compute the hash of an array of bytes via xor every 16
    **/
   public static byte[] getXorHash(byte[] ar)

   /**
    * Compute the hash of an array of bytes via ascii sum mod 26 every 16
    **/
   public static byte[] getSumHash(byte[] ar)

   /**
    * Compute Index of Coincidence via frequencies
    **/
   public static double getFreqIC(byte[] ar)

   /**
    * Compute Index of Coincidence via Monte Carlo
    **/
   public static double getMonteIC(byte[] ar, int draws)
}