package module4;

public class Food {

	private int restMax;
	
	public Food() {
	}

	
	/* The following method passes in the animal using it and the restTime
	 * generated in the respective animal object.
	 * 
	 */
	public synchronized void eat(Animal thisAnimal, int restTime) {
		//This if/else block prints the same data on the left or right side for console readability
		if(thisAnimal.getName() == "Rabbit") {
			System.out.println("The " + thisAnimal.getName() + " is eating!");
		}else if(thisAnimal.getName() == "Turtle") {
			System.out.println("                                       The " + thisAnimal.getName() + " is eating!");
		}
		
		//This if block confirms that this animal's position is < 100 and that there isn't a winner yet
		if((thisAnimal.getPosition() < 100 ) && (Animal.isWinner() == false)) {
		try {
			//restTime has already been randomized according to restMax in the animal object
			Thread.sleep(restTime);
			//This if/else block prints the same data on the left or right side for console readability
			if(thisAnimal.getName() == "Rabbit") {
				System.out.println("This " + thisAnimal.getName() + " ate for " + restTime + "ms.");
			}else if(thisAnimal.getName() == "Turtle") {
				System.out.println("                                       This " + thisAnimal.getName() + " ate for " + restTime + "ms.");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}//end big if
	}// end eat()
	
	
	public int getRestMax() {
		return restMax;
	}

	public void setRestMax(int restMax) {
		this.restMax = restMax;
	}
}
