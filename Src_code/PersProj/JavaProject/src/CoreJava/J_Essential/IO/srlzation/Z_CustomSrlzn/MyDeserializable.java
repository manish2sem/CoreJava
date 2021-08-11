package CoreJava.J_Essential.IO.srlzation.Z_CustomSrlzn;

import java.lang.reflect.Field;

public class MyDeserializable {

	public static void main(String[] args) {
		Class classObj = MyClass.class;
		
		Field[] fields = classObj.getDeclaredFields();
	}

}
