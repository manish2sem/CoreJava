package DessignPattern.Other.Creational.Builder.Ex3;

public class UsCarBuilder implements CarBuilder{

	@Override
	public String makeEngine(String engine) {
		// TODO Auto-generated method stub
		return "engine type " +engine;
	}

	@Override
	public int makeTyre(int tyre) {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int seats(int seat) {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public String color(String color) {
		// TODO Auto-generated method stub
		return "color is "+color;
	}

	@Override
	public void makeCar() {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.setColor(this.color("Red"));
		car.setEngine(this.makeEngine("engine"));
		car.setSeat(this.seats(5));
		car.setTyre(this.makeTyre(6));
	}

	

}
