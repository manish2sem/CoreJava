package CoreJava.J_Elementry.impConcepts.PaassByValueRef;

import java.awt.Point;

/**
 * Java passes the references by value just like any other parameter. This means the references passed to the method are actually copies of the original references.
 * Java copies and passes the reference by value, not the object. Thus, method manipulation will alter the objects, since the references point to the original objects. But since the references are copies, swaps will fail.
 * @author sinhama
 *
 */

public class E_StrictlyPassByValue {
	
	public static void main(String [] args)	{
	  Point pnt1 = new Point(0,0);
	  Point pnt2 = new Point(0,0);
	  System.out.println("X: " + pnt1.x + " Y: " +pnt1.y); 
	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
	  System.out.println(" ");
	  tricky(pnt1,pnt2);
	  System.out.println("X: " + pnt1.x + " Y:" + pnt1.y); 
	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);  
	}
	
	public static void tricky(Point arg1, Point arg2)	{
	  arg1.x = 100;
	  arg1.y = 100;
	  Point temp = arg1;
	  arg1 = arg2;
	  arg2 = temp;
	}

}
