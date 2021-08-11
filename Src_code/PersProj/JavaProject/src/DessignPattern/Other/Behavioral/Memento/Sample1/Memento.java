package DessignPattern.Other.Behavioral.Memento.Sample1;

/**
 * Memento contains state of an object to be restored.
 * @author Manish
 *
 */
class Memento {
	private String state;

	public Memento(String stateToSave) { 
		state = stateToSave; 
	}
	public String getSavedState() { 
		return state; 
	}
}