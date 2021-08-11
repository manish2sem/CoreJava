package CoreJava.J_Importent.ResrcBundle.SAG.ListResource;

import java.util.ListResourceBundle;


public class MyClassBundle_da extends ListResourceBundle {

	protected static final int EXCEPTION_BASE_NUM = 9000;


	public static final String PRICE = String.valueOf(EXCEPTION_BASE_NUM + 36);
	public static final String CURRENCY = String.valueOf(EXCEPTION_BASE_NUM + 37);

	@Override
	protected Object[][] getContents() {
		return contents;
	}

	private Object[][] contents = {
			{ PRICE   , new Double(75.00) },
			{ CURRENCY, "DKK {0} is {1}" },
	};

}