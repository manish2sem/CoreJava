package CoreJava.J_Advance.Annotations.CustomAnnotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * You can specify for your custom annotation if it should be available at runtime, for inspection via reflection. 
 * You do so by annotating your annotation definition with the @Retention annotation.
 * 
 * RetentionPolicy has three major properties:
 *  - RUNTIME: When the retention value is ‘Runtime’ this annotation will be available in JVM at runtime. 
 *  			We can write custom code using reflection package CoreJava.and parse the annotation.
 *  - CLASS: When value is given as ‘class’ then this annotation will be compiled and included in the class file, but not available at runtime.
 *   		This is the default retention policy, if you do not specify any retention policy at all. 
 *  - SOURCE: This annotation will be removed at compile time and will not be available at compiled class.
 *  		If you create your own annotations for use with build tools that scan the code, you can use this retention policy. That way the .class files are not poluted unnecessarily.

 *  
 * @author sinhama
 *
 */

@Retention(RetentionPolicy.RUNTIME)

public @interface C_MyAnnotationRetention {
	String   value() default "";
}
