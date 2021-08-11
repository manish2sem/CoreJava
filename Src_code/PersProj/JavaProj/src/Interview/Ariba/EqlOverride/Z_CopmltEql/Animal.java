package Interview.Ariba.EqlOverride.Z_CopmltEql;

/**
 * Two Animal objects are equal iff their name or name-length is equal.
 * but if they are of different object type then they will not equal.
 * like dog object will not equal to cat object.
 * @author sinhama
 *
 */

public class Animal {
	String name;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal(String name) {
    	this.name = name;
    }
    
    public Animal() {
    	this.name = "Default";
    }
    
    @Override
    public boolean equals(Object obj){
    	// System.out.println(obj.getClass());
    	// System.out.println(this.getClass());
    	if(obj instanceof Animal) {
    		 Animal animal = (Animal) obj;
    		 
    		// System.out.println(animal.getClass());
    		 
    		 if(animal.getClass() != this.getClass()){
    			 return false;
    		 }
    		 if (animal.getName().equals(this.getName())) {
    			 return true;
    		 }
    		 
    		 if (animal.getName().length()== this.getName().length()) {
    			 return true;
    		 }
    		 
    		 return false;
    	}
       
    	return false;
    }
}
