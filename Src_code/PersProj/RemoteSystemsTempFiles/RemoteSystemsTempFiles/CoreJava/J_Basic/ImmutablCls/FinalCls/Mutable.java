package CoreJava.J_Basic.ImmutablCls.FinalCls;

/**
 * 
 * http://stackoverflow.com/questions/12306651/why-would-one-declare-an-immutable-class-final-in-java
 * 
 * Note, Here class Immutable is actually Immutable 
 * There is no way to break it's immutability.
 * 
 * 
 * 
 * But extending this class by any mutable class we can playing around with Mutable class object, not Immutable class object
 * 
 * @author Manish
 *
 */

public class Mutable extends Immutable {
    private int realValue;

    public Mutable(int value) {
        super(value);

        realValue = value;
    }

    public int getValue() {
        return realValue;
    }
    public void setValue(int newValue) {
        realValue = newValue;
    }

   public static void main(String[] arg){
       Mutable obj = new Mutable(4);
       Immutable immObj = (Immutable)obj;              
       System.out.println(immObj.getValue());
       obj.setValue(8);
       System.out.println(immObj.getValue());
   }
}