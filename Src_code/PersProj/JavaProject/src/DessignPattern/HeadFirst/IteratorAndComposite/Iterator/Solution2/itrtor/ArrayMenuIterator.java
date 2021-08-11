package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2.itrtor;

import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.MenuItem;
import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2.If.MyIterator;


public class ArrayMenuIterator implements MyIterator{
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

}
