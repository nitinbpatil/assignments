package javaandjava8;

import java.util.ArrayList;

class ForEachExample {

	public static void main(String args[]) {

		ArrayList<String> al = new ArrayList<String>();
		al.add("Ajinkya");
		al.add("Nitin");
		al.add("Akshay");
		al.add("Swapnil");
		al.add("Santosh");
		for (String s : al)
			System.out.println(s);
	}
}