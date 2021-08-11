package CoreJava.J_Essential.Collection.map.LinkedMap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;


public class LinkedHashMapSimul {
	static Map<String, Integer> map;

	// Actual Method from HashMap library
	static int indexFor(int h, int length) {
		return h & (length - 1);
	}

	// Actual Method from HashMap library
	static int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	public static void interrospect() {
		try {
			Class<?> c = map.getClass();
			c = c.getSuperclass();
			Field f = c.getDeclaredField("size");
			f.setAccessible(true);
			int size = f.getInt(map);

			f = c.getDeclaredField("loadFactor");
			f.setAccessible(true);
			float loadFactor = f.getFloat(map);

			f = c.getDeclaredField("threshold");
			f.setAccessible(true);
			int threshold = f.getInt(map);

			f = c.getDeclaredField("modCount");
			f.setAccessible(true);
			int modCount = f.getInt(map);

			Method m = c.getDeclaredMethod("capacity", null);
			m.setAccessible(true);
			int capacity = (Integer) m.invoke(map, null);

			System.out.println("Size: " + size + "; LoadFactor: " + loadFactor
					+ "; Threashold: " + threshold + "; ModCount: " + modCount
					+ " ; capacity :" + capacity);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		map = new LinkedHashMap<String, Integer>();

		map.put("guava", indexFor(hash("guava".hashCode()), 16));
		map.put("mango", indexFor(hash("mango".hashCode()), 16));
		map.put("pear", indexFor(hash("pear".hashCode()), 16));
		map.put("banana", indexFor(hash("banana".hashCode()), 16));

		System.out.println(" Map :" + map);
		interrospect();
	}

}


