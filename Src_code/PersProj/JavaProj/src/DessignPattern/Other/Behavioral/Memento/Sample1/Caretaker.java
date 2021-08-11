package DessignPattern.Other.Behavioral.Memento.Sample1;

import java.util.ArrayList;
import java.util.List;

/**
 * The Caretaker deals with when, and why, the Originator 
 * needs to save or restore itself.
 * @author Manish
 * 
 * Contains the list of memento.
 * Any memento object can be saved into this list 
 * by calling addMemento method.
 * 
 *  Memento is a object (part of object as propety) which need to be saved
 *  during various phases of the object.
 *
 */
class Caretaker {
	private List<Memento> mementoList = new ArrayList<Memento>();

	public void addMemento(Memento m) { 
		mementoList.add(m); 
	}
	public Memento getMemento(int index) { 
		return mementoList.get(index);
	}
}   