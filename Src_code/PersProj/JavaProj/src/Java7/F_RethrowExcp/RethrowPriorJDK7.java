package Java7.F_RethrowExcp;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RethrowPriorJDK7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void obscure() throws Exception{ 
		try { 
			new FileInputStream("abc.txt").read();
			new SimpleDateFormat("ddMMyyyy").parse("12-03-2014"); 
		} catch (Exception ex) { 
			System.out.println("Caught exception: " + ex.getMessage()); 
			throw ex; 
		} 
	}
	
	public void obscureTest() throws IOException, ParseException{ 
		try { 
			new FileInputStream("abc.txt").read();
			new SimpleDateFormat("ddMMyyyy").parse("12-03-2014"); 
		} catch (IOException ex) { 
			System.out.println("Caught exception: " + ex.getMessage()); 
			throw ex; 
		} 
		catch (ParseException ex) { 
			System.out.println("Caught exception: " + ex.getMessage()); 
			throw ex; 
		} 
	}

}
