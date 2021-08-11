package Interview.Ariba.EqlOverride.GenEql;

/**
 * Two Animal objects are equal iff their name or name-length is equal.
 * but if they are of different object type then they will not equal.
 * like dog object will not equal to cat object.
 * @author sinhama
 *
 */

public class AnimalGen {
	String name;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnimalGen(String name) {
    	this.name = name;
    }
    
    public AnimalGen() {
    	this.name = "Default";
    }
    
    @Override
    public boolean equals(Object obj){
    	if(obj instanceof AnimalGen) {
    		AnimalGen animal = (AnimalGen) obj;    		 
    		
    		 if (animal.getName().equals(this.getName())) {
    			 return true;
    		 }
    		 
    		
    		 
    		 return false;
    	}
       
    	return false;
    }
}
