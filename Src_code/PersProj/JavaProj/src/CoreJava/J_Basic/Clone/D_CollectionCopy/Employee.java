package CoreJava.J_Basic.Clone.D_CollectionCopy;

class Employee implements Cloneable{
	private String name;
	private String designation;
	
	public Employee(String name, String designation) {
		this.name = name;
		this.designation = designation;
	} 
	
	public String getDesignation() {
		return designation;
	} 
	
	public void setDesignation(String designation) {
		this.designation = designation;
	} 
	
	public String getName() {
		return name;
	} 
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override public String toString() {
		return String.format("%s: %s", name, designation );
	} 
	
	@Override
    protected Employee clone() {
        Employee clone = null;
        try{
            clone = (Employee) super.clone();
           
        }catch(CloneNotSupportedException e){
            throw new RuntimeException(e); // won't happen
        }
       
        return clone;
       
    }

}

