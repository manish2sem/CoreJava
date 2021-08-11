package CoreJava.J_Elementry.arrayConcept;


/**
 * 
 * @author Manish
 * The arraycopy() method has the following signature: 
 * 		public static void arraycopy(Object source, int sourcePos,
 * 									 Object destination, int destinationPos,
 * 									 int length)
 *
 */
public class ArrayCopi {
	public static void main(String [] args){
		int odds[] = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};	
		for(int i = 0; i < odds.length; i++){
			System.out.print("   odds["+i+"] := " + odds[i]);
		}
		
		int tmp[] = odds;
		odds = new int[20];
		System.out.println();
		System.out.println(" Before Copy");
		for(int i = 0; i < odds.length; i++){
			System.out.print("   odds["+i+"] := " + odds[i]);
		}
		System.arraycopy(tmp, 2, odds, 4, tmp.length-2);
		System.out.println();
		System.out.println(" After Copy");
		for(int i = 0; i < odds.length; i++){
			System.out.print("   odds["+i+"] := " + odds[i]);
		}
	}

}
