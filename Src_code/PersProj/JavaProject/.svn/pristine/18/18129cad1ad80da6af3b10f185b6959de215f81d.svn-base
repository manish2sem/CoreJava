package CoreJava.J_Importent.CallBack.Concept;

/**
 * The idea behind CallBack pattern is the inversion of control (abbreviated IoC). 
 * This paradigma describes the way frameworks work. It is also known as the "Hollywood principle - Don't call me, we will call you"
 *
 */

public class Caller {
	public void register(CallBackIF callback) {
        callback.methodToCallBack();
    }

    public static void main(String[] args) {
        Caller caller = new Caller();
        CallBackIF callBack = new CallBackImpl();
        caller.register(callBack);
        
        //direct calling
        callBack.methodToCallBack();
    }
}


/**
 * Difference between calling directly callback.methodToCallBack() to callBack?
 * This example just shows to you how to construct such a callBack function when working in a java environment. 
 * Let's get a little deeper into a concrete useful example now.
 * 
 */
