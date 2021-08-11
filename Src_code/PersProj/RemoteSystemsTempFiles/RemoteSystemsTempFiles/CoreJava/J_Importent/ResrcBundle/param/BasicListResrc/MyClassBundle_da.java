package CoreJava.J_Importent.ResrcBundle.param.BasicListResrc;

import java.util.ListResourceBundle;


public class MyClassBundle_da extends ListResourceBundle {
	
	public static final String CURR = "currency";

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            { "price"   , new Double(75.00) },
            { CURR, "DKK {0} is {1}" },
    };

}