package DS.String.A_Elementry;

public class C_StringSubstring {
	 
    /**
     * This class shows usage of String substring methods
     * 		str.substring(start, end));
     * 		str.substring(n); = str.substring(n, end));
     * @param args
     */
    public static void main(String[] args) {
        String str = "www.journaldev.com";
        System.out.println("Last 4 char String: "+str.substring(str.length()-4));
        System.out.println("First 4 char String: "+str.substring(0, 4));
        System.out.println("char String skipping First 4 : "+str.substring(4));
        System.out.println("website name: "+str.substring(4, 14));
    }
}