package DessignPattern.Other.factory;

/**
 *  @author Manish
 *  
 *  Factory Design pattern is based on Encapsulation object oriented concept. 
 *  Factory method is used to create different object from factory Item and it encapsulate the creation code. 
 *  So instead of having object creation code on client side we encapsulate inside Factory method in Java.
 *  
 *  One of the best examples of factory pattern in Java is BorderFactory Class of Swing API.
 *  Spring, Struts and Apache along with decorator design pattern in Java. 

 *
 */


public class MainFactory {
	public static void main(String args[])	{
		NameFactory nFact = new NameFactory();
		Namer frst  = nFact.getNamer("entry");
		Namer frst2  = nFact.getNamer("entry1, entry2");
		System.out.println("frst : " + frst.getLast());
		System.out.println("frst2 : " + frst2.getFirst());	
	}
}

class Namer {
	//a simple class to take a string apart into two names
	protected String last; //store last name here`
	protected String first; //store first name here

	public String getFirst() {
		return first; //return first name
	}

	public String getLast() {
		return last; //return last name
	}

	public String toString()
	{
		return "In side Namer";
	}
}


class FirstFirst extends Namer { //split first last
	public FirstFirst(String s) {
		int i = s.lastIndexOf(" "); //find separator space
		System.out.println("FirstFirst");
		if (i > 0) {
			//left is first name
			first = s.substring(0, i).trim();
			//right is last name
			last =s.substring(i+1).trim();
		}else {
			first = ""; // put all in last name
			last = s; // if no space
		}
	}
}


class LastFirst extends Namer { //split last, first
	public LastFirst(String s) {
		int i = s.indexOf(","); //find comma
		System.out.println("LastFirst");
		if (i > 0) {
			//left is last name
			last = s.substring(0, i).trim();
			//right is first name
			first = s.substring(i + 1).trim();
		}else {
			last = s; // put all in last name
			first = ""; // if no comma
		}
	}
}


class NameFactory {
	//returns an instance of LastFirst or FirstFirst
	//depending on whether a comma is found
	public Namer getNamer(String entry) {
		int i = entry.indexOf(","); //comma determines name	order
		if (i>0)
			return new LastFirst(entry); //return one class
		else
			return new FirstFirst(entry); //or the other
	}
}

