package CoreJava.J_Importent.ResrcBundle.param;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChoiceFormatDemo {

	static void displayMessages(Locale currentLocale) {

		System.out.println("currentLocale = " + currentLocale.toString());
		System.out.println();

		ResourceBundle bundle = ResourceBundle.getBundle("CoreJava.J_Importent.ResrcBundle.param.Choice", currentLocale);

		MessageFormat messageForm = new MessageFormat("");
		messageForm.setLocale(currentLocale);

		double[] fileLimits = {0,1,2};

		String [] fileStrings = {
				bundle.getString("noFiles"),
				bundle.getString("oneFile"),
				bundle.getString("multipleFiles")
		};

		ChoiceFormat choiceForm = new ChoiceFormat(fileLimits, fileStrings);

		String pattern = bundle.getString("pattern");
		
		//System.out.println(pattern);
		
		Format[] formats = {choiceForm, null, NumberFormat.getInstance()};

		messageForm.applyPattern(pattern);
		messageForm.setFormats(formats);
		
	/*	Object[] messageArguments = {null, "XDisk", null};		
		messageArguments[0] = new Integer(2);
		messageArguments[2] = new Integer(2);*/
		
		Object[] messageArguments = { new Integer(2), "XDisk", new  Integer(3)};
		String result = messageForm.format(messageArguments);
		
		System.out.println(result);
		
		/*Format[] formats = {choiceForm, null, NumberFormat.getInstance()};

		messageForm.applyPattern(pattern);
		messageForm.setFormats(formats);

		Object[] messageArguments = {null, "XDisk", null};

		for (int numFiles = 0; numFiles < 5; numFiles++) {
			messageArguments[0] = new Integer(numFiles);
			messageArguments[2] = new Integer(numFiles);
			String result = messageForm.format(messageArguments);
			System.out.println(result);
		}*/
	}

	static public void main(String[] args) {
		displayMessages(new Locale("en", "US"));
		System.out.println();
		displayMessages(new Locale("fr", "FR"));
	}
} 