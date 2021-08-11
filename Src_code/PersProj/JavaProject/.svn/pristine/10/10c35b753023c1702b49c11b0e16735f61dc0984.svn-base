package CoreJava.J_Essential.Collection.general.comprble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/**
 * 
 * @author Manish
 * Why Compilation error? we know sort is a method in Collections class.
 * dvdList having the object of DVDInform.
 * but DVDInform does not implement Comparable.
 * 
 * Solution :
 * DVDInform has to implement Comparable.
 * and it has to override compareTo(){only function of Comparable}
 * 
 */
public class ComparableNotWorks {
	
	ArrayList<DVDInform> dvdList = new ArrayList<DVDInform>();
	
	
	void populateList(){
		/* does following task 
			parse each line of data of dvdinfo.txt file. 
			populate DVDInfo's three instance variables. 
			puts all of the DVDInfo instances into an ArrayList.
		*/
		boolean newFile = false;
		File myFile = new File("dvdinfo.txt");
		if(myFile.exists()){
			System.out.println("File Exists");
			try {
				FileReader fr =	new FileReader(myFile); 
				BufferedReader br =	new BufferedReader(fr);
				String data = br.readLine();
				
				while( data != null) {
					System.out.println(data);
					data = br.readLine();
					if(data!=null){
						String[] tokens = data.split("/");
						DVDInform dvdinfoObj = new DVDInform(tokens[0],tokens[1],tokens[2]);
						dvdList.add(dvdinfoObj);
					}
				}		
				
			}catch(IOException e){
				System.out.println("Inside Exception");
			}
		}else{
			System.out.println("File does not Exists");			
		}
		//FileReader fr =	new FileReader(myFile);
		
	}
	
	public void getDvdInfo(){
		System.out.println(dvdList);
	}
	
	public void sortDvdInfo(){
		Collections.sort(dvdList);
	}
	
	
	public static void main (String [] args) {
		ComparableBasic comprObj= new ComparableBasic();
		comprObj.populateList();	
		System.out.println(comprObj.dvdList);
		comprObj.sortDvdInfo();
		System.out.println(comprObj.dvdList);
	}

}

class DVDInform{
	String title;
	String genre;
	String leadActor;
	DVDInform(String t, String g, String a) {
		title = t; 
		genre = g; 
		leadActor = a;
	}
	
	public String toString() {
		return title + " " + genre + " " + leadActor + "\n";
	}	
}
