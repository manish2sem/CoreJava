package DS.SampleObj;

/**
 * Used at :
 * 		- DataStructure.List.linkedlist.BasicLinkedList
 * 
 *
 */

public class DataObject {

	String name;
	int id;
	int pan;
	String address;
	
	public	DataObject(String name, int id, int pan, String address){
		this.name = name;
		this.id = id;
		this.pan = pan;
		this.address = address;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPan() {
		return pan;
	}
	public void setPan(int pan) {
		this.pan = pan;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}

