package CoreConcepts.ClassLoading;

/**
 * 
When you trigger >java StackAndHeapMemory
java command loads ths class  StackAndHeapMemory in  method area of memory.
	- all static blocks are executed.
Randomly one object is created in the heap memory.
All static members are loaded into class memory. 
java commands calls main() method for execution.
main() method enters stack memory for execution. First statement in main() method (Line 16) is executed. 
methodOne() enters the stack for execution. First statement (Line 5) of methodOne() is executed first.
methodTwo() enters the stack for execution. 
ontrol comes back to methodOne() after execution of methodTwo()
 control comes back to main() method after execution of methodOne()
main() method leaves stack after clearing the heap memory
java command also leaves stack memory and gives back the allocated memory to OS.

 * @author Manish
 *
 */

class A_StackAndHeapMemory
{
	static 
    {
         System.out.println("This is static block");
         
    }
	
	static void methodOne()
     {
          System.out.println("From Method One");
          methodTwo();
     }
 
     static void methodTwo()
     {
          System.out.println("From Method Two");
     }
 
     public static void main(String[] args)
     {
          System.out.println("Main Method Started");
          methodOne();
          System.out.println("Main Method Ended");
     }
}