package IntgrationServerTests;

import java.io.IOException;

public class ExexDate {
	public static void main(String[] args) {
		 getRuntime_exec();
		 processBuilder();
	}
	
	
	public static void getRuntime_exec() {
		try {

			// print a message
			System.out.println("Executing notepad.exe");
			//long startTime = System.currentTimeMillis();
			
			long startTime = System.nanoTime();

			Process process = Runtime.getRuntime().exec("notepad.exe");
		//	long endTime   = System.currentTimeMillis();
			long endTime   = System.nanoTime();

			process.waitFor();
			System.out.println("totalTime : " + (endTime - startTime));
			System.out.println("Opening Notepad ...");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void processBuilder() {
		try {

			// print a message
			System.out.println("Executing notepad.exe");
			//long startTime = System.currentTimeMillis();
			long startTime = System.nanoTime();

			ProcessBuilder b = new ProcessBuilder("notepad.exe");
			b.start();
			//long endTime   = System.currentTimeMillis();
			long endTime   = System.nanoTime();

			System.out.println("totalTime : " + (endTime - startTime));
			System.out.println("Opening Notepad ...");


		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	



	/*try {
			Runtime.getRuntime().exec("date") ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception");
			e.printStackTrace();
		}*/



}
