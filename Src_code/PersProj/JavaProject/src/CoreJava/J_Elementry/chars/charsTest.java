package CoreJava.J_Elementry.chars;

public class charsTest {
	char chars[]={'a','"','\"','\'',',','\\','/','\n','\t'};
	char j=100;
	
	public static void main(String args[]){
		
		charsTest chart = new charsTest();
		for(int i=0; i<chart.chars.length;i++){
		
			System.out.println(chart.chars[i]);
			int j = chart.chars[i];
			System.out.println(j);
			
		}
		System.out.println("char 2 int : "+chart.j);
	//	
	}

}
