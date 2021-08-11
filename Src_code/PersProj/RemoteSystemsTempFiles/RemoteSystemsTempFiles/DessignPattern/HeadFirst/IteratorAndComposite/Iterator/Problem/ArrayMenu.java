package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem;

import java.util.ArrayList;

/**
 * Using arrayMenu maximum size of the menu can be controlled.
 * Menu Items can be retrieved without using cast.
 *
 */
public class ArrayMenu {
	final int MAX_ITEM=6;
	int noOfItems=0;
	MenuItem menuItems[];
	
	public ArrayMenu(){
		menuItems = new MenuItem[MAX_ITEM];
		addItem("Veg BLT", "Cake with scramble egg", true, 35.9);
		addItem("BLT", "Cake with fried egg", false, 29.9);
		addItem("Soup Of the day", "Cake with blueberries", true, 42.9);
		addItem("Hotdog", "waffels with blueberries", true, 37.9);
	}
	
	public void addItem(String name, String description, 
				boolean veg, double price)
	{	
		if(noOfItems >= MAX_ITEM){
			System.out.println("Menu is Full!!");
		}
		
		MenuItem menuItem = new MenuItem(name, description, veg, price);
		menuItems[noOfItems]=menuItem;
		noOfItems = noOfItems+1;
	}	
	
	
	public MenuItem[] getMenu()
	{
		return menuItems;
	}
	
	// Other menu methods

}
