package Java8.D_LamdaExp;

import Java8.C_functIF.Mainz;

public class AnonymousCls {
	
	A_FuctionalIF anonymousImpl = new A_FuctionalIF(){
		public void method2(int i){
			System.out.println("abstract method implemented "+i);		
		}

	};
	
	public static void main(String[] args) {
		AnonymousCls anonymousCls = new AnonymousCls();
		anonymousCls.anonymousImpl.method2(10);
	}

}
