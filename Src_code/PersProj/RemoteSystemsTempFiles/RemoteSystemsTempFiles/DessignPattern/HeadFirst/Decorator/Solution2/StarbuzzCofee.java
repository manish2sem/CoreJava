package DessignPattern.HeadFirst.Decorator.Solution2;

/**
 * 
 * 
 */
public class StarbuzzCofee {
	public static void main(String[] args) {
		DarkRoast darkRoast = new DarkRoast(); 
		Espresso espresso = new Espresso();
		
		darkRoast.setMilkCost(1.2f);
		darkRoast.setMochaCost(1.3f);
		
		System.out.println("Cost of DarkRoast : " +darkRoast.cost());
		System.out.println("Cost of HouseBlend : " +espresso.cost() );
		
		System.out.println("Cost of DarkRoast : " +darkRoast.hasMilk());
		System.out.println("Cost of HouseBlend : " +espresso.hasMilk());
	}

}


/**
 * Issues with this design :
 * We don't have way to order double mocha.
 * Adding new candiment will force to update Bevarage class.
 * Bevarage like iceTea does not need any candiment even though tea subclass will inherit methods like hasMilk().
 * Price change of candiments will force us to update the source code.
 * 
 */