package CoreJava.J_Essential.Collection.SampleObj;

/**
 * Remember that when you use a class that implements Map, 
 * any classes that you use as a part of the keys for that map must override the hashCode() and equals() methods.
 * you only have to override them if you're interested in retrieving stuff from your Map. 
 * Seriously, it's legal to use a class that doesn't override equals() and hashCode() as a key in a Map;
 * your code will compile and run, you just won't find your stuff.
 *
 */

public class HashedDog extends Animal{
	
	public HashedDog (String name) {
		super(name);
	}

	
	public boolean equals(Object o)
	{
		if((o instanceof HashedDog) && (((HashedDog)o).name == name)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
		
	public int hashCode() 
	{
		return name.length(); 
	}

}
