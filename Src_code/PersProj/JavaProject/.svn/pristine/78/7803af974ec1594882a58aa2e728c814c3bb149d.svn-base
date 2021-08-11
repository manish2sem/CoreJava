package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2.itrtor;

import java.util.ArrayList;
import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2.If.MyIterator;
import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.MenuItem;

public class ArraylistMenuIterator implements MyIterator{
	
	ArrayList menuItems;
	int pos =0;
	public ArraylistMenuIterator(ArrayList menuItem){
		this.menuItems = menuItems;
	}
	
	public boolean hasNext(){
		if(pos >= menuItems.size()){
			return false;
		}else{
			return true;
		}
	}
	
	public Object next(){
		MenuItem item = (MenuItem)menuItems.get(++pos);
		return item;
	}

}
