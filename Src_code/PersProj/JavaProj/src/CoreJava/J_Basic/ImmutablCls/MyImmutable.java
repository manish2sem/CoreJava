package CoreJava.J_Basic.ImmutablCls;

public class MyImmutable {	
	
	public static void main(String [] args) {
		
		ImmutableClass myImutObj = new ImmutableClass(20);
		System.out.println("Value of myImutField = " +myImutObj.getMyImutField());
		
		subImmutableClass mySubImutObj = new subImmutableClass(30);
		
		System.out.println("Value of myImutField = " +myImutObj.getMyImutField());
		System.out.println("Value of mySubImutObj = " +mySubImutObj.getMyImutField());	
	}
}


class subImmutableClass extends ImmutableClass {
//	int myImutField;
	public subImmutableClass (int value){
			super(value);
	}
	
	public int getMyImutField() {
		return myImutField;
	}
	
	/*public void setMyImutField(int value) {
		myImutField = value;
	}*/
	
}

class ImmutableClass {
	
	final int  myImutField;

	public ImmutableClass (int value){
		 myImutField = value;
	}
	

	public int getMyImutField() {
		return myImutField;
	}
	
	public void setMyImutField(int value) {
		// myImutField = value; // 
		  System.out.println("Can not be set");
	}
}
