package york.eecs.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author song and Farhan
 * @description: @BubbleSort uses bubble sorting algorithm to rank a map based on the values.
 */
public class BubbleSort implements MapSort<String, Integer>{
    /**
     * @map to be sorted;	<key, value>
     */
	public Map<String, Integer> map;
	
	// ctr
	public BubbleSort() {
		this.map = new HashMap<String, Integer>();
	}
    
	/**
	 * TODO: There are missing methods, you can find clues from test cases.
     */
	public void setMap(Map<String, Integer> map_to_be_sorted) {
		// TODO Auto-generated method stub
		Set<Entry<String, Integer>> st = map_to_be_sorted.entrySet();		// put the map into the set
		for (Entry<String, Integer> t : st) {
			if (t.getValue() == null || t.getKey() == null) {
				throw new MapContainsNullValueException("Map is empty");
			} else {
				map.put(t.getKey(), t.getValue());
			}
		}
	}
	
	public Map<String, Integer> getMap() {
		// TODO Auto-generated method stub
		return this.map;
	}
	
	/**
	 * @description: Sort a map by the values in ascending order with bubble sorting algorithm. 
	 * @return: Return the corresponding key list of the sorted map.
	 */
	@Override
	public ArrayList<String> sortbyValue(){
	/**
	 *  TODO: Implement sorting the maps by values with bubble sorting algorithm.
	 *  	  This method returns the corresponding key list.
	 */
		// create the values in AL and put values in her
		ArrayList<Integer> lstVal = new ArrayList<>();		
		for (Integer p : this.map.values()) {
			lstVal.add(p);										// unsorted values in the list 
		}
		
		helperSort(lstVal);										// sort the arraylist of values 
		
		ArrayList<String> lstStr= new ArrayList<>();			// arraylist for the key
		for (String str : this.map.keySet()) {
			lstStr.add(str);
		}
		
		ArrayList<String> lstf = new ArrayList<>(); 			// arraylist for value 
		Set<Entry<String, Integer>> op = this.map.entrySet();
		
		// map the key to val and return corresponding key
		for (int i = 0; i < lstVal.size(); i++) {
			for (Entry<String, Integer> e : op) {
				if (e.getValue() == lstVal.get(i)) {			// get the sorted value and put its key in the AL
					lstf.add(e.getKey());
				}
			}	
		}
		return lstf;
	}
	
	// sorts the values in the AL
	public void helperSort(ArrayList<Integer> soc) {
		for (int i = 0; i < soc.size(); i++) {
	          for (int j = soc.size() - 1; j > i; j--) {
	              if (soc.get(i) > soc.get(j)) {

	                  int t = soc.get(i);
	                  soc.set(i,soc.get(j)) ;
	                  soc.set(j,t);
	              }
	          }
	      }
	}
	
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		
		// keys -> ID, values -> GPA
		Map<String, Integer> testMap = new HashMap<String, Integer>();  
		testMap.put("tom", 4);		//215132411								 
		testMap.put("james", 2);	//210122517
		testMap.put("bakary", 1);	//212132101
		testMap.put("tanu", 5);		//200132001
		testMap.put("kamal", 3);	//223103061
		testMap.put("amar", 6);		//293103081
		
		System.out.println(testMap);
		System.out.println("----------------");
		System.out.println("getMap() function:");
		bs.setMap(testMap);
		System.out.println(bs.getMap());
		System.out.println("----------------");
		System.out.println("sortByValue() function:");
		System.out.println(bs.sortbyValue());
	}
}