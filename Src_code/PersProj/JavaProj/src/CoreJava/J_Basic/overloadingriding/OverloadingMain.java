package CoreJava.J_Basic.overloadingriding;

public class OverloadingMain extends ContainingMain{
	public static void main(String [] args) {
		System.out.println("OverloadingMain");
		
		OverloadingMain overloadingMain = new OverloadingMain();
		//overloadingMain.main(new String[] {"", ""});
		//ContainingMain containingMain = new ContainingMain();
	}

}

abstract class  ContainingMain{
	public static void main(String [] args) {
		System.out.println("ContainingMain");
	}
	
}
