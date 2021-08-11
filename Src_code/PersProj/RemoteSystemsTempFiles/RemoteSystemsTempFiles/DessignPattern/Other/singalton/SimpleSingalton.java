package DessignPattern.Other.singalton;



/**
 * @author Manish
 * Points to be noted regarding SimpleSingalton
 * 1.)SimpleSingalton can not be subclassed because constructor is private
 * 2.) SimpleSingalton is not thread safe
 * 3.) if SimpleSingalton implements Serializable interface, then class instance
 *  can be Serialized and deserialized more than once to beating the purpose of singalton. 
 *4.) Through different class loaders multiple instances can be obtained
 *5.) using clone method of object it is possible to create clone of SimpleSingalton iff 
 *		SimpleSingalton extends class that support cloning
 *0
 */
public class SimpleSingalton {
	
	/**
	 * here ClassicStatic is declared as static because 
	 * it is used inside static method getInstance() 
	 * count will keep track of ClassicSingalton object as global variable.
	 */
	public static SimpleSingalton count = null;
	
	
	/*
	public ClassicSingalton ClassicSingalton(){
		if (count==null){
			count=new ClassicSingalton();
		}	
		return count;	//invalid
	}
	*/
	/**
	 * Interesting try but constructor can not have return type
	 *  so object or null can not be returned.
	 * 
	 */
	
	private SimpleSingalton(){
		// now instance of ClassicSingalton canton be ceated using 
		//ClassicSingalton ins3=new ClassicSingalton();
	}
	
	/**notice the static declaration of getInstance
	 * It is because inside class SingaltonObjTest is 
	 * used for creating instance without creating the 
	 * instance of classicSingalton
	 * @return
	 */
	public static SimpleSingalton getInstance(){
		
		if (count==null){
			count=new SimpleSingalton();
		}		
		
		return count;
	}
	
	public void outpt(){
		System.out.println("inside output : ");
		System.out.println("count : "+ count);
	}

}
