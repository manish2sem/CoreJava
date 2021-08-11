package DessignPattern.Other.Structrual.Adapter.A_Core.ExistingSystem;

import DessignPattern.Other.Structrual.Adapter.A_Core.IF.Shape;

public class Square implements Shape{
	
	public void fill(){
		System.out.println("Square fill method." );
	}	
	public void display(){
		System.out.println("Square draw method." );
	}
	public void unDisplay(){
		System.out.println("Square Erase method." );
	}
}