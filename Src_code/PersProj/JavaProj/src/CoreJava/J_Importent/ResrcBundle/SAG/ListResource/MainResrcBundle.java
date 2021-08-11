package CoreJava.J_Importent.ResrcBundle.SAG.ListResource;

import java.util.Locale;
import java.util.ResourceBundle;

public class MainResrcBundle {

	public static void main(String[] args) {
		Locale locale = new Locale("de", "DE"); //no bundle for German -> default
		ResourceBundle bundle = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.SAG.ListResource.MyClassBundle", locale);
		System.out.println("price   : " + bundle.getObject("9036"));
		System.out.println("currency: " + bundle.getObject("9037"));


		locale = new Locale("da", "DK");
		bundle = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.SAG.ListResource.MyClassBundle", locale);
		System.out.println("price   : " + bundle.getObject("9036"));
		System.out.println("currency: " + bundle.getString("9037"));


		locale = new Locale("en", "EN");
		bundle = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.SAG.ListResource.MyClassBundle", locale);
		System.out.println("price   : " + bundle.getObject("9036"));
		System.out.println("currency: " + bundle.getObject("9037"));

	}

}
