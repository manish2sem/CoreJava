package CoreJava.J_Elementry.arrayConcept;
/**
 * 
 * @author Manish
 * Primitive arrays can accept any value 
 * that can be promoted implicitly to the declared type of the array.
 *
 * If the declared array type is a class, you can put objects of any subclass of the declared type into the array.
 * 
 * If the array is declared as an interface type, the array elements can refer to any
 * 	instance of any class that implements the declared interface.
 * If the array is of 2D (say int) then each cell can accept an array of type int only
 * 
 */

public class ArrayAssignment {

}

class PrimitiveAssignment{
	
	float[] weightList = new float[7];
	byte b = 4;
	char c = 'c';
	short s = 7;
	int i =10;
	long l=12;
	float f=89.5F;
	double d =23.34;
	
	{	//Initialization block
		weightList[0] = b; // OK, byte is smaller than float
		weightList[1] = c; // OK, char is smaller than float
		weightList[2] = s; // OK, short is smaller than float
		weightList[3] = i; // OK, int is smaller than float
		weightList[4] = l; // OK, long is smaller than float
		weightList[5] = f; // OK, float
		weightList[6] = (float)d; // error, double is not smaller than float. Explicit casr reqd.
	}
	public static void main(String args){
		
	}
	int x[][]=new int[3][];
	int a[]=new int[4];
	short sb[]=new short[3];
	long bc[]=new long[3];
	{	//Initialization block
		x[0] = a; // OK, a is of int type.
		x[1] = sb; // Not OK, short array  can not be assigned to int array.
		x[2] = bc; // Not OK, long array  can not be assigned to int array.
		
	}
	
	
	
	
}