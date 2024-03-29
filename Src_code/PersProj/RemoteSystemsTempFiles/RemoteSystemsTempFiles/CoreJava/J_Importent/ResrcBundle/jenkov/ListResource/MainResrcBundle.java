package CoreJava.J_Importent.ResrcBundle.jenkov.ListResource;

import java.util.Locale;
import java.util.ResourceBundle;

public class MainResrcBundle {

	public static void main(String[] args) {
		Locale locale = new Locale("de", "DE"); //no bundle for German -> default
		ResourceBundle bundle = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.jenkov.ListResource.MyClassBundle", locale);
		System.out.println("price   : " + bundle.getObject("price"));
		System.out.println("currency: " + bundle.getObject("currency"));


		locale = new Locale("da", "DK");
		bundle = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.jenkov.ListResource.MyClassBundle", locale);
		System.out.println("price   : " + bundle.getObject("price"));
		System.out.println("currency: " + bundle.getString("currency"));


		locale = new Locale("en", "EN");
		bundle = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.jenkov.ListResource.MyClassBundle", locale);
		System.out.println("price   : " + bundle.getObject("price"));
		System.out.println("currency: " + bundle.getObject("currency"));

	}

}
