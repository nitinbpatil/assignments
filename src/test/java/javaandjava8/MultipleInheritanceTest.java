package javaandjava8;

// Multiple inheritance through default methods.

interface Interface1
{
    default void print()
    {
        System.out.println("Default Interface1...");
    }
    
    static void printStatic()
    {
    	System.out.println("Printing Static method...");
    }
}
 
interface Interface2
{
    default void print()
    {
        System.out.println("Default Interface2...");
    }
}
 
class MultipleInheritanceTest implements Interface1, Interface2
{
    // Overriding default show method and resolving the ambiguity
    public void print()
    {
        // calling print() method of Interface1	
        Interface1.super.print();
        Interface1.printStatic();
 
        // calling print() method of Interface2
        Interface2.super.print();
    }
 
    public static void main(String args[])
    {
    	MultipleInheritanceTest multipleIn = new MultipleInheritanceTest();
        multipleIn.print();
    }
}