package Interview.Ariba.EqlOverride.Z_CopmltEql;

public class Cat extends Animal{
	String name;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cat(String name) {
    	this.name = name;
    }
    
    public Cat() {
    	this.name = "Default";
    }

}
