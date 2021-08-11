package CoreJava.J_Tricky.CLassObj;

public class B_TrnstvStkOverFlowErr {
	public static void main(String[] args) {
        Z z = new Z();
        System.out.println("Object created");
    }

}

/*class X{
    Z z = new Z();
}*/
 
class Y{
  //  X x = new X();
}
 
class Z{
    Y y = new Y();
}
 