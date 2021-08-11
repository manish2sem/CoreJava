package DessignPattern.Other.Creational.Builder.Ex3;

public interface CarBuilder {
	String makeEngine(String engine);
	int makeTyre(int tyre);
	int seats(int seat);
	String color(String color);
	void makeCar();
	
}
