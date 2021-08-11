package DessignPattern.Other.IOCsndDI.DependencyInj.ServiceLocator;

import DessignPattern.Other.IOCsndDI.ClsAddress;

/**
 * Issues :
 * 	 - the code is tightly coupled between classes. 
 * 		customer class controls the creation of address object.
 * 		the customer class depends on the address object. 
 * 		So for any reason address class changes it will lead to change and compiling of ClsCustomer class also. * 
 *  - Address class is directly referenced in the customer class which leads to tight coupling between address and customer objects.
 *  - Customer class is aware of the address class type. 
 *  	So if we add new address types like home address, office address it will lead to changes in the customer class also as 
 *  	customer class is exposed to the actual address implementation.
 *  
 *  Solution (Inversion of control):
 *   Shifting the object creation control from the customer class to some one else. 
 *   The main problem roots from the customer class creating the address object. 
 *   If we are able to invert this control to a third party we have found our solution. 
 *   
 */

public class ClsCustomer {
	
	private ClsAddress _address;
	
	public ClsCustomer() {
		_address = LocateAddress.getAddress();
	}

}

class LocateAddress {
	public static ClsAddress getAddress() {
		return ;
	}
}

