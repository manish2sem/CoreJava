package DessignPattern.HeadFirst.Adapter.Basic;

import DessignPattern.HeadFirst.Adapter.Basic.Duck.Duck;
import DessignPattern.HeadFirst.Adapter.Basic.Turkey.Turkey;

/**
 * You are short on duck objects, so you will use turkey objects in their place.
 * 
 * Issue : 
 * 	We can't use turkey
 *  outright because they have different interface.
 * 
 * Solution :
 * 	You need to implement the interface that you are adapting to.
 */



public class TurkeyAdapter implements Duck
{
	Turkey turkey;
	
	TurkeyAdapter(Turkey turkey){
		this.turkey = turkey;
	}
	
	public void fly(){
		turkey.fly();
	}
	
	public void quack(){
		turkey.gobble();
	}
}
