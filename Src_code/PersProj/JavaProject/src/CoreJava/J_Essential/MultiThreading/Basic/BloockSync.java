package CoreJava.J_Essential.MultiThreading.Basic;

/**
 * Waiting/blocked/sleeping This is the state a thread is in when it's not eligible to run.
 * A thread may be blocked waiting for a resource (like I/O or an object's lock), 
 * in which case the event that sends it back to runnable is the availability of the resource.
 * for example, if data comes in through the input stream the thread code is reading from, or 
 * if the object's lock suddenly becomes available.
 * 
 * A thread may be sleeping because the thread's run code tells it to sleep for some period of time, 
 * in which case the event that sends it back to runnable is that it wakes up because its sleep time has expired.
 * 
 * Or the thread may be waiting, because the thread's run code causes it to wait, 
 * in which case the event that sends it back to runnable is that another thread sends a notification 
 * that it may no longer be necessary for the thread to wait.
 * 
 * The important point is that one thread does not tell another thread to block.
 * 
 * Just because a thread’s sleep() expires, and it wakes up, does not mean it will return to running! 
 * 		- When a thread wakes up, it simply goes back to the runnable state. 
 * 		- So the time specified in sleep() is the minimum duration in which the thread won’t run,
 * 		  but it is not the exact duration in which the thread won’t run.
 * 
 * Remember that sleep() is a static method, so don't be fooled into thinking that 
 * one thread can put another thread to sleep. 
 * You can put sleep() code anywhere, since all code is being run by some thread. 
 * When the executing code hits a sleep() call, it puts the currently running thread to sleep.
 * @author Manish
 *
 */

public class BloockSync {

}
