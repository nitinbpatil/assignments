package javaandjava8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MyComparator implements Comparator<String> {

	public int compare(String strA, String strB) {
		return -1;
	}
}

public class ReversingStringUsingComparator {
	public static void main(String[] argv) throws Exception {

		String str = "Ajinkya";
		String revstr = "";
		
		String[] strs = new String[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			strs[i] = Character.toString(str.charAt(i));
		}

		System.out.println("Before Reverse: " + str);

		MyComparator rsc = new MyComparator();

		Arrays.sort(strs, rsc.reversed());

		for (int j = 0; j < strs.length; j++) {
			revstr = revstr + strs[j];
		}

		System.out.println("After Reverse: " + revstr);

	}
}