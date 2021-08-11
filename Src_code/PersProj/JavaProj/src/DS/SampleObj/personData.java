package DS.SampleObj;


public class personData
{
	String name;
	public String getName() {
		return name;
	}
	
	public int age;
	public int getAge() {
		return age;
	}
	
	
	public personData(){}
	public personData(String name, int age){
		this.name=name;
		this.age = age;

	}
	
	@Override
	public boolean equals(Object obj){
		
		personData personData = (personData) obj;
		if(personData.name.equals(this.name) || personData.age == this.age){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString(){
		return this.name + ":"+ this.age +" ";
	}
	
	
}

