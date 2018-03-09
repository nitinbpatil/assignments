package exampletested;

interface MyInterface {

	default void newMethod() {
		System.out.println("Newly added default method");
	}

	static void testStatic()
	{
		System.out.println("inside static block...");
	}
	
	void existingMethod(String str);
}

interface MyInterface2 {

	default void newMethod() {
		System.out.println("Newly added default method");
	}

	void disp(String str);
}

public class Example implements MyInterface, MyInterface2 {
	// implementing abstract methods
	public void existingMethod(String str) {
		System.out.println("String is: " + str);
	}

	public void disp(String str) {
		System.out.println("String is: " + str);
	}
	
	public void testStatic()
	{
		System.out.println("Inside testStaticxxxx");
	}

	// Implementation of duplicate default method
	public void newMethod() {
		System.out.println("Implementation of default method");
	}

	public static void main(String[] args) {
		Example obj = new Example();

		// calling the default method of interface
		obj.newMethod();
		obj.testStatic();

	}
}