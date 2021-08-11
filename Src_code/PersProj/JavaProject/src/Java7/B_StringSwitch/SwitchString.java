package Java7.B_StringSwitch;


/**
 * In JDK 7, you can use a String object as the selector.
 * Benefit of using String in switch is that, Java compiler can generate more efficient code than using nested if-then-else statement.
 * @author Manish
 *
 */

public class SwitchString {

	public static void main(String[] args) {
		String state = "NEW";

		switch (state) {
		   case "NEW": System.out.println("Order is in NEW state"); break;
		   case "CANCELED": System.out.println("Order is Cancelled"); break;
		   case "REPLACE": System.out.println("Order is replaced successfully"); break;
		   case "FILLED": System.out.println("Order is filled"); break;
		   default: System.out.println("Invalid");

		}
	}

}
