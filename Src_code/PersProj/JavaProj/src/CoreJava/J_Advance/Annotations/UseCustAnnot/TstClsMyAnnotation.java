package CoreJava.J_Advance.Annotations.UseCustAnnot;

import CoreJava.J_Advance.Annotations.CustomAnnotations.A_MyAnnotation;
/**
 * All the element/fields of annotation is mandatory except the element for which default value is provided at the time of annotation definition.
 * @author sinhama
 *
 */

@A_MyAnnotation(
	    name="Jakob",
	    age=37,
	    newNames={"Jenkov", "Peterson"}
	)
public class TstClsMyAnnotation {
	
	 @A_MyAnnotation(age=4, newNames={"name"}) //Element name is eliminated as it has default value. 
	   public void anotherMeyhod(){
		   
	 }

}
