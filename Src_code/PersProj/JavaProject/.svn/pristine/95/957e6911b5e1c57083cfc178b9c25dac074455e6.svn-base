package CoreJava.J_Advance.Annotations.CustomAnnotations;

/**
 * Annotations are defined in their own file, just like a Java class or interface.
 * 
 * This example defines an annotation which has four elements. 
 * 
 * Each element is defined similarly to a method definition in an interface. It has a data type and a name.
 * You can use all primitive data types and arrays as element data types. 
 * You cannot use complex objects as data type. 
 * 
 * You can specify default values for an element. 
 * That way the element becomes optional and can be left out while using the annotation.
 * 
 * If an annotation have only one element, then that element should be named value.
 * @author sinhama
 *
 */


public @interface A_MyAnnotation {
	String   value() default "default value";
    String   name() default "Another default value";
    int      age(); 
    String[] newNames();
}
