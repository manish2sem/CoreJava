package TestSAG.NewLineCharacter;

public class CheckNewLineChar {

	public static void main(String[] args) {
		
		String str = new String("Ma\nnish");
		String str1 = new String("Kumar\n");
		
		System.out.print(str);
		System.out.print(str1);
		// TODO Auto-generated method stub
		
	//	String param = "\n";
	        if (str.contains("\n")){
	        	System.out.print("\n is contained");
	        }

	}

}
