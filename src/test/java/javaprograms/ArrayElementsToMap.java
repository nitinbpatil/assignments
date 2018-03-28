package javaprograms;

import java.util.HashMap;
import java.util.Map;

public class ArrayElementsToMap {

	public static void main(String[] args) {

		String arr[] = { "fname:Nitin", "lname:Patil", "age:36", "company:EPAM" };

		Map<String, String> map = new HashMap<String, String>();

		for (String s : arr) {

			String arr1[] = s.split(":");
			// System.out.println(arr1[0] + " - " + arr1[1]);
			map.put(arr1[0], arr1[1]);
		}

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
		}

	}
}