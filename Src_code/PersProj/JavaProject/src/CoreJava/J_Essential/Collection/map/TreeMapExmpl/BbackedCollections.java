package CoreJava.J_Essential.Collection.map.TreeMapExmpl;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * the subMap() method is making a copy of a portion of the TreeMap.
 * 		submap = map.subMap("b", "g"); range is b-g.
 * When we add key-value pairs to either the original TreeMap or the partial-copy SortedMap, 
 * the new entries were automatically added to the other collection—sometimes. - THAT'S WHY IT IS CALLED BACKED-COLLECTION.
 * 
 * When submap was created, we provided a value range for the new collection.
 * This range defines not only what should be included when the partial copy is created, but  
 * also defines the range of values that can be added to the copy.
 * 
 * we can add new entries to either collection within the range of the copy, and the new entries will show up in both collections.
 *  In addition, we can add a new entry to the original collection, even if it's outside the range of the copy. 
 *  In this case, the new entry will show up only in the original—it won't be added to the copy because it's outside the copy's range.
 *  
 *  If you attempt to add an out-of-range entry to the copied collection an exception will be thrown.
 * @author sinhama
 *
 */

public class BbackedCollections {

	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("a", "ant"); 
		map.put("d", "dog");
		map.put("h", "horse");
		
		SortedMap<String, String> submap;
		submap = map.subMap("b", "g"); //  create a backed collection
		System.out.println(map + " " + submap); // 
		
		map.put("b", "bat"); // add to original Within a range, it's ok.
		submap.put("f", "fish"); // add to copy. Within a range, it's ok.
		map.put("r", "raccoon"); // add to original - out of range. It's ok.
		//submap.put("p", "pig"); // add to copy - out of range. RuntimeException-> IllegalArgumentException  
		System.out.println(map + " " + submap);
	}
}

/**
 * TreeSet—(headSet(), subSet(), and tailSet()), and 
 * TreeMap- (headMap(), subMap(), andtailMap()).
 * headSet() / headMap() methods create a subset that starts at the beginning of the original collection and 
 * ends at the point specified(DEFAULTE IT IS EXCLUDED) by the method's argument.
 */
