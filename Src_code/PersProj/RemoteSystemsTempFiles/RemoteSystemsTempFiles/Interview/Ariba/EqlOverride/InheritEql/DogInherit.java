package Interview.Ariba.EqlOverride.InheritEql;

public class DogInherit extends AnimalInherit{
	
	String name;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DogInherit(String name) {
    	this.name = name;
    }
    
    public DogInherit() {
    	this.name = "Default";
    }

}
