package TestPackage;

import java.util.Arrays;

public class Tester {
	
	private static String[] testArr;
	
	public static Object[] add(Object[] arr, Object... elements){
        Object[] tempArr = new Object[arr.length+elements.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        
        for(int i=0; i < elements.length; i++)
            tempArr[arr.length+i] = elements[i];
        return tempArr;
        
    }
		
	public static void main(String[] args) {
		System.out.println("This packege and class is just for testing code snippets, delete before submission");
		Object[] objArr1 = {"1","2","3"};
        Object[] objArr2 = {"4","5","6", "8", "77"};
        Object[] objArr3 = {"44"};
        //adding an element to array
        Object[] objArr = add(objArr1, "4");
        System.out.println(Arrays.toString(objArr));
        //adding two arrays
        objArr = add(objArr1, objArr2);
        System.out.println(Arrays.toString(objArr));
        objArr = add(objArr1, objArr3);
        System.out.println(Arrays.toString(objArr));
	}

}

