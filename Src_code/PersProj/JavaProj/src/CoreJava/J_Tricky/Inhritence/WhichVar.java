package CoreJava.J_Tricky.Inhritence;

public class WhichVar extends absCls implements interfaceA{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WhichVar whichVar = new WhichVar();
		System.out.println("Which var " +whichVar.i);
	}

}

interface interfaceA {
	int i = 10;
}


class absCls {
	int i = 20;
}
