package Java6Features;


import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map.Entry;

public class NavigableMapDemo {
    public static void main(String[] args) {

        // Create a TreeMap containing key/value pairs
        NavigableMap<Integer, String> map = 
                new TreeMap<Integer, String>();
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");
        System.out.println("Original map: " + map + "\n");

        // take and delete the first entry from the map
        Entry firstEntry = map.pollFirstEntry();
        System.out.println("First entry: " + firstEntry);
        System.out.println("After polling the first entry: " + map + "\n");

        // take and delete the last entry
        Entry lastEntry = map.pollLastEntry();
        System.out.println("Last entry: " + lastEntry);
        System.out.println("After polling last entry: " + map);
    }
}
