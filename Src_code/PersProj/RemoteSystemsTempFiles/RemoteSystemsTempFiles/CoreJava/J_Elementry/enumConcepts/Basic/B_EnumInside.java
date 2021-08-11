package CoreJava.J_Elementry.enumConcepts.Basic;

/**
 * enums can be declared as their own class, or enclosed in another class, and 
 * that the syntax for accessing an enum's members depends on where the enum was declared.
 * @author sinhama
 *
 */
public class B_EnumInside {
	enum CoffeeSize {BIG, HUGE, OVERWHELMING }
	CoffeeSize size;
	A_CoffeeSize size1;

	public static void main(String[] args) {
		B_EnumInside drink = new B_EnumInside();
		drink.size = B_EnumInside.CoffeeSize.BIG; // enclosing class name required. compare to static!!
		drink.size1 = A_CoffeeSize.BIG;
		System.out.println("Cofee Size = : " + drink.s);
		//String size = 
	}

}
