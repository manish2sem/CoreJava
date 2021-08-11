package CoreJava.J_Advance.JUnitConcept;

/**
 * 1. Launch eclipse. If you do not see your bj4 project from assignment 7, follow these steps to set it up.
 * 
 * 2. Add junit to your project classpath:
 * 		Open the "Project" menu, chose the "Properties" command
 * 		In the "Properties for bj4" dialog, click "Java Build Path" at left
 * 		Select the "Libraries" tab, you will see a list of libraries currently in your project
 * 		Click "Add External JARs...", then drill into "plugins" and "org.junit_3.8.1", and select "junit.jar".
 * 		Click OK to select the junit.jar file, and OK to exit "Properties for bj4"
 * 
 * 2. Generate an initial test case from the application code
 * 		If you are not already in the "Java perspective", switch to it by using the icon with a "J" at the extreme left edge of the Eclipse window.
 * 		Select class "Hand.java" in the "package CoreJava.Explorer" view
 * 		Pop-up a menu on Hand.java and choose "New", "Other..."
 * 		In the "New" diaglogbox, expand "Java" and select "Junit" in the left pane, and "TestCase" in the right pane.
 * 		Click "Next >" and you will see the "JUnit Test Case" step
 * 		Select the checkboxes for setUp() and tearDown() then click "Next >"
 * 		In the "Test Methods" step, mark all the methods of Hand
 * 		Click Finish
You will now see a class definition for HandTest.java with one empty test method for each method in Hand.java.
Add member variable "public Hand testHand" to HandTest.java
Implement setUp() and tearDown() methods
In "public void setUp()" should set testHand to a new Hand object.
In "public void tearDown()" should set testHand to null.
Implement code for each test method
Each test method can use local variables to create cards, and call methods on testHand
Each test method should end with one or more calls to: assertTrue(condition), assertFalse(condition), assertEquals(object1, object2), assertNull(object), assertNonNull(object).
Remember that the ranks of cards are zero-based, so new Card(Card.CLUBS, 0) is an Ace, and new Card(Card.CLUBS, 3) is the "Four of clubs".
Also, remember that assertEquals() with Strings considers spacing, newlines, and capitalization.
Run the tests
Save your HandTest.java file
From the "Run" menu, choose "Run as" and "JUnit Test"
Or, you can choose "Debug as" and "JUnit Test"
You should see a new "JUnit" pane with a bright red and/or green progress bar that indicates how many tests have been passed succesfully.
If you have any test methods fail, correct HandTest.java (not Hand.java) and rerun the tests. If you don't know why a test method is failing, you can set a breakpoint and use the debugger.
Keep adding test methods until you are sure that you have 100% branch coverage of Hand.java:
You may add as many methods as you like.
Name each method testXXX were "XXX" is something descriptive.
Declare each test method as "public void" and with no arguments.
Cover the methods: addCard(), getValue(), busted(), and toString()
For each of those methods, create test cases that exercise all branches. I.e., both the "then" and "else" parts of every if-statement, and all loops should be both executed and skipped (meaning zero loop iterations).
If you run your junit tests and see error messages that look like "invoke0(Method, Object, Object[])line: not available [native method]" then you need to exit Eclipse and reload it.
 * @author Manish
 *
 */

public class JUnitWithEclipse {

}
