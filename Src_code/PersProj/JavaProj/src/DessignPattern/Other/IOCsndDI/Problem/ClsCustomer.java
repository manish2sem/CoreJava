package DessignPattern.Other.IOCsndDI.Problem;

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
		_address = new ClsAddress();
	}

}

class ClsAddress {
	private String street;
	private String state;
	private String countrt;
	private String zip;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountrt() {
		return countrt;
	}
	public void setCountrt(String countrt) {
		this.countrt = countrt;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
} 
