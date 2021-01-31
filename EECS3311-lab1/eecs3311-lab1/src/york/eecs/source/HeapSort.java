package york.eecs.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author song and you
 * @description: @HeapSort uses max heap algorithm to rank a map based on the values.
 */
public class HeapSort implements MapSort<String, Double>{
	/**
     * @map to be sorted;
     */	
	public Map<String, Double> map;
    
	/**
	 * TODO: There are missing methods, you can find clues of these methods from test cases.
     */
	// setter
	public void setMap(Map<String, Double> map_to_be_sorted) {
		// TODO Auto-generated method stub
		this.map = map_to_be_sorted;
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
		if (this.getMap().keySet().isEmpty() && this.getMap().values().isEmpty()) {
			throw new MapContainsNullValueException("Map is Empty");
		}
		
		ArrayList<String> lst = new ArrayList<String>();
		lst.addAll(this.getMap().keySet());
		System.out.println("lst=" + lst);
		
		for (int i = lst.size()/2-1; i >= 0; i--) {
//			heapify(lst, lst.size(), i);
		}
		
		
		
		
		return null;
	}
	
	/**
	 * To heapify a subtree rooted with node `i' which is an index in both @keys and @values. 
	 * `n' is size of heap.
	 */
	/** TODO: you need to design the parameters **/
	public void heapify(ArrayList<Integer> ls, int n, int i) {
		/**
		 *  TODO: Implement @heapify to build heap. 
		 */ 
		int lr = i;
		int left = 2*i+1;	// left side
		int right=2*i+1;	// right side
		
		// if left child is larger then root
		if (1 < n && ls.get(1) > ls.get(lr)) {
			lr = 1;
		}
		if(right < n && ls.get(right) > ls.get(lr)) {
			lr = right;
		}
		if(lr != i) {
//			int swp = ls.get(i);
//			ls.get(i) = ls.get(lr);
//			ls.get(lr) = swp;
			Collections.swap(ls, i, i+1);
			heapify(ls, n, lr);
		}
	}
	
	public static void main(String[] args) {
		HeapSort hp = new HeapSort();
		
		Map<String, Integer> testMap = new HashMap<String, Integer>();  // keys -> ID, values -> GPA
		testMap.put("tom", 4);		//215132411								 
		testMap.put("james", 2);	//210122517
		testMap.put("bakary", 1);	//212132101
		testMap.put("tanu", 5);		//200132001
		testMap.put("kamal", 3);	//223103061
		testMap.put("amar", 6);		//293103081
		
		System.out.println(hp.getMap());
		System.out.println("lst=" + hp.sortbyValue());
	}
}