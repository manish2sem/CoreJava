package DessignPattern.HeadFirst.Observer.Solution1.Displays;

public class StaticDisplay {
	private float temp;
	private float pressure; 
	private float humidity;
	
	public void update(float temp, float pressure, float humidity){
			this.temp = temp;
			this.pressure = pressure;
			this.humidity = humidity;
			display();
	}
	
	public void display(){
		System.out.println("Current condition : Temprature : " +temp + "; Pressure " +pressure +" and humidity : " +humidity);
		
	}
}
