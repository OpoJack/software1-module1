package module4;
import java.util.Random;

public class Animal implements Runnable{

	private String name;
	private int position; //represents the position in the race for this Animal object
	private int speed;
	private int restMax; //represents how long the animal rests between each time it runs
	private static boolean winner = false;
	private Food kibbles;
	private int foodCounter = 0;
	
	public static boolean isWinner() {
		return winner;
	}

	public static void setWinner(boolean winner) {
		Animal.winner = winner;
	}

	@Override
	public void run() {
	    System.out.println("Runner away!");
	    
	    //I'm controlling this thread with this boolean.
	    //When a winner is set, running is set to false and it breaks out of the
	    //while loop.
	    boolean running = true;
	    
		while(running == true) {
		do {			
			/*This block encapsulates most of the method because I want it to 
			 * check its position to see if it has won before continuing.
			 */
			if((this.position >= 100 ) && (Animal.isWinner() == false)) {
				Animal.setWinner(true);
				System.out.println();
				System.out.println("The " + this.getName() + " completed the race at position " + this.getPosition() + "!");
				System.out.println("****************The " + this.getName() + " is the winner!****************");
			}else {
			//This block checks before printing that there is no winner
			if(Animal.isWinner() == false){
				System.out.println(this.toString());
			}
			
			//This calculates the position based on its current pos + its base speed
			this.position = (this.position + this.speed);
			
			
			//This sync block sleeps the thread for the random int 0~restMax
			synchronized(this) {
				  try {
					Thread.sleep(randomCooldown());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			
			//This block ensures that after 3 loops, the animal must rest and eat.
			//After executing, it resets the foodCounter to 0
			if((this.foodCounter == 3) && (Animal.isWinner() == false)) {
			synchronized(this) {
				  try {
					kibbles.eat(this, randomCooldown());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Thread.sleep(randomCooldown());
			  }
			this.foodCounter = 0;
			}
			
			this.foodCounter = (this.foodCounter + 1);
		}
					
		}while(Animal.isWinner() != true);
		
		//This kills the method loop and therefore the thread
		running = false;
		}
	}


	
	
	/*randomCooldown() generates a random number with an upper boundary
	 * dictated by restMax and */
	public int randomCooldown() throws InterruptedException {
		Random rand = new Random(); //instance of random class
	    int randomInt = rand.nextInt(this.getRestMax());
	    //System.out.println("this rested " + randomInt + " ms"); //DEBUG CODE
	    return randomInt;
	}
	
	

	public Animal(String name, int position, int speed, int restMax, Food kibbles) {
		super();
		this.name = name;
		this.position = position;
		this.speed = speed;
		this.restMax = restMax;
		this.kibbles = kibbles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRestMax() {
		return restMax;
	}

	public void setRestMax(int restMax) {
		this.restMax = restMax;
	}

	@Override
	public String toString() {
		String output = null;
		//This if/else block prints the same data on the left or right side for console readability
		if(this.getName() == "Rabbit") {
			output ="The " + this.getName() + " is in position " + this.position + "!";
		}else if(this.getName() == "Turtle") {
			output ="                                       The " + this.getName() + " is in position " + this.position + "!";
		}
		return output;
	}

	

	
}
