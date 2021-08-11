package Interview.Ariba.EqlOverride.Z_CopmltEql;

public class Dog extends Animal{
	
	String name;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dog(String name) {
    	this.name = name;
    }
    
    public Dog() {
    	this.name = "Default";
    }

}
