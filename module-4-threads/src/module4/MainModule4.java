package module4;

	/* Name: Jack Oporto
	 * Class: COP3330C
	 * Professor Lisa Macon
	 * Assignment: Threads & Concurrency
	 * Date completed: June 8, 2020
	 * 
	 * Summary:
	 * This program demonstrates the use of multithreading
	 * In Java by having two Animals race each other at the same time,
	 * on independent threads. Both animals are passed in a food object
	 * that they will stop to consume every 3 loops.
	 * 
	 * What was fun about this exercise was the demonstration of two different
	 * layers of variance. 
	 * The first layer being the random time each animal
	 * sleeps between loops and the second being that every time an animal
	 * stops to eat, they both consume time by eating and prevent the other from progressing
	 * because only one animal can use the eat() method at once.
	 * 
	 * Known nitpick: If one of the animals wins while the other is eating, the winner text prints
	 * first and the "This animal ate for xxx ms." text prints after it.
	 */

public class MainModule4 {

	public static void main(String[] args) throws InterruptedException {

		//Creates the food object
		Food kibbles = new Food();
		
		//Creates the rabbit and turtle and passes in the food object
		Animal rabbit = new Animal("Rabbit", 0, 7, 800, kibbles);
		Animal turtle = new Animal("Turtle", 0, 3, 300, kibbles);

		//basic intro text
		welcome();
		
		//new rabbit user thread
		new Thread(rabbit).start();
		//new turtle user thread
		new Thread(turtle).start();	
	}

	
	public static void welcome() throws InterruptedException {
		System.out.println("Hello and welcome to the races!");
		System.out.println("Today the rabbit and turtle will race to see who is the fastest!");
		Thread.sleep(4000);
		System.out.println("Ready...");
		Thread.sleep(550);
		System.out.println("set...");
		Thread.sleep(500);
		System.out.println("Go!");
		Thread.sleep(300);
	}
}
