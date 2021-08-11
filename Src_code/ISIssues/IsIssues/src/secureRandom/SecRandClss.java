package secureRandom;

import java.security.SecureRandom;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

public class SecRandClss {
	

	 final static Locale nullLocale = new Locale("", "");
	
	 static SecureRandom r;
	// static Random r;
	    static {
	    	r = new SecureRandom();
	    	System.out.println("calling static");
	    	
	    	// This fake call of nextDouble() is to improve performance
	    	// If you don't call setSeed() before getting data, then the PRNG will seed itself once the first time you call next...(). 
	    	// And this is time consuming.
	    	 System.out.println("static double " + r.nextDouble());
             
	    }
	    
	    public static void randomDouble()  {

	    	NumberFormat nf = NumberFormat.getInstance(nullLocale);

            nf.setGroupingUsed(false);
            nf.setMaximumFractionDigits(3);   
            String dbl =  nf.format(r.nextDouble());
	    	 System.out.println("static double " + dbl);

         //   String arr[] = dbl.split(Pattern.quote("."));
	            String arr[] = dbl.split("\\.");

            
            System.out.println(" arr[0] " +arr[0]);
            System.out.println(" length " +arr[1].length());
	        System.out.println("main double " + nf.format(r.nextDouble()));
	                
	      
	        // --- <<B2B-END>> ---
	    }


}
