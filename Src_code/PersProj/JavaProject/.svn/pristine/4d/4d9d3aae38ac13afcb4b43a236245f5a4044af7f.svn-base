package DessignPattern.Other.singalton.fiveton;

import java.util.ArrayList;
//Huwaei

public class Fiveton {
	public static int count;
	static ArrayList list=new ArrayList();
	
	static {
		count=0;
	}
	private Fiveton(){
		//count++;
	}
	
	public static Fiveton getInstance(){
		
		Fiveton fiveton;
		if (count<5){
			fiveton=new Fiveton();
			list.add(count,fiveton);
			count++;
			return fiveton;		
		
		}else {
			fiveton = (Fiveton)list.get(count%5);
			count++;
			return fiveton;
		}
		
		
	}

}
