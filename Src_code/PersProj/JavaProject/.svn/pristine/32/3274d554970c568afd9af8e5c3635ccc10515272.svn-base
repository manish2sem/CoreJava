package CoreJava.J_Importent.ClassLoder.A_Basics;

/**
 * When Class is loaded in Java?
Class loading is done by ClassLoaders in Java which can be implemented to eagerly load a class as soon as another class references it or
lazy load the class until a need of class initialization occurs. 

If Class is loaded before its actually being used it can sit inside before being initialized. This may vary from JVM to JVM. 
While its guaranteed by JLS that a class will be loaded when there is a need of static initialization.

When a Class is initialized in Java
After class loading, initialization of class takes place which means initializing all static members of class. A Class is initialized in Java when :

1) an Instance of class is created using either new() keyword or using reflection using class.forName(), which may throw ClassNotFoundException in Java.

2) an static method of Class is invoked.
3) an static field of Class is assigned.
4) an static field of class is used which is not a constant variable.
5) if Class is a top level class and an assert statement lexically nested within class is executed.


*
 * http://javarevisited.blogspot.in/2012/07/when-class-loading-initialization-java-example.html
 * http://stackoverflow.com/questions/7560721/when-does-the-jvm-load-classes
 */

public class AA_Classloading {
	
	public static Something something = null; // (1) does not cause class loading
    public static Class<?> somethingClass = Something.class; // (2) causes class loading

    public void doSomething() {
        new Something(); // (3) causes class loading
    }

}


class Something{
	public void createSomething() {
	    new Something();
	  }
}
