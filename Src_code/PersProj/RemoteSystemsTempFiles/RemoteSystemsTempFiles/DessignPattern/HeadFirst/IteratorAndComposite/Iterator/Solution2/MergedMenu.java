package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2;

import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.MenuItem;
import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2.If.MyIterator;

public class MergedMenu {

	ArraylistMenu arraylistMenu;
	ArrayMenu arrayMenu;
	
	public MergedMenu(ArraylistMenu arraylistMenu,ArrayMenu arrayMenu){
		this.arraylistMenu = arraylistMenu;
		this.arrayMenu = arrayMenu;
	}
	
	public void printMenu(){
		MyIterator arrayItr = arrayMenu.createIterator();
		MyIterator arrayListItr = arraylistMenu.createIterator();		
		System.out.println("Array Menu --->");
		printMenu(arrayItr);
		System.out.println("Array List Menu --->");
		printMenu(arrayListItr);	
	}
	
	public void printMenu(MyIterator itr){
		while(itr.hasNext()) {
			MenuItem items = (MenuItem)itr.next();
			System.out.println(items.getName());
		}		
	} 

}
