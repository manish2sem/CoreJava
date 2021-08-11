package DessignPattern.HeadFirst.Observer;

/**
 * Visualization : Newspaper Subscription
 * 		- A Newspaper publisher goes into business and begins publishing newspaper.
 * 		- You subscribe to the publisher and every time there is a new edition it gets delivered to you.
 * 		- As long as you remain a subscriber you get new newapaper.
 * 		- You unsubscribe when you dont want itand they stop being delivered.
 * 		- While the publisher remains in business other people constantly subscribe and unsubscribe to the newspaper.
 * 
 * Observer Pattern = SUBJECT(publisher) + OBSERVERS(subscribers)
 * 
 * Subject contain the state and controls it, Observer use the state even if they don't own it.
 * Observers are dependent on Subject to update them when the data changes. 
 * This leads to the cleaner OO design.
 * 
 * Subject and objects are loosely coupled.
 * Power of loose coupling : 
 * 	- We can add new observers at any time, and to accommodate this subject code is not required to modify.
 *  - Subject as well as Object can be reused independent of each other.
 *  - Changes to either of them will not affect the other.
 *  - Subject is not required to know any thing about Observer except that it implements a certain interface (Observer)
 * 
 * DESIGN PRINCIPLE - Loosely coupled system.
 * 
 * One Liner - It is observer IF through which SUBJECT and OBSERVER interact.
 * 			 - Subject operates on all methods of observer IF (mainle update) to notify Observer.
 * 			 - Observer compulsory implements observer IF and register itself to Subject to get notified.  
 *
 */

public class Observer {

}
