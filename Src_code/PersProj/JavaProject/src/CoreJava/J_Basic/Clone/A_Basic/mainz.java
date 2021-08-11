package CoreJava.J_Basic.Clone.A_Basic;

public class mainz {
	public static void main(String[] args) {
		TobeCloned tobeCloned = new TobeCloned("Manish", 833544);
		TobeCloned cloned = (TobeCloned) tobeCloned.clone();
		System.out.println("Cloned " + cloned.name);

	}
	
}
