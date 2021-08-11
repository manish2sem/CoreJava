package CoreJava.J_Elementry.enumConcepts.Basic;

/**
 * Enums can be declared as their own separate class, as in this example or  
 * as a class member,
 * However they must not be declared within a method!
 *
 * The basic components of an enum are its constants.
 * it is optional to put a semicolon at the end of the enum declaration.
 * 
 * The most important thing to remember is that enums are not Strings or ints! 
 * Each of the enumerated CoffeeSize types are actually instances of CoffeeSize. In other words, BIG is of type CoffeeSize.
 * 
 * The order in which enum values are declared matters.
 * You can think of the CoffeeSize enums as existing in an array of type CoffeeSize, and 
 * you can iterate through the values of an enum by invoking the values() method on any enum type.
 * 
 */

/**
 * Declaring Enum outside a class - 
 * Enum cannot be private or protected
 */

public enum A_CoffeeSize {BIG, HUGE, OVERWHELMING}
