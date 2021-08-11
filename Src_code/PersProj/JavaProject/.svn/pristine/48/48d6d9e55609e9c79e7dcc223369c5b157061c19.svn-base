package CoreJava.java.lang;
/**
 * This code will compile but on execution gives following exception
 * java.lang.SecurityException: Prohibited package CoreJava.name: java.lang
 * 
 * Since clone is protected it is available for clnTest because
 * clnTst is declared inside java.lang package, the same where object is defined.
 * @author Manish
 *
 */

public class clnTst {
	
	public static void main(String args[]){
		clnTst ct=new clnTst();
		clnTst other;
		int x= ct.hashCode();
		System.out.println("Hashcode : "+x);
		try{
			other = (clnTst)ct.clone();
			System.out.println("Hashcode : "+other.hashCode());
		}catch(CloneNotSupportedException ex){
			System.out.println("BasicClone Cannot be cloned");
			ex.printStackTrace();			
		}
	}

}
