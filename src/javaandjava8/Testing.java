package javaandjava8;

public class Testing {


	public void print()
	{
		System.out.println(this.getClass().getSimpleName());
	}
	
	public static void main(String[] args) {
		
		Testing t = new Testing();
		t.print();
		System.out.println("Welcome to Java... :)");
	}
	

}
