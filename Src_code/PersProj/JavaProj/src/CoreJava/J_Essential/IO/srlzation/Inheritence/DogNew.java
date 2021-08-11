package CoreJava.J_Essential.IO.srlzation.Inheritence;


/**
 * 
 * Remember, when an object is constructed using new, the following things happen (in this order): 
 *  - All instance variables are assigned default values. 
 *  - The constructor is invoked, which immediately invokes the superclass constructor 
 *  	(or another overloaded constructor, until one of the overloaded constructors invokes the superclass constructor). 
 *  - All superclass constructors complete. 
 *  - Instance variables that are initialized as part of their declaration are assigned their initial value through constructor.
 *  	(as opposed to the default values they’re given prior to the superclass constructors completing). 
 *  - The constructor completes. 
 */
 

public class DogNew extends AnimalNew {
	//String name;  //-> this declaration doesn't matter.
	DogNew(int w, String n) {
		super(13);
		weight = w; // inherited
		name = n; // not inherited if name is declared here.
	}
	
	public static void main(String[] args) {
		AnimalNew anml = new AnimalNew();
		System.out.println("Constructing Animal : " );
		System.out.println("anml Name : " + anml.name);
		System.out.println("anml Weight : " +anml.weight);
		System.out.println("anml lingth : " + anml.length);
		
		System.out.println("Constructing NewDog : " );
		DogNew newDog = new DogNew(10, "jimmy");
		System.out.println("Dog Name : " + newDog.name);
		System.out.println("Dog Weight : " +newDog.weight);
		System.out.println("Dog Weight : " +newDog.length);
		
		System.out.println("anml Name : " + anml.name);
		System.out.println("anml Weight : " +anml.weight);
		System.out.println("anml lingth : " + anml.length);
		
		
		AnimalNew newAnml = new AnimalNew(15, "Rocket");
		System.out.println("new anml Name : " + newAnml.name);
		System.out.println("new anml Weight : " +newAnml.weight);
		System.out.println("new anml lingth : " + newAnml.length);
		
	}
}

class AnimalNew { // not serializable !
	public int weight = 42;
	public int length;
	String name = "pluto";
	
	AnimalNew(int w) {
		weight = w;		
	}
	
	AnimalNew(int w, String n) {
		weight = w;
		name = n;
	}
	
	AnimalNew(){
		
	}	
}

/**
 * 
 */
