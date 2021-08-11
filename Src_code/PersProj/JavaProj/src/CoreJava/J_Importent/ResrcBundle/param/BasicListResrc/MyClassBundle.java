package CoreJava.J_Importent.ResrcBundle.param.BasicListResrc;

/**
 * http://tutorials.jenkov.com/java-internationalization/resourcebundle.html
 * @author MAKUM
 *
 */

import java.util.ListResourceBundle;

public class MyClassBundle extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            { "price"   , new Double(10.00) },
            { "currency", "EUR {0} is {1}" },
    };
}