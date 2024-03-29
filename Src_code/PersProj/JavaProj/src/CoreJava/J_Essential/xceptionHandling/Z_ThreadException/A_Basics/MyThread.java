package CoreJava.J_Essential.xceptionHandling.Z_ThreadException.A_Basics;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyThread implements Runnable {

	
	/**
	 * unlike other methods [readFile()]
	 * Run method can't throw checked exception 
	 * 		i.e. public void run() throws IOException --> will not work
	 * But it can handle or catch the checked exception. 
	 * 
	 * How does run stops throwing checked exception???
	 * 		Exception IOException is not compatible with throws clause in Runnable.run()
	 */
	@Override
//	public void run() throws IOException {
	public void run() {
		try {
			readFile( );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	 public void readFile( ) throws IOException {

	        FileInputStream in = null;
	        FileOutputStream out = null;

	        try {
	            in = new FileInputStream("xanadu1.txt");
	            out = new FileOutputStream("outagain.txt");
	            int c;

	            while ((c = in.read()) != -1) {
	            	System.out.println("C is : " +c);
	                out.write(c);
	            }
	            
	        } catch (Exception sle) {
				System.out.println("IOException caught as Exception");
				        
	        } finally {
	            if (in != null) {
	                in.close();
	            }
	            if (out != null) {
	                out.close();
	            }
	        }
	    }

}
