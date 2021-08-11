package DessignPattern.HeadFirst.Singleton.C_DestroySrlztion;

import java.lang.reflect.Constructor;

/**
 * Reflection is used to destroy singleton implementation approaches.
 *
 */

public class DestroySingleton {


	public static void main(String[] args) {
		SingletonCls instanceOne = SingletonCls.getInstance();
		instanceOne.setStr("New Str");
		SingletonCls instanceTwo = null;
		try {
			Constructor[] constructors = SingletonCls.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				//Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (SingletonCls) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
		
		System.out.println(instanceOne.getStr());
		System.out.println(instanceTwo.getStr());
	}



}
