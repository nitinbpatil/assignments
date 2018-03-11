package javaandjava8;

public class Testing {

	public void print() {
		System.out.println(this.getClass().getSimpleName());
	}

	public static void main(String[] args) {

		Testing t = new Testing();
		t.print();
		System.out.println("Welcome to Java... :)");
	}

}

class Singleton {
	
	private static volatile Singleton _instance = null;
	
	private Singleton() { }
	

	public static Singleton getInstance()
	{
		
		if(_instance == null) // 1st Check 
		{ 
			
			synchronized(Singleton.class)
			{
				if(_instance == null) //2nd Check
				{
					_instance = new Singleton();
				}
			}
		}
		return _instance;
	}
}
