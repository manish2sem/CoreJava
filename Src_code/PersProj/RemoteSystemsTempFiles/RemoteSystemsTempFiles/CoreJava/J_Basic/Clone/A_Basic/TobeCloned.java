package CoreJava.J_Basic.Clone.A_Basic;

/**
 * To be cloned follow the below steps:
 * 	- implements Cloneable
 * 		Otherwise checked exception CloneNotSupportedException is thrown.
 *  - Override the clone() method with public(or protected) access specifier 
 *  	So that it can be called by any other class.
 *  	Otherwise Clone method (being protected) will not available in other package.
 *  If cloned class is cloned in same package then protected is also fine.
 * @author Manish
 *
 */
public class TobeCloned implements Cloneable{

	String name;
	int id;
	
	TobeCloned(){

	}

	TobeCloned(String name, int id){
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString(){
		return this.name + this.id;
	}

	@Override
	protected  Object clone() {
		try {
			return (Object)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception");
			return null;
		}
	}

}
