package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.JvaBuiltinSupport;

import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem.MenuItem;
import DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2.If.MyIterator;
import java.util.Iterator;

public class MergedMenu {

	ArraylistMenu arraylistMenu;
	ArrayMenu arrayMenu;
	
	public MergedMenu(ArraylistMenu arraylistMenu,ArrayMenu arrayMenu){
		this.arraylistMenu = arraylistMenu;
		this.arrayMenu = arrayMenu;
	}
	
	public static void main (String args[]){
		ArraylistMenu arraylistMenu = new ArraylistMenu();
		ArrayMenu arrayMenu = new ArrayMenu();
		MergedMenu mergedMenu = new MergedMenu(arraylistMenu, arrayMenu);
		mergedMenu.printMenu();		
	}
	
	/** No changes after this line */
	
	public void printMenu(){
		Iterator arrayItr = arrayMenu.createIterator();
		Iterator arrayListItr = arraylistMenu.createIterator();		
		System.out.println("Array Menu --->");
		printMenu(arrayItr);
		System.out.println("Array List Menu --->");
		printMenu(arrayListItr);	
	}
	
	public void printMenu(Iterator itr){
		while(itr.hasNext()) {
			MenuItem items = (MenuItem)itr.next();
			System.out.println(items.getName());
		}		
	} 

}
