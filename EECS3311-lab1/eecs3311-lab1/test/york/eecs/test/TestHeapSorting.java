package york.eecs.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import york.eecs.source.HeapSort;
import york.eecs.source.MapContainsNullValueException;

/**
 * 
 * @author song
 * @description: Test class for @HeapSort. Do not modify this class.
 */
public class TestHeapSorting {
		HeapSort heapsort;
	
	    @Before
	    public void setUp() throws Exception {
		 heapsort = new HeapSort();
	    }
	 
	    @Test
	    public void test_heap_basic() {
		Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
		map_to_be_sorted.put("A", 99.5);
		map_to_be_sorted.put("E", 50.3);
		map_to_be_sorted.put("C", 167.4);
		map_to_be_sorted.put("D", 87.3); 
		map_to_be_sorted.put("B", 77.4);
	    
	    /**
	     * Initialize the `map' in bubble with `map_to_be_sorted';
	     */
	    heapsort.setMap(map_to_be_sorted);    
	    
	    /**
	     * Expected results: the order of keys after ranking `map' by value with max heap algorithm;
	     */
		ArrayList<String> results = new ArrayList<String>();
		results.add("E");
		results.add("B");
		results.add("D");
		results.add("A");
		results.add("C");
		
		/**
		 * map size should be the same;
		 */
		Assert.assertEquals(map_to_be_sorted.size(), heapsort.getMap().size());
		/**
		 * Expected result should have the same size of the ranked key list;
		 */
	    Assert.assertEquals(results.size(), heapsort.sortbyValue().size());
	    
	    /**
	     * Elements in the same position from the expected result and the ranked key list should the same;
	     */
		for(int i =0; i<results.size(); i++) {
			 Assert.assertEquals(results.get(i), heapsort.sortbyValue().get(i));
		}
     }
	    

	    @Test(expected = MapContainsNullValueException.class)
	    public void test_heap_exception(){
		 Map<String, Double> map_to_be_sorted = new HashMap<String, Double>();
			map_to_be_sorted.put("A", 99.0);
			map_to_be_sorted.put("B", 30.1);
			map_to_be_sorted.put("E", null); 
			map_to_be_sorted.put("C", 107.3);
	     
	       /**
	        * Initialize the `map' in class @HeapSort with `map_to_be_sorted' by call method @setMap;
	        * Method @setMap throws MapContainsNullValueException, when the values in the map contain @null.
	        */
			heapsort.setMap(map_to_be_sorted);	    
	    }
}