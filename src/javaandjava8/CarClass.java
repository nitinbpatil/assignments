package javaandjava8;

abstract class Vehicle {

	public abstract void startVehicle();

	public abstract void stopVehicle();

	public void changeGear()
	{
		System.out.println("Vehicle Gear has been changed...");
	}

	public void accelerate()
	{
		System.out.println("Vehicle has been accelerated...");
	}
	
	public abstract void slowDown();

}

class Car extends Vehicle {

	int year;
	String make;
	String model;

	Car(int year, String make, String model) {
		this.year = year;
		this.make = make;
		this.model = model;
	}

	//Inherited methods of Vehicle class
	
	@Override
	public void startVehicle() {
		System.out.println(year + "-" + make + "-" + model + " Car is started..");
	}

	@Override
	public void stopVehicle() {
		System.out.println(year + "-" + make + "-" + model + " Car has been stopped..");
	}

	@Override
	public void changeGear() {
		System.out.println(year + "-" + make + "-" + model + " Car Gear has been changed..");
	}

	@Override
	public void accelerate() {
		System.out.println(year + "-" + make + "-" + model + " Car has been accelerated..");
	}

	@Override
	public void slowDown() {
		System.out.println(year + "-" + make + "-" + model + " Car is slowing down..");
	}
	
	//Getter methods for Car properties make, model and year
	
	public int getCarYear() {
		return year;
	}

	public String getCarMake() {
		return make;
	}

	public String getCarModel() {
		return model;
	}

	//Setter methods for Car properties make, model and year
	
	public void setCarYear(int year) {
		this.year = year;
	}

	public void setCarMake(String make) {
		this.make = make;
	}

	public void setCarModel(String model) {
		this.model = model;
	}

}

//Car Class

public class CarClass {
	public static void main(String args[]) {

		Car c1 = new Car(2010, "Hyundai", "i10");
		c1.startVehicle();
		c1.accelerate(); // Here JVM at runtime idenfies which accelerate method to call
		c1.changeGear(); // Runtime Polymorphism
		c1.slowDown();
		c1.stopVehicle();
		
		Car c2 = new Car(2012, "Toyota", "Camry");
		
		c2.startVehicle();
		c2.changeGear();
		c2.stopVehicle();
		
	}
}