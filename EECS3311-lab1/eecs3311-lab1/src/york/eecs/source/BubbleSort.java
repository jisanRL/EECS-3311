package york.eecs.source;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author song and you
 * @description: @BubbleSort uses bubble sorting algorithm to rank a map based on the values.
 */
public class BubbleSort implements MapSort<String, Integer>{
    /**
     * @map to be sorted;	<key, value>
     */
	public Map<String, Integer> map;
    
	/**
	 * TODO: There are missing methods, you can find clues from test cases.
     */
	public void setMap(Map<String, Integer> map_to_be_sorted) {
		// TODO Auto-generated method stub
		this.map = map_to_be_sorted;

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
		// fix this sorting is wrong
		if (this.getMap().keySet().isEmpty() && this.getMap().values().isEmpty()) {
			throw new MapContainsNullValueException("Map is Empty");
		}
		ArrayList<String> lst = new ArrayList<String>();
		lst.addAll(this.getMap().keySet());
//		lst.add(this.getMap().values().toString());
		
		String tm;
		boolean sort = false;
		
		while (!sort) {
			sort = true;
			for (int i = 0; i < lst.size()-1; i++) {
				if (lst.get(i).compareTo(lst.get(i+1)) > 0) {
					tm = lst.get(i);
					lst.set(i, lst.get(i+1));
					lst.set(i+1, tm);
					sort = false;
				}
			}
		}
		return lst;
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		
		Map<String, Integer> testMap = new HashMap<String, Integer>();  // keys -> ID, values -> GPA
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