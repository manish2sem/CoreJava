package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.JvaBuiltinSupport;

import java.util.ArrayList;
import java.util.Iterator;

import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.MenuItem;


/**
 * We are going to use java Iterator instead of using our own iterator as in solution2.
 * 
 * In case of arrayList menu the changes are
 * 	deleting ArraylistMenuIterator class.
 *  createIterator returns ArrayList.iterator() instead of using ArraylistMenuIterator. 
 *  
 *  Thats it!!!
 * 		
 * 
 */
public class ArraylistMenu {
	ArrayList menu;
	public ArraylistMenu(){
		menu = new ArrayList();
		addItem("PanCake Breakfast", "Cake with scramble egg", true, 45.9);
		addItem("Regular PanCake Breakfast", "Cake with fried egg", false, 39.9);
		addItem("bluebery pancake", "Cake with blueberries", true, 25.9);
		addItem("waffels", "waffels with blueberries", true, 45.9);
	}	
	
	public void addItem(String name, String description, 
					boolean veg, double price){		
		MenuItem menuItem = new MenuItem(name, description, veg, price);
		menu.add(menuItem);
	}
	
	/*public MyIterator createIterator(){
		return new ArraylistMenuIterator(menu);
	}*/
	
	public Iterator createIterator(){
		return menu.iterator();
	}
	// Other menu methods

}
