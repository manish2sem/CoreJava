package Interview.Medlife;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class CarOpt {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		int N = Integer.parseInt(line);

		line = br.readLine();
		String speed[] = line.split(" ");
		
		line = br.readLine();
		String consumption[] = line.split(" ");
		
		if (consumption.length != N ){
			System.out.println("Invalid input");
			System.exit(1);
		}
		
	
		double optimal = 0;
		int optIndex = 0;
		//int milage[] = new int[N];
		
		for(int i =0; i<N; i++ ){
			float speed1 = Integer.parseInt(speed[i]);
			float consump = Integer.parseInt(consumption[i]);
			float milage = speed1/consump;
			System.out.println("milage " +milage);
		
			if (milage > optimal){
				System.out.println("changing milage " +i);
				optimal = milage;
				optIndex = i;
			}
		}
			
		line = br.readLine();
		float availableFuel = Integer.parseInt(line);
		double result = availableFuel*Integer.parseInt(speed[optIndex])/Integer.parseInt(consumption[optIndex]);
		System.out.println("Optimized distance = " +availableFuel*Integer.parseInt(speed[optIndex])/Integer.parseInt(consumption[optIndex]));
		
		System.out.println( "Optimized distance = " +String.format( "%.3f", result ) );
	}

}
