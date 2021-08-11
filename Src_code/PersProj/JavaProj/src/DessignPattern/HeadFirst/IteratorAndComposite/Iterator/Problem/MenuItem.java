package DessignPattern.HeadFirst.IteratorAndComposite.Iterator.Problem;

/**
 * Problem Statement :
 * Using existing code(i.e. without changing them) of ArrayMenu and AyyayListMenu 
 * you need to implement following functionality :
 * 		printMenu() : Prints menu items of both the menus.
		printArraylistMenu() : Prints menu items of ArrayList menu.
		printArrayMenu() : Prints menu items of Array menu.
		printVegItem() : Prints all veg items from both menus.
 * 
 * 
 * Challenges:
 * Two different menu representation have following complications :
 * 		Implementing a code which uses both the menus.
 * 		That requires retrieving all the items of both menus.
 * 		code duplication : two separate loop to iterate over two different kind of menu.
 * 		Maintenance problem : if we add third menu(or ArrayMenu to other type of menu) lot of code will be changed.
 * 		coding to concrete implementation(arrayList menu and ArrayMenu) not interface
 *
 */
public class MenuItem {
	String name;
	String description;
	boolean veg;
	double price;
	
	public MenuItem(String name, String description, 
					boolean veg, double price){
		this.name = name;
		this.description = description;
		this.veg = veg;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isVeg() {
		return veg;
	}

	public double getPrice() {
		return price;
	}

}
