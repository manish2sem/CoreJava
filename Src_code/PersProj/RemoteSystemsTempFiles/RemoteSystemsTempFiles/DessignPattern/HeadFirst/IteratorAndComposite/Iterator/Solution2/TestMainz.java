package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Solution2;

public class TestMainz {
	
	public static void main (String args[]){
		ArraylistMenu arraylistMenu = new ArraylistMenu();
		ArrayMenu arrayMenu = new ArrayMenu();
		MergedMenu mergedMenu = new MergedMenu(arraylistMenu, arrayMenu);
		mergedMenu.printMenu();		
	}

}
