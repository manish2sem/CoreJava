package CoreJava.J_Importent.ResrcBundle.param.BasicListResrc;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainResrcBundle {

	public static void main(String[] args) {
		Locale locale = new Locale("de", "DE"); //no bundle for German -> default		
		displayMessages(locale);
		

		locale = new Locale("da", "DK");
		displayMessages(locale);		

		locale = new Locale("en", "EN");
		displayMessages(locale);
		
	}

	static void displayMessages(Locale currentLocale) {

		ResourceBundle bundle = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.param.BasicListResrc.MyClassBundle", currentLocale);
		System.out.println("price   : " + bundle.getObject("price"));
		System.out.println("currency: " + bundle.getObject("currency"));


		String pattern = bundle.getString("currency");



		MessageFormat messageFormat = new MessageFormat("");
		messageFormat.setLocale(currentLocale);
		messageFormat.applyPattern(pattern);		
		Object[] messageArguments = { "This is not localized",  new  Integer(3)};
		String result = messageFormat.format(messageArguments);			

		System.out.println(result);		


	}

}
