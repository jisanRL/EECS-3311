package TestPackage;

import java.util.Arrays;

public class Tester {
	
	public static boolean tablizing(String str) {
		boolean check = false;
		int number = (int) (Math.random() * (1500-0) + 0); // random generated parking space number
		System.out.println(number);
		if (str.contains("york") ||  str.contains("yu")) {
				str = "york" + number;
				check = true;
				System.out.println(check);
				System.out.println(str);
				return check;
			} else if(str.contains("yorkdale") || str.contains("yd")) {
				str = "yd" + number;
				check = true;
				System.out.println(check);
				System.out.println(str);
				return check;
			} else if( str.contains("dt") ||  str.contains("downtown")) {
				str = "dt" + number;
				check = true;
				System.out.println(check);
				System.out.println(str);
				return check;
			} else if ( str.contains("square1") ||  str.contains("sq1")) {
				str = "sqo" + number;
				check = true;
				System.out.println(check);
				System.out.println(str);
				return check;
			} else if ( str.contains("stg") ||  str.contains("st george")) {
				str = "stg" + number;
				check = true;
				System.out.println(check);
				System.out.println(str);
				return check;
			} else {
				str = null;
				System.out.println(check);
				System.out.println(str);
				return check;
			}
	}
		
	public static void main(String[] args) {
		System.out.println(tablizing("stg55"));
	}

}

