package CoreJava.J_Importent.ResrcBundle.jenkov.Property;

import java.util.Locale;
import java.util.ResourceBundle;

public class Mainz {

	public static void main(String[] args) {
		Locale locale = new Locale("en", "US");// //no bundle for eng -> default
		ResourceBundle labels = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.jenkov.Property.MyBundle", locale);
		System.out.println(labels.getString("label1"));
		
		locale = new Locale("da", "DK");
		labels = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.jenkov.Property.MyBundle", locale);
		System.out.println(labels.getString("label1"));
		
		
	}

}
