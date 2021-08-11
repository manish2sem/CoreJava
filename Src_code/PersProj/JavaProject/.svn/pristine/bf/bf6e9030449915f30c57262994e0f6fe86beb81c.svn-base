package DS.linkedList.Z_GenericList;

public class Dog {
	
	String name;
	String breed;
	int id;
	

	public Dog(){}
	
	
	public Dog(String name, String breed, int id){
		this.name=name;
		this.breed = breed;
		this.id = id;

	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}




	public String getName() {
		return name;
	}
	
	
	
	@Override
	public boolean equals(Object obj){
		
		Dog dog = (Dog) obj;
		if(dog.name.equals(this.name) && dog.breed == this.breed){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return this.name + ":"+ this.breed +" ";
	}

}
