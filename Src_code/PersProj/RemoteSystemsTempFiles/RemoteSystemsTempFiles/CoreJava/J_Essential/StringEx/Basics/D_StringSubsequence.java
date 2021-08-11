package CoreJava.J_Essential.StringEx.Basics;

/**
 * Java 1.4 introduced CharSequence interface and String implements this interface, 
 * this is the only reason for the implementation of subSequence method in String class.
 * Internally it invokes the String substring method.
 * @author sinhama
 *
 */

public class D_StringSubsequence {
	 
    /**
     * This class shows usage of String subSequence method
     * exactly the same way as subString.
     * @param args
     */
    public static void main(String[] args) {
        String str = "www.journaldev.com";
        System.out.println("Last 4 char String: "+str.subSequence(str.length()-4, str.length()));
        System.out.println("First 4 char String: "+str.subSequence(0, 4));
        System.out.println("website name: "+str.subSequence(4, 14));
        //substring vs subSequence
        System.out.println("substring == subSequence ? "+(str.substring(4, 14) == str.subSequence(4, 14)));
        System.out.println("substring equals subSequence ? "+(str.substring(4, 14).equals(str.subSequence(4, 14))));
    }
 
}