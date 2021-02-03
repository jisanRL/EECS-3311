package york.eecs.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.Assert;
import york.eecs.source.BubbleSort;
import york.eecs.source.HeapSort;
import york.eecs.source.MapContainsNullValueException;

public class StudentTest {
	/**
	 * TODO: Please write at least 5 test cases for testing @BubbleSort. TODO:
	 * Please write at least 5 test cases for testing @HeapSort.
	 */

	// bubblesort
	BubbleSort bubble = new BubbleSort();
	Map<String, Integer> mp = new HashMap<String, Integer>();
	ArrayList<Integer> val = new ArrayList<Integer>(); // arraylist of values
	ArrayList<String> keys = new ArrayList<String>(); // arraylist of keys

	/*
	 * initialize the Map structures
	 */
	@Before
	public void initializeDS() throws Exception {
		bubble.setMap(mp);
	}

	/*
	 * populate the map
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void inputMap() {
		mp.put("tom", 4); 		// 215132411
		mp.put("james", 2); 	// 210122517
		mp.put("bakary", 1); 	// 212132101
		mp.put("tanu", 5); 		// 200132001
		mp.put("kamal", 3); 	// 223103061
		mp.put("amar", 6); 		// 293103081
		mp.put("jason", 7); 	// 223130141

		// key of the map
		ArrayList<String> key = new ArrayList<String>();
		key.add("tom");
		key.add("james");
		key.add("bakary");
		key.add("tanu");
		key.add("kamal");
		key.add("amar");
		key.add("jason");
	}

	/*
	 * do the bubblesort here
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test_bubbleSort() {
		bubble.sortbyValue();
		Assert.assertEquals(mp.size(), bubble.getMap().size());
		Assert.assertEquals(val.size(), bubble.sortbyValue().size());

		for (int i = 0; i < val.size(); i++) {
			Assert.assertEquals(val.get(i), bubble.sortbyValue().get(i));
		}
	}

	/*
	 * test bubble sort with a Null value
	 */
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test(expected = MapContainsNullValueException.class)
	public void bubbleSort_Value_Null() {
		Map<String, Integer> mp2 = new HashMap<String, Integer>();
		mp2.put("tom", 4); 				// 215132411
		mp2.put("james", 2); 			// 210122517
		mp2.put("bakary", null); 		// 212132101
		mp2.put("tanu", 5); 			// 200132001
		mp2.put("kamal", 3); 			// 223103061
		mp2.put("amar", 6); 			// 293103081
		mp2.put("jason", 7); 			// 223130141

		bubble.setMap(mp2);
		expectedEx.expectMessage("There is a null value ");
	}

	/*
	 * test bubble sort with a key value
	 */
	@Rule
	public ExpectedException expectedEx2 = ExpectedException.none();

	@Test(expected = MapContainsNullValueException.class)
	public void bubbleSort_Key_Null() {
		Map<String, Integer> mp2 = new HashMap<String, Integer>();
		mp2.put("tom", 4); 				// 215132411
		mp2.put("james", 2); 			// 210122517
		mp2.put("bakary", 1); 			// 212132101
		mp2.put(null, 5); 				// 200132001
		mp2.put("kamal", 3); 			// 223103061
		mp2.put("amar", 6); 			// 293103081
		mp2.put("jason", 7); 			// 223130141

		bubble.setMap(mp2);
		expectedEx2.expectMessage("There is a null Key ");
	}

	// heapsort
	HeapSort heap = new HeapSort();
	Map<String, Double> mp2 = new HashMap<String, Double>();
	ArrayList<Double> val2 = new ArrayList<Double>(); 		// arraylist of values
	ArrayList<String> keys2 = new ArrayList<String>();		// arraylist of keys

	/*
	 * initialize the Map structures
	 */
	@Before
	public void initializeDS2() throws Exception {
		heap.setMap(mp2);
	}

