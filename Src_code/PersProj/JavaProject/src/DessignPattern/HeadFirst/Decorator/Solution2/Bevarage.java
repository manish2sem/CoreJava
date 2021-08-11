package DessignPattern.HeadFirst.Decorator.Solution2;

/**
 * 
 *
 */

public class Bevarage {
	private float milkCost = 0.0f;
	private float mochaCost = 0.0f;

	private boolean milk = false ;
	private boolean mocha = false;
	
	/*public void setMilk(boolean milk) {
		this.milk = milk;
	}

	public void setMocha(boolean mocha) {
		this.mocha = mocha;
	}
*/
	

	public boolean hasMilk() {
		return milk;
	}

	public boolean hasMocha() {
		return mocha;
	}

	String description;

	public String getDescription() {
		return description;
	}
	public float getMilkCost() {
		return milkCost;
	}
	public void setMilkCost(float milk) {
		this.milkCost = milk;
		this.milk = true;
	}
	public float getMochaCost() {
		return mochaCost;
	}
	public void setMochaCost(float mocha) {
		this.mochaCost = mocha;
		this.mocha = true;
	}
	
	
	float cost(){
		float CandimentsCost = 0.0f;

		if(hasMilk()) {
			CandimentsCost += milkCost;
		}

		if(hasMocha()) {
			CandimentsCost += mochaCost;
		}

		return CandimentsCost;
	}
}

/**
 * Issues with this design :
 * We don't have way to order double mocha.
 * Adding new candiment will force to update the class.
 * 
 */
