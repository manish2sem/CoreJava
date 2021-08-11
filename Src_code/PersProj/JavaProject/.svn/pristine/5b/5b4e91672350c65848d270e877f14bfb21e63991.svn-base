package DessignPattern.Other.Behavioral.Memento.Sample1;

public class Mainz {

	public static void main(String[] args) {
		Caretaker caretaker = new Caretaker();

		Originator originator = new Originator();
		originator.set("State1");
		originator.set("State2");
		caretaker.addMemento( originator.saveToMemento() );
		originator.set("State3");
		caretaker.addMemento( originator.saveToMemento() );
		originator.set("State4");

		originator.restoreFromMemento( caretaker.getMemento(1) );
	}

}

/**
 * Memento:
 * Captures and externalizes an object's internal state 
 * 		so that it can be restored later, all without violating encapsulation.
 * 
 * Uses:
 * 	A magic cookie that encapsulates a "check point" capability.
 *  Promote undo or rollback to full object status.
 * 
 */
