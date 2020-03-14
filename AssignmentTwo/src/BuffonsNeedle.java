import java.util.*;

public class BuffonsNeedle {
	public static void main(String[] args){
		runNeedleSimulation();
		
		
	}
	
	// This method calls all of methods below and prints the simulation result.
	private static void runNeedleSimulation() {
		int iterations = numbersOfIterations(new Scanner(System.in));
		int hits = needleSimulation(iterations);
		double pi = piCalculation(iterations, hits);
		System.out.println(pi);
		
		
	}
	
	//Prompts the user to enter the number of iterations to simulate. 
	public static int numbersOfIterations(Scanner console){
		System.out.println("Enter number of iterations: ");
		return console.nextInt();
		
	}
	
	//This method basically calculates the pi by dividing the number of iterations with number of hits. 
	public static double piCalculation(int iterations, int hits) {
		return ((double) (iterations))/((double) hits);
		
		
	}
	
	// This is the main method that creates random throws of needles and count the hits and misses. 
	public static int needleSimulation(int iterationsAmount) {
		int hitCounter = 0;
		int missCounter = 0;
		Random rand = new Random();
		
		// Main for loop for calculating the needles low point, angle and high point.
		for (int i = 0; i <= iterationsAmount; i++) {
			
			double needleLow = rand.nextDouble()*2;
			
			double needleAngle = Math.sin(Math.toRadians(rand.nextDouble()*180));
			
			double needleHigh = needleLow + needleAngle;
			
			// Statement for determining whether the needle throw is a hit or a miss and adding to counter accordingly
			if (needleHigh < 2) {
				missCounter++;
				
			} else {
				hitCounter++;

			}	
					
		}
		System.out.println("Number of misses: " + missCounter);
		System.out.println("Number of hits: " + hitCounter);
		return hitCounter;
	}
	
}

