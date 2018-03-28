package javaprograms;

public class AdditionOfNumbersFromString {

	public static void main(String[] args) {

		String a = "jklmn489pjro635ops";

		int sum = 0;

		String num = "";

		for (int i = 0; i < a.length(); i++) {
			if (Character.isDigit(a.charAt(i))) {
				num = num + a.charAt(i);
				// System.out.println("num: " + num);
			} else {
				if (!num.equals("")) {
					sum = sum + Integer.parseInt(num);
					// System.out.println("sum: " + sum);
					num = "";
				}
			}
		}

		System.out.println(sum);
	}
}