package york.eecs.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author song and you
 * @description: @HeapSort uses max heap algorithm to rank a map based on the values.
 */
public class HeapSort implements MapSort<String, Double>{
	/**
     * @map to be sorted;
     */	
	public Map<String, Double> map;
	
	//ctr
	public HeapSort() {
		this.map = new HashMap<String, Double>();
	}
    
	/**
	 * TODO: There are missing methods, you can find clues of these methods from test cases.
     */
	// setter
	public void setMap(Map<String, Double> map_to_be_sorted) {
		// TODO Auto-generated method stub
		Set<Entry<String, Double>> ts = map_to_be_sorted.entrySet();
		
		for (Entry<String, Double> p : ts) {
			if (p.getValue() == null || p.getKey() == null) {
				throw new MapContainsNullValueException("Map is empty");
			} else {
				map.put(p.getKey(), p.getValue());
			}
		}
	}

	//getter
	public Map<String, Double> getMap() {
		// TODO Auto-generated method stub
		return this.map;
	}
	
	/**
	 * @description: Sort a map by the values in ascending order max heap sorting algorithm.
	 * @return: Return the corresponding key list of the sorted map.
	 */
	@Override
	public ArrayList<String> sortbyValue() {
		/**
		 *  TODO: Implement sorting the maps by values with max heap sorting algorithm.
		 *  	  This method returns the corresponding key list.
		 *  	  You need to use the auxiliary method, i.e., @heapify.
		 */
		// get the values and put in an arraylist
		ArrayList<Double> sl = new ArrayList<>();			
		for (Double d : this.map.values()) {
			sl.add(d);
		}
		System.out.println("SL = " + sl);
		
		// sort the values arraylist
		int n = sl.size();
		for (int i = n / 2 -1; i >= 0; i--) {
			heapify(sl, i, n);						// heapify SL
		}
		for (int i = n-1; i >= 0; i--) {
			Collections.swap(sl, i, 0);
			heapify(sl, 0, i);
		}
		System.out.println("Sorted SL=" + sl);
		
		// put the sorted list's corresponding keys to the slp AL
		ArrayList<String> sbv = new ArrayList<>();
		Set<Entry<String, Double>> ps = this.map.entrySet();
		for (int i = 0; i < sl.size(); i++) {
			for (Entry<String, Double> e : ps) {
				if (e.getValue() == sl.get(i)) {
					sbv.add(e.getKey());
				}
			}
		}
		System.out.println("Sorted by value keys= " + sbv);
		return sbv;
	}
	
	/**
	 * To heapify a subtree rooted with node `i' which is an index in both @keys and @values. 
	 * `n' is size of heap.
	 */
	/** TODO: you need to design the parameters **/
	public void heapify(ArrayList<Double> ls, int i, int n) {
		/**
		 *  TODO: Implement @heapify to build heap. 
		 */ 
		
		System.out.println("Heapify LS = " + ls);
		
		int lr = i;				// index
		int left = 2*i + 1;		// left side
		int right = 2*i + 2;	// right side
		
		if (left < n && ls.get(left) > ls.get(lr)) {
			lr = left;
		} 
		
		if (right < n && ls.get(right) > ls.get(lr)) {
			lr = right;
		}
		
		if (lr != i) {
			Collections.swap(ls, i, lr);
			heapify(ls, lr, n);
		}
	}
	
	public static void main(String[] args) {
		HeapSort hp = new HeapSort();
		
		Map<String, Double> testMap = new HashMap<String, Double>();  // keys -> ID, values -> GPA
		testMap.put("tom", 4.1);		//215132411								 
		testMap.put("james", 2.2);		//210122517
		testMap.put("bakary", 11.1);	//212132101
		testMap.put("tanu", 5.1);		//200132001
		testMap.put("kamal", 3.2);		//223103061
		testMap.put("amar", 6.1);		//293103081
		
		System.out.println("getMap() function:");
		hp.setMap(testMap);
		System.out.println(hp.getMap());
		
		System.out.println("----------------");
		System.out.println("sortByValue() function:");
		System.out.println("lst=" + hp.sortbyValue());
	
	}
}