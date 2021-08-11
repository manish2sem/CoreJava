package CoreJava.J_Essential.Collection.general.comprble;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Comparable interface is used by the Collections.sort() method and the java.utils.Arrays.sort() method 
 * to sort Lists and arrays of objects, respectively.
 * To implement Comparable, a class must implement a single method, compareTo().
 *
 */
public class ComparableBasic {
	
	ArrayList dvdList = new ArrayList();
	
	
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
						DVDInfo dvdinfoObj = new DVDInfo(tokens[0],tokens[1],tokens[2]);
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


/*
 * class DVDInfo implements Comparable in such a way that DVDInfo objects can be compared to other DVDInfo objects.
 * we implement compareTo() by comparing the two DVDInfo object's titles. 
 * Since we know that the titles are Strings, and that String implements Comparable,
 *  this is an easy way to sort our DVDInfo objects, by title.
 */
class DVDInfo implements Comparable<DVDInfo>{
	String title;
	String genre;
	String leadActor;
	DVDInfo(String t, String g, String a) {
		title = t; 
		genre = g; 
		leadActor = a;
	}
	public int compareTo(DVDInfo d) {
		return genre.compareTo(d.genre); 
	}
	public String toString() {
		return title + "\t" + genre + "\t" + leadActor + "\n";
	}	
}

//Solution without using generics

/*class DVDInfo implements Comparable {
	String title;
	String genre;
	String leadActor;
	DVDInfo(String t, String g, String a) {
		title = t; 
		genre = g; 
		leadActor = a;
	}
	public int compareTo(Object o) { // takes an Object rather than a specific type
	DVDInfo d = (DVDInfo)o;
	return title.compareTo(d.getTitle());
	} }*/
	