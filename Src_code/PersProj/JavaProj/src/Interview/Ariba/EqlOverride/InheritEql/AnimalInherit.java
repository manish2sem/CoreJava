package Interview.Ariba.EqlOverride.InheritEql;

/**
 * Two Animal objects are equal iff their name or name-length is equal.
 * Even if they are of different object type but inherited from same parent 
 * they will equal if above condition holds true.
 * like dog object will equal to cat object if their name are same.
 * @author sinhama
 *
 */

public class AnimalInherit {
	String name;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnimalInherit(String name) {
    	this.name = name;
    }
    
    public AnimalInherit() {
    	this.name = "Default";
    }
    
    @Override
    public boolean equals(Object obj){
    	if(obj instanceof AnimalInherit) {
    		AnimalInherit animal = (AnimalInherit) obj;
    		 
    		 /*if(animal.getClass() != this.getClass()){
    			 return false;
    		 }*/
    		 if (animal.getName().equals(this.getName())) {
    			 return true;
    		 }
    		/* 
    		 if (animal.getName().length()== this.getName().length()) {
    			 return true;
    		 }*/
    		 
    		 return false;
    	}
       
    	return false;
    }
}
