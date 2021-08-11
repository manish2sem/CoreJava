package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution1;

/**
 * Issue with following solution : * 
 * 	- That requires retrieving all the items of both menus.
 * 	- code duplication : two separate loop to iterate over two different kind of menu.
 * 	- Maintenance problem : if we add third menu(or ArrayMenu to other type of menu) lot of code will be changed.
 * 	- coding to concrete implementation(arrayList menu and ArrayMenu) not interface
 * 
 * 
 */

import java.util.ArrayList;

import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.MenuItem;

import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.ArrayMenu;
import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.ArraylistMenu;

public class MergedMenuWithoutHead {
	
	ArraylistMenu arraylistMenu;
	ArrayMenu arrayMenu;
	
	public MergedMenuWithoutHead(){
		arraylistMenu = new ArraylistMenu();
		arrayMenu = new ArrayMenu();
	}
	
	public static void main (String args[]){
		MergedMenuWithoutHead mergedMenu = new MergedMenuWithoutHead();
		mergedMenu.printMenu();
		mergedMenu.printArraylistMenu();
		mergedMenu.printArrayMenu();
		mergedMenu.printVegItem();		
	}
	
	public void printMenu(){
		printArraylistMenu();
		printArrayMenu();		
	} 
	
	public void printArraylistMenu()
	{
		System.out.println("ArrayList Menus ->");
		ArrayList arraylistMenuItems = arraylistMenu.getMenu();
		for(int i=0; i<arraylistMenuItems.size(); i++)
		{
			System.out.println(((MenuItem) (arraylistMenuItems.get(i))).getName());
		}		
	}
	
	public void printArrayMenu()
	{
		System.out.println("Array Menus ->");
		MenuItem[] arrayMenuItems = arrayMenu.getMenu();
	
		for(int i=0; i<arrayMenuItems.length; i++) {
			if(arrayMenuItems[i]!=null){
				System.out.println(arrayMenuItems[i].getName());
			}
		}		
	} 
	
	public void  printVegItem(){
		
		System.out.println("Veg Items ->");
		ArrayList arraylistMenuItems = arraylistMenu.getMenu();
		for(int i=0; i<arraylistMenuItems.size(); i++){
			if(((MenuItem) (arraylistMenuItems.get(i))).isVeg()){
				System.out.println(((MenuItem) (arraylistMenuItems.get(i))).getName());
			}
		}	
		
		MenuItem[] arrayMenuItems = arrayMenu.getMenu();	
		for(int i=0; i<arrayMenuItems.length; i++) {
			if(arrayMenuItems[i]!=null && arrayMenuItems[i].isVeg()){
				System.out.println(arrayMenuItems[i].getName());
			}
		}
		
	}
	
	public boolean isItemVeg(String itemName) {
		
		return false;
	}  

}
