package CoreJava.J_Importent.cloning.basicclone;


/**
 * This code will compile but on execution gives following exception
 * java.lang.CloneNotSupportedException: basicclone.clnTst
 * Reason : if the class of this object does not implement the interface Cloneable, 
 * then a CloneNotSupportedException is thrown.
 * 
 * Since clone is protected it is available for clnTest because
 * clnTst extends Object in which clone is defined.
 * note : Protected metods are available to other class if 
 * 1. the class is declared in same package
 * 2. class is declared in diff package CoreJava.but extends the class in which protected method is declared.
 * @author Manish
 *
 */
public class clnTst implements Cloneable{
	
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
