package DessignPattern.Other.Behavioral.Memento.Sample1;

/**
 * The Originator is the object that knows how to save itself.
 * 	 i.e. the class that you want to make stateful.
 * 
 * Saving the class means saving it's states.
 * 
 * How - Set the state/staes into memento object. 
 * 		Save the memento object into list/stack etc.
 * 			This is accomplish by caretaker.
 * @author Manish
 *
 */
class Originator {
	   private String state;
	   /* lots of memory consumptive private data that is not necessary to define the 
	    * state and should thus not be saved. Hence the small memento object. */

	   public void set(String state) { 
	       System.out.println("Originator: Setting state to "+state);
	       this.state = state; 
	   }

	   public Memento saveToMemento() { 
	       System.out.println("Originator: Saving to Memento.");
	       return new Memento(state); 
	   }
	   public void restoreFromMemento(Memento m) {
	       state = m.getSavedState(); 
	       System.out.println("Originator: State after restoring from Memento: "+state);
	   }
	}   