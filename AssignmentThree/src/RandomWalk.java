import java.util.*;



public class RandomWalk {
	static Random rand = new Random();
	public static void main(String[] args){
		runRandomWalkSimulation();
	}
	
	private static void runRandomWalkSimulation() {
		int iterations = gridSize(new Scanner(System.in));
		walkSimulation(iterations);
	}
	
	public static int gridSize(Scanner console){
		System.out.println("Enter the size of the grid: ");
		return console.nextInt();
	}
	
	
	public static int [] getCoordinate(int[] prevCoordinates) {
		boolean randomChoice = rand.nextBoolean();
		boolean randomDirection = rand.nextBoolean();

		if (randomChoice) { // randomChoice == true
			if (randomDirection) {
				prevCoordinates[0] = prevCoordinates[0] += 1;
	
			}else {
				prevCoordinates[0] = prevCoordinates[0] -= 1;
			}
		
		}else {
			if (randomDirection) {
				prevCoordinates[1] = prevCoordinates[1] += 1;
			
			}else {
				prevCoordinates[1] = prevCoordinates[1] -= 1;
			}
			
		}
		return prevCoordinates;
	}

	
	public static void walkSimulation(int size) {
		StdDraw.setXscale(-size, size);
		StdDraw.setYscale(-size, size);
		StdDraw.setPenRadius(2.0/1000);
		
		int[] gridCoordinates = new int[] {0, 0};	
		int boundary = size + 1;
		int steps = 0;

		// Start coordinates
		printCoordinates(gridCoordinates[0], gridCoordinates[1]);
		StdDraw.point((double)gridCoordinates[0],(double)gridCoordinates[1]);

		while (true) {
			steps++;
			int [] coordinatesGenerated = getCoordinate(gridCoordinates);
			int xCoordinate = coordinatesGenerated[0];
			int yCoordinate = coordinatesGenerated[1];
			printCoordinates(xCoordinate,yCoordinate);
			StdDraw.point((double)xCoordinate,(double)yCoordinate);
			if ((boundary <= Math.abs(xCoordinate)) || boundary <= Math.abs(yCoordinate )) {
				System.out.println("Total number of steps = " + steps);
				break;
			}

		}
	}

	public static void printCoordinates(int x, int y) {
		System.out.println("Position = ("+x+","+y+")");
	}
	
}
