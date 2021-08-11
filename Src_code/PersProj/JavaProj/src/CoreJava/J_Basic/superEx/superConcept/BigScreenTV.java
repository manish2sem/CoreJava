package CoreJava.J_Basic.superEx.superConcept;
/**
 * @author Manish
 * 
 * the compiler generates a default constructor for any class that does not explicitly declare a constructor. 
 * 
 * The default constructor does not contain any statements, this is only partially true. 
 * Because the default constructor is a constructor that does not invoke this() or super(),
 * the compiler adds a call to super() for you.
 * 
 * compiler added super(), causing the no-argument constructor in parent/Object to be invoked.
 * 
 * This BigScreenTV class will not compile for the Television class that did not include a noargument constructor.
 * The BigScreenTV default constructor does not work in this situation.
 * To make them compile any of following is required :
 * 1.)  add no argument constructor in Television  Or
 * 2.)  Call the super inside constructor of BigScreenTV with arguments matched in constructor of Television 
 *  
 */
public class BigScreenTV extends Television {
	
	public String aspectRatio;
	public short size;
	/*public BigScreenTV(){
		super();
	//In case of default construcctor, compiler would generate and add	similar to this. 
	}*/
	
}

class Television{
	public int channel, volume;
	public Television(int a){
		this(4,5);
		System.out.println("Inside Television()");
	}
	
	/*public Television(){
		//this(4,5);
		System.out.println("Inside Television()");
	}*/
	
	public Television(int c, int v){
		System.out.println("Inside Television(int, int)");
		channel = c;
		volume = v;
	}
	
}
