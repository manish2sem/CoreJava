package CoreJava.J_Advance.Log4jConcept;

import java.util.logging.Level;

import org.apache.log4j.Logger;

/**
 * Logging level can be set in configuration file as - log4j.rootLogger = WARN
 * Once WARN is set here, all the DEBUG and INFO messages will be filter out.
 * Only Warn and above log message will be displayed.
 * 
 * Same can be achieved through code.
 * Even through code logging level can be changed dynamically.

 * Logging level precedent :  ALL < DEBUG < TRACE < INFO < WARN < ERROR < FATAL < OFF.
 *
 */

public class B_ChangeLoogingLevelDynamically {

	static Logger log = Logger.getLogger(B_ChangeLoogingLevelDynamically.class.getName());

	public static void main(String[] args){
		log.info("Changing log4j lvel Dynamically.");
		levelDebug();		
		levelWarn();		
	}
	
	static void levelDebug(){
		System.out.println("inside Debug ......");	
		log.setLevel(log.getLevel().DEBUG);
		commonLogMsg();		
		System.out.println("Leaving Debug ");
	}
	
	static void levelWarn(){
		System.out.println("inside WARN ......");
		log.setLevel(log.getLevel().DEBUG.WARN);
		commonLogMsg();		
		System.out.println("Leaving Warn ");
		
	}
	
	static void commonLogMsg(){
		log.debug("Hello this is an debug message");
		log.trace("Hello this is TRACE message");
		log.info("Hello this is an info message");
		log.warn("Hello this is an warn message");
		log.error("Hello this is an error message");
		log.fatal("Hello this is an fatal message");
		
	}



}
