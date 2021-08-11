package CoreJava.J_Elementry.WrapperClass.BasicConcepts;

/**
 * 	In order to save memory, Following wrapper objects (created through boxing),
 *  will always be == when their primitive values are the same:
		- Boolean
		- Byte
		- Character from \u0000 to \u007f (7f is 127 in decimal)
		- Short and Integer from -128 to 127

 * @author Manish
 *
 */
public class D_IntCompare {

	public static void main(String[] args) {
		
		//Integer i1 = 128;
		//Integer i2 = 128;
		Long i1 = 127L;
		Long i2 = 127L;
		if(i1 != i2)
				System.out.println("different objects");
		else
				System.out.println("Same object");;
		if(i1.equals(i2)) System.out.println("meaningfully equal");

	}

}
