package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.JvaBuiltinSupport.itrtor;

import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.MenuItem;
import java.util.Iterator;

/**
 * Using built-in Java Iterator Interface.
 * 		This will give us lot of leverage.
 *
 *Java iterator interface is exactly same as MyIteraor except an additional function - remove()
 *
 *ArrayList has an iterator() method that returns an iterator.
 *We still need implementation for ArrayMenu as Array doesn't support the Iterator() method.
 */


public class ArrayMenuIterator implements Iterator{
	MenuItem[] menuItems;
	int pos =0;
	
	public ArrayMenuIterator(MenuItem[] menuItem){
		this.menuItems = menuItems;
	}

	public boolean hasNext(){
		System.out.println(menuItems.length);
		if(pos >= menuItems.length || menuItems[pos] == null){
			return false;
		}else{
			return true;
		}
	}

	public Object next(){
		MenuItem item = menuItems[pos];
		pos++;
		return menuItems[pos];
	}
	
	public void remove() {
		
		if(pos <= 0) {
			throw new IllegalStateException("You can't remove item without doing next.");
		}
		
	}

}
