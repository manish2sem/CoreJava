package Interview.Ariba.EqlOverride.GenEql;

public class DogGen extends AnimalGen{
	
	String name;
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DogGen(String name) {
    	this.name = name;
    }
    
    public DogGen() {
    	this.name = "Default";
    }
    
    @Override
	public boolean equals(Object obj){

		if(obj !=null && obj instanceof DogGen) {
			DogGen dog = (DogGen) obj; 
			if (dog.getName().equals(this.getName())) {
				return true;
			}
		}

		return false;
	}

}
