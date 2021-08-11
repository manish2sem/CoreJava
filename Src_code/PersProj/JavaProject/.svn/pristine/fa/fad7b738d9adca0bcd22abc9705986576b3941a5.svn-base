package CoreJava.J_Essential.Collection.general.comprble.Basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Sort methods of collections class is used for Sorting the specified list into ascending order.
 * Its signature is : 
 * 		public static <T extends Comparable<? super T>> void sort(List<T> list)
 * This is generic static method which says :
 *  - That argument to sort() method must be of a type List<T>
 *  Where T could be any type that implements Comparable<? super T> 
 * 	- T extends Comparable : T is anything which implements interface Comparable.
 * 	- Comparable<? super T> : type ? passed to Comparable could be T or any supertype of T
 * 
 * See the following Example : 
 * Class B doesn't implement Comparable<B> (and doesn't define it's own compareTo(B b) method). 
 * Class B inherits compareTo(A x) method from class A (we can say that it implements Comparable<A>).
 * And sort(List<B>) compiles fine, it is conforming with declaration: 
 * 	public static <B extends Comparable<? super B>> void sort(List<B> list) As
 *  public static <B extends Comparable<A>> void sort(List<B> list)
 *  Note : A = super of B.

 * @author sinhama
 * 
 * Source :
 * 		http://www.coderanch.com/t/491380/java-programmer-SCJP/certification/public-static-extends-Comparable-super
 * 
 *
 */

public class ComparableForObjNextLevel {
	public static void main(String[] args) {
		List<B> list = new ArrayList<B>();  
        list.add(new B(3));  
        list.add(new B(1));  
        list.add(new B(4));  
        list.add(new B(2));  
        Collections.sort(list); // public static <T extends Comparable<? super T>> void sort(List<T> list)   
        for( B x : list)  
            System.out.println(x);  		
	}

}


class A implements Comparable<A>
{  
    private int i;  
    A(int x){  
        i = x;  
    }  
    public int compareTo(A o) {  
        return i - o.i;  
    }  
    public String toString(){  
        return " "+i;  
    }  
}  
  
class B extends A
{  
    B(int x){  
        super(x+10);  
    }  
    // we do not override compareTo  
}  