package york.eecs.source;

import java.util.ArrayList;

/**
 * @author song
 * @description: This the interface class for MapSort. 
 * @param <K,V>: K is the key of a map and V is the value of a map.
 */

public interface MapSort<K, V> {
	/**
	 * @description: Sort a map by the values in ascending order. 
	 * @return: Return the corresponding K list of the sorted map.
	 * 
	 * Do not modify this class!
	 *
	 */
	public ArrayList<K> sortbyValue(); 
}
