package DessignPattern.HeadFirst.Strategy.Solution4;


public class ScalableSystem {
	public static void main(String[] args) {
		RocketDuck rocketDuck = new RocketDuck();
		DuckHunter duckHunter = new DuckHunter();
		rocketDuck.Display();
		rocketDuck.fly();
		rocketDuck.performQuack();
		
		duckHunter.Display();
		duckHunter.performQuack();	
		
	}	
}
