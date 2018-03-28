package selenium;

public class AdditionOfNumbersFromString {

	public static void main(String[] args) {

		String str = "Nitin123Patil456Nitin789Patil";

		String arr[] = str.split("[A-Za-z]");

		System.out.println("arr length: " + arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
