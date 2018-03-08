package javaandjava8;

interface Sayable{  
    void say();  
}  

public class ReferenceToStaticMethodWithFunctionalInterface{  
    public static void print(){  
        System.out.println("This is a static method.");  
    }  
    public static void main(String[] args) {  
        // Referring static method  
        Sayable sayable = ReferenceToStaticMethodWithFunctionalInterface::print;  
        // Calling interface method  
        sayable.say();  
    }  
}  