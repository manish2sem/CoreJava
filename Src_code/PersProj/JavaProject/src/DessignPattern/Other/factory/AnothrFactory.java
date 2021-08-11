package DessignPattern.Other.factory;
/**
 * 
 * Factory Design pattern is based on Encapsulation object oriented concept. 
 *  Factory method is used to create different object from factory Item and it encapsulate the creation code. 
 *  So instead of having object creation code on client side we encapsulate inside Factory method in Java
 * 
 * 
Example of static factory method in JDK :
 * valueOf() method which returns object created by factory equivalent to value of parameter passed. 
 * getInstance() method which creates instance of Singleton class.
 * newInstance() method which is used to create and return new instance from factory method every time called.
 * 
When to use Factory design pattern in Java :
 * Factory method is used when Products don't need to know how they are created. 
 * We  can use factory pattern where we have to create an object of any one of sub-classes depending on the data provided
 * 
 *Problem solved by Factory method Pattern in Java : 
 * Whenever we talk about object oriented language it will based upon some concept like abstraction, polymorphism etc and 
 * on that encapsulation and delegation are important concept any design will be called good 
 * if task are delegated to different object and some kind of encapsulation is there. 
 * Some time our application or framework knows when it has to create but don’t know what kind of object.
 * Whenever we create object using new() we violate principle of programming for interface rather than implementation
 *  which eventually result in inflexible code and difficult to change in maintenance. 
 *  By using Factory design pattern in Java we get rid of this problem.
 * Another problem we can face is class needs to contain objects of other classes or class hierarchies within it;
 *  this can be very easily achieved by just using the new keyword and the class constructor. 
 *  The problem with this approach is that it is a very hard coded approach to create objects as this creates dependency between the two classes. 
 * So factory pattern solve this problem very easily by model an interface for creating an object which at creation time can let its subclasses decide which class to instantiate, Factory Pattern promotes loose coupling by eliminating the need to bind application-specific classes into the code.

 */


public class AnothrFactory {
	public static void main(String args[]) {
		//String country = args[0];
		//String country = "India";
		String country = "US";
		Currency cur = CurrencyFactory.createCurrency(country);
		System.out.println(cur.getSymbol());
		
		if(cur instanceof Rupee){
			((Rupee) cur).rsDesc();
		} else if(cur instanceof SGDDollar){
			((SGDDollar) cur).sgdDesc();
		} else if(cur instanceof USDollar){
			((USDollar) cur).usDesc();
		}else {
			System.out.println("Wrong Argument");
		}
	}

}

class CurrencyFactory {
	
	public static Currency createCurrency (String country) {
		if (country. equalsIgnoreCase ("India")){
			return new Rupee();
		}else if(country. equalsIgnoreCase ("Singapore")){
			return new SGDDollar();
		}else if(country. equalsIgnoreCase ("US")){
			return new USDollar();
		}
		throw new IllegalArgumentException("No such currency");
	}
}


interface Currency {
	String getSymbol();
}
//Concrete Rupee Class code
class Rupee implements Currency {
	public String getSymbol() {
		return "Rs";
	}
	public void rsDesc(){
		System.out.println("This is indian Rs");
	}
}


//Concrete SGD class Code
class SGDDollar implements Currency {
	public String getSymbol() {
		return "SGD";
	}
	public void sgdDesc(){
		System.out.println("This is Australian Dollar");
	}
}


//Concrete US Dollar code
class USDollar implements Currency {
	public String getSymbol() {
		return "USD";
	}
	public void usDesc(){
		System.out.println("This is US Dollar");
	}
}

/**
 * Note Two important points :
 * -Code to IF: How all currency implements common IF currency.
 * In main code using IF the actual object is obtained. and IF methods are called.
 * 
 * - Different Currency(Eg. Rupee, USDollar) codes may implement methods other than IF method (getSymbol).
 * In this case to invoke this method received object is checked against instanceof operator.
 *  
 */
 

