package york.eecs.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import york.eecs.source.BubbleSort;

public class StudentTest {
 /**
  * TODO: Please write at least 5 test cases for testing @BubbleSort.
  * TODO: Please write at least 5 test cases for testing @HeapSort.
  */
	
	// bubblesort 
	BubbleSort bubble = new BubbleSort();
	Map<String, Integer> mp = new HashMap<String, Integer>();
	ArrayList<Integer> val = new ArrayList<Integer>();		// arraylist of values
	ArrayList<String>  keys = new ArrayList<String>();		// arraylist of keys 
	
	
	/*
	 * initialize the data structures  
	 */
	@Before
	public void initializeDS() throws Exception {
		bubble.setMap(mp);
	}
	
	/*
	 * populate the map
	 */
	@Test 
	public void inputMap() {
		mp.put("tom", 4);		//215132411								 
		mp.put("james", 2);		//210122517
		mp.put("bakary", 1);	//212132101
		mp.put("tanu", 5);		//200132001
		mp.put("kamal", 3);		//223103061
		mp.put("amar", 6);		//293103081
		mp.put("jason", null);		//223130141
	}
	
	/*
	 * do the bubblesort here
	 */
	@Test
	public void bubleSort() {
		bubble.sortbyValue();
		Assert.assertEquals(mp.size(), bubble.getMap().size());
		Assert.assertEquals(val.size(), bubble.sortbyValue().size());
		
		for(int i =0; i < val.size(); i++) {
	    	 Assert.assertEquals(val.get(i), bubble.sortbyValue().get(i));
	     }
	}
	
	// heapsort 
	/*
	 * initialize the data structures  
	 */
	@Before
	public void initializeDS2() throws Exception {
		bubble.setMap(mp);
	}
	
	/*
	 * populate the map
	 */
//	@Test 
//	public void inputMap() {
//		mp.put("tom", 4);		//215132411								 
//		mp.put("james", 2);		//210122517
//		mp.put("bakary", 1);	//212132101
//		mp.put("tanu", 5);		//200132001
//		mp.put("kamal", 3);		//223103061
//		mp.put("amar", 6);		//293103081
//		mp.put("jason", null);		//223130141
//	}
	
	/*
	 * do the bubblesort here
	 */
	@Test
	public void heapSort() {
		bubble.sortbyValue();
		Assert.assertEquals(mp.size(), bubble.getMap().size());
		Assert.assertEquals(val.size(), bubble.sortbyValue().size());
		
		for(int i =0; i < val.size(); i++) {
	    	 Assert.assertEquals(val.get(i), bubble.sortbyValue().get(i));
	     }
	}
	
}
