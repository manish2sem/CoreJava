package CoreJava.J_Importent.ResrcBundle.param.Basic;


import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChoiceFormatDemo {

	static void displayMessages(Locale currentLocale) {

		System.out.println("currentLocale = " + currentLocale.toString());
		System.out.println();

		ResourceBundle bundle = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.param.Basic.Choice", currentLocale);		
		String pattern = bundle.getString("pattern");

				
				
		MessageFormat messageFormat = new MessageFormat("");
		messageFormat.setLocale(currentLocale);
		messageFormat.applyPattern(pattern);		
		Object[] messageArguments = { "This is not localized",  new  Integer(3), "XDisk", new  Integer(6)}; // Argument passed to the message
		String result = messageFormat.format(messageArguments);	
		
		System.out.println(result);		
	
	}
	

	static public void main(String[] args) {
		displayMessages(new Locale("en", "US"));
		System.out.println();
		displayMessages(new Locale("fr", "FR"));
	}
} 