package CoreJava.J_Advance.Annotations.UseCustAnnot;

import CoreJava.J_Advance.Annotations.CustomAnnotations.B_MyAnnotationMethod;




// @B_MyAnnotationMethod (value = "value") //Annotation is disallowed at this location
public class TstClsAnnotationMethod {
	
   @B_MyAnnotationMethod(value="value")		// This is the correct location for this annotation
   public void myMeyhod(){
	   
   }
   
   @B_MyAnnotationMethod("value")		// This is the correct location for this annotation. Because of value
   public void anotherMeyhod(){
	   
   }
}