	/*
	 * populate the map
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void inputMap2() {
		mp2.put("tom", 4.1); 			// 215132411
		mp2.put("james", 2.2); 			// 210122517
		mp2.put("bakary", 11.1); 		// 212132101
		mp2.put("tanu", 5.1); 			// 200132001
		mp2.put("kamal", 3.3); 			// 223103061
		mp2.put("amar", 6.1); 			// 293103081
		mp2.put("jason", 7.0); 			// 223130141

		// key of the map
		ArrayList<String> keyS2 = new ArrayList<String>();
		keys2.add("tom");
		keys2.add("james");
		keys2.add("bakary");
		keys2.add("tanu");
		keys2.add("kamal");
		keys2.add("amar");
		keys2.add("jason");

	}

	/*
	 * test heap sort with a Null value
	 */
	@Rule
	public ExpectedException expectedEx3 = ExpectedException.none();

	@Test(expected = MapContainsNullValueException.class)
	public void heapSort_Value_Null() {
		Map<String, Double> mp2 = new HashMap<String, Double>();
		mp2.put("tom", 4.1); 			// 215132411
		mp2.put("james", 2.2); 			// 210122517
		mp2.put("bakary", 11.1); 		// 212132101
		mp2.put("tanu", null); 			// 200132001
		mp2.put("kamal", 3.3); 			// 223103061
		mp2.put("amar", 6.1); 			// 293103081
		mp2.put("jason", 7.0); 			// 223130141

		heap.setMap(mp2);
		expectedEx3.expectMessage("There is a null value ");
	}

	/*
	 * test heap sort with a key value
	 */
	@Rule
	public ExpectedException expectedEx4 = ExpectedException.none();

	@Test(expected = MapContainsNullValueException.class)
	public void heapSort_Key_Null() {
		Map<String, Double> mp2 = new HashMap<String, Double>();
		mp2.put("tom", 4.1); 			// 215132411
		mp2.put("james", 2.2); 			// 210122517
		mp2.put("bakary", 11.1); 		// 212132101
		mp2.put("tanu", 5.1); 			// 200132001
		mp2.put(null, 3.3); 			// 223103061
		mp2.put("amar", 6.1); 			// 293103081
		mp2.put("jason", 7.0); 			// 223130141

		heap.setMap(mp2);
		expectedEx4.expectMessage("There is a null Key ");
	}

	/*
	 * do the heapsort here
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void test_heapSort() {
		heap.sortbyValue();
		Assert.assertEquals(mp.size(), heap.getMap().size());
		Assert.assertEquals(val.size(), heap.sortbyValue().size());

		for (int i = 0; i < val.size(); i++) {
			Assert.assertEquals(val.get(i), heap.sortbyValue().get(i));
		}
	}

	/*
	 * test for heapify of the value arraylist
	 */
	@Test
	public void test_heapify() {
		ArrayList<Double> val2 = new ArrayList<Double>();
		val2.add(4.1); 			// 215132411
		val2.add(2.2); 			// 210122517
		val2.add(11.1); 		// 212132101
		val2.add(5.1); 			// 200132001
		val2.add(3.3); 			// 223103061
		val2.add(6.1); 			// 293103081
		val2.add(7.0);

		heap.heapify(val2, 0, mp2.size());
	}

	/*
	 * test for heapify of the value arraylist
	 */
	@Rule
	public ExpectedException expectedEx5 = ExpectedException.none();

	@Test
	public void test_heapifyforNull() {
		ArrayList<Double> val2 = new ArrayList<Double>();
		val2.add(4.1); 			// 215132411
		val2.add(2.2); 			// 210122517
		val2.add(null); 		// 212132101
		val2.add(5.1); 			// 200132001
		val2.add(3.3); 			// 223103061
		val2.add(6.1); 			// 293103081
		val2.add(7.0);

		heap.heapify(val2, 0, mp2.size());

	}
}
