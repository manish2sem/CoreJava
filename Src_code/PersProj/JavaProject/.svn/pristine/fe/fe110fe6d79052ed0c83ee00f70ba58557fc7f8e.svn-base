package DessignPattern.HeadFirst.Adapter.Basic;

import DessignPattern.HeadFirst.Adapter.Basic.Duck.MallardDuck;
import DessignPattern.HeadFirst.Adapter.Basic.Turkey.WildTurkey;

public class DuckAdapterMainz {
	
	public static void main(String[] args) {
		MallardDuck mallardDuck = new MallardDuck();
		
		WildTurkey wildTurkey = new WildTurkey();
		
		TurkeyAdapter TurkeyAdapter = new TurkeyAdapter(wildTurkey);
		TurkeyAdapter.fly();
		TurkeyAdapter.quack();
	}

}
