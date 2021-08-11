package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2;

import java.util.ArrayList;

import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.MenuItem;
import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2.If.MyIterator;
import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2.itrtor.ArraylistMenuIterator;


/**
 * Arraylist menu are easily expendable.
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
	
	/*public ArrayList getMenu(){
		return menu;
	}*/
	
	public MyIterator createIterator(){
		return new ArraylistMenuIterator(menu);
	}
	// Other menu methods

}
