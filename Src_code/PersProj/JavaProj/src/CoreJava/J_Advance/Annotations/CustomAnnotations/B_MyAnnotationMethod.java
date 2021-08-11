package CoreJava.J_Advance.Annotations.CustomAnnotations;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Target Annotation
 * 
 * You can specify which Java elements your custom annotation can be used to annotate. 
 * You do so by annotating your annotation definition with the @Target annotation. 
 * 
 *  The ElementType class contains the following possible targets:

    ElementType.ANNOTATION_TYPE - Means annotation definitions. Thus, the annotation can only be used to annotate other annotations. Like the @Target and @Retention annotations. 
    ElementType.CONSTRUCTOR
    ElementType.FIELD
    ElementType.LOCAL_VARIABLE
    ElementType.METHOD
    ElementType.PACKAGE
    ElementType.PARAMETER
    ElementType.TYPE  - The TYPE target means any type. A type is either a class, interface, enum or annotation. 

 *
 */

@Target({ElementType.METHOD})
public @interface B_MyAnnotationMethod {	
	
	    String   value();
	
}

/**
 * This annotation that can only be used to annotate methods. 
 */

