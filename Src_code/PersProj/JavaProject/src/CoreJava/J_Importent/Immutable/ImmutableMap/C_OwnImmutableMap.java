package CoreJava.J_Importent.Immutable.ImmutableMap;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * OwnImmutableMap implemetsMap - Programming to the interface.
 * Now client map(passed to this tobecome immutable) and returned map both are of same IF.
 * Again Since Map is abstract we are forced to implement all the Map methods keeping immutablenaess in mind.
 * 
 *  The constructor takes one argument which need to be made immutable.
 *  we have one static method[getImmutableMap] which actually returns immutable map. 
 * @author sinhama
 *
 */

public class C_OwnImmutableMap implements Map{
	
	private final Map m;
	
	public C_OwnImmutableMap(Map m){
		 this.m = m;
	}
	
	
	public static Map getImmutableMap(Map m) {
		return new C_OwnImmutableMap(m);
	}

	public void clear() {
		throw new UnsupportedOperationException();
	}

	public boolean containsKey(Object key) {
		return m.containsKey(key);		
	}

	public boolean containsValue(Object value) {
		return m.containsValue(value);
	}

	public Set entrySet() {
		return m.entrySet();
	}

	public Object get(Object key) {
		// TODO Auto-generated method stub
		return m.get(key);
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return m.isEmpty();
	}

	public Set keySet() {
		// TODO Auto-generated method stub
		return m.keySet();
	}

	public Object put(Object key, Object value) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	public void putAll(Map t) {
		throw new UnsupportedOperationException();
		
	}

	public Object remove(Object key) {
		throw new UnsupportedOperationException();
	}

	public int size() {
		return m.size();	

	}

	public Collection values() {
		return m.values();
	}

}
