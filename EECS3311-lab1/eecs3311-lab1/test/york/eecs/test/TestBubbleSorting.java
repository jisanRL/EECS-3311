package york.eecs.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import york.eecs.source.BubbleSort;
import york.eecs.source.MapContainsNullValueException;

/**
 * 
 * @author song
 * @description: Test class for @BubbleSort. Do not modify this class.
 */
public class TestBubbleSorting {
	BubbleSort bubble;
	
	 @Before
	    public void setUp() throws Exception {
		 bubble = new BubbleSort();
	    }
	 
	 @Test
	    public void test_bubble_basic() throws MapContainsNullValueException {
		 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
			map_to_be_sorted.put("tom", 99);
			map_to_be_sorted.put("james", 30);
			map_to_be_sorted.put("sam", 67); 
			map_to_be_sorted.put("allen", 107);
	     
	      /**
	       * Initialize the `map' in @BubbleSort with `map_to_be_sorted'.
	       */
	      bubble.setMap(map_to_be_sorted);
	        
	     /**
	      * @Expectedresult: the order of keys after ranking `map' by value with bubble algorithm.
	      */
	     ArrayList<String> expected_result = new ArrayList<String>();
	     expected_result.add("james");
	     expected_result.add("sam");
	     expected_result.add("tom");
	     expected_result.add("allen");
		 
	     /**
		  * map size should be the same;
		  */
		 Assert.assertEquals(map_to_be_sorted.size(), bubble.getMap().size());   
		 /**
		  * Expected result should have the same size of the ranked key list;
	      */		    
	     Assert.assertEquals(expected_result.size(), bubble.sortbyValue().size());
	     /**
		  * Elements in the same position from the expected result and the ranked key list should the same;
		  */ 
	     for(int i =0; i<expected_result.size(); i++) {
	    	 Assert.assertEquals(expected_result.get(i), bubble.sortbyValue().get(i));
	     }
	 } 

	    @Test(expected = MapContainsNullValueException.class)
	    public void test_bubble_exception(){
		 Map<String, Integer> map_to_be_sorted = new HashMap<String, Integer>();
			map_to_be_sorted.put("tom", 99);
			map_to_be_sorted.put("james", 30);
			map_to_be_sorted.put("sam", null); 
			map_to_be_sorted.put("allen", 107);
	     
	       /**
	        * Initialize the `map' in class @BubbleSort with `map_to_be_sorted' by call method @setMap. 
	        * Method @setMap throws MapContainsNullValueException, when the values in the map contain @null.
	        */
	       bubble.setMap(map_to_be_sorted);
	 } 	 
}