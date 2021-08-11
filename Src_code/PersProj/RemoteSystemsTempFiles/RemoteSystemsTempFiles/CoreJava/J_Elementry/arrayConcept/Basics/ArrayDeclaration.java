package CoreJava.J_Elementry.arrayConcept.Basics;

/**
 * @author Manish
 * 
 * Arrays can hold primitives or objects, but the array itself is always an object on the heap.
 * 
 * It is illegal to include the size of an array in the declaration.
 * 
 * An array of objects can hold any object that passes the IS-A (or instanceof) 
 * test for the declared type of the array.
 *
 */
public class ArrayDeclaration {
	public static void main(String args[]){
		
		int myArray[]= new int[10];
		Object objArray10[]= new Object[10];
		String strArray[]= new String[10];


//		int myArray1[]= new int[]; // size is must
//		int myArray2[10]= new int[]; //
		int[] myArray3= new int[10];
		int[] myArray4[]= new int [10][10]; // perfectly valid
		int myarray5[]={1,2,3,4};
		
		Animal objArray[]=new Animal[5];
		for(int i=0; i<objArray.length; i++){
			System.out.print("   ObjArray : "+objArray[i]);
		}
		System.out.println();
		Animal objArray1[]={new Animal(),new Dog(),new Animal(),new Dog(),};
		Dog dog;
		Animal animal;
		for (int i=0; i<objArray1.length;i++){
			if(objArray1[i] instanceof Animal){
				animal = (Animal)objArray1[i];
				animal.eat();
			}else if(objArray1[i] instanceof Dog){
				dog = (Dog)objArray1[i];
				dog.eat();
			}else{
				System.out.println("Not an animal");
			}
		}		
	}
}

class Animal{
	void eat(){
		System.out.println("Generic Eat");
	}
}

class Dog extends Animal{
	void eat(){
		System.out.println("Dog Eat");
	}
	
}
