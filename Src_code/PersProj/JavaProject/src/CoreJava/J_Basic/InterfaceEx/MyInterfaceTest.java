package CoreJava.J_Basic.InterfaceEx;

public class MyInterfaceTest implements MyIf{
	
	private MyIf target;
	
	public void fill(){
		if (target!=null) {
			target.fill();
		}
	};
	public void display(){};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub= new 
		MyInterfaceTest MyInterfaceTest = new MyInterfaceTest();
		System.out.print("Implemented interface");

	}
}

interface MyIf {
	public void fill();
	public abstract void display();

}

