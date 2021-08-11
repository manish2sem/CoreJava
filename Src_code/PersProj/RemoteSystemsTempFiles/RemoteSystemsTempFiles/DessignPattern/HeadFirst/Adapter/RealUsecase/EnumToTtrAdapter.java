package DessignPattern.HeadFirst.Adapter.RealUsecase;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * This adaptor is for all legacy classes which still producing Enumerations.
 * @author sinhama
 *
 */

public class EnumToTtrAdapter implements Iterator{
	
	Enumeration enm;
	
	public EnumToTtrAdapter(Enumeration enm){ 
		this.enm = enm;
	}
	
	public Object next(){
		return enm.nextElement();
	}
	
	public boolean hasNext(){
		
		return enm.hasMoreElements();
	}
	
	/**
	 * This method is not supported by Enumeration.
	 * so we need to giveup by throwing the Exception.
	 */
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
	

}
