package CoreJava.J_Elementry.WrapperClass.String.BasicOps;

public class C_StringSubstring {
	 
    /**
     * This class shows usage of String substring methods
     * @param args
     */
    public static void main(String[] args) {
        String str = "www.journaldev.com";
        System.out.println("Removing first 4 char : "+str.substring(4));
        System.out.println("Last 4 char String: "+str.substring(str.length()-4));
        System.out.println("First 4 char String: "+str.substring(0, 4));
        System.out.println("website name[Same as Removing first 4 and last 4 char]: "+str.substring(4, 14));
        //Same as above.
        System.out.println("website name[Same as Removing first 4 and last 4 char]: "+str.substring(4, str.length()-4));
    }
}