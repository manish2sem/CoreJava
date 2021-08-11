package Java6Features;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {

    public static void main(String[] args) {

        // create a TreeSet containing 5 integers
        // TreeSet will automatically sort the numbers
        List<Integer> list = Arrays.asList(3, 2, 4, 1, 5);
        NavigableSet<Integer> ns = new TreeSet<Integer>(list);
        System.out.println("Ascending order (default): " + ns);

        // Use its descendingIterator
        Iterator<Integer> descendingIterator = ns.descendingIterator();
        StringBuilder sb = new StringBuilder("Descending order: ");
        while (descendingIterator.hasNext()) {
            int m = descendingIterator.next();
            sb.append(m + " ");
        }
        System.out.println(sb);

        int greatest = ns.lower(3);
        System.out.println("Lower of 3 = " + greatest);

        int smallest = ns.higher(3);
        System.out.println("Higher of 3 = " + smallest);
    }
}
