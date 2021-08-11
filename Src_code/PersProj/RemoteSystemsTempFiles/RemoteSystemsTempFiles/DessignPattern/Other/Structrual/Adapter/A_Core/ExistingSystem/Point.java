package DessignPattern.Other.Structrual.Adapter.A_Core.ExistingSystem;

import DessignPattern.Other.Structrual.Adapter.A_Core.IF.Shape;

public class Point implements Shape{
	
	public void fill(){
		System.out.println("Point fill method." );
	}
	
	public void display(){
		System.out.println("Point draw method." );
	}
	public void unDisplay(){
		System.out.println("Point Erase method." );
	}
}