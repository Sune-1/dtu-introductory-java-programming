import java.util.Arrays;
import java.util.Scanner;

public class RaceTrack {
	static Scanner console = new Scanner(System.in);

	static final int MOVE_UPPER_LEFT = 7;
	static final int MOVE_UPPER_RIGHT = 9;
	static final int MOVE_DOWN_LEFT = 1;
	static final int MOVE_DOWN_RIGHT = 3;
	static final int MOVE_UP = 8;
	static final int MOVE_DOWN = 2;
	static final int MOVE_RIGHT = 6;
	static final int MOVE_LEFT = 4;
	
	static int acceleration = 1;

	public static void main(String[] args) {
		runRaceTrackSimulation();
	}

	private static void runRaceTrackSimulation() {
		int[] coordinates = new int[] { 0, 0 };				
		int size = gridSize(console);
		StdDraw.setXscale(-size, size);
		StdDraw.setYscale(-size, size);
		StdDraw.setPenRadius(2.0/1000);
		StdDraw.line(0,0,0,0);
		int prevMove = 0;
		int move = 0;
		int steps = 0;
		while (true) {
			steps++;
			int xPrevCoordinate = coordinates[0];
			int yPrevCoordinate = coordinates[1];
			prevMove = move;
			move = console.nextInt();
			coordinates = getMovementCoordinates(coordinates, move, prevMove);
			int xCoordinate = coordinates[0];
			int yCoordinate = coordinates[1];
			StdDraw.line(xPrevCoordinate,yPrevCoordinate,xCoordinate,yCoordinate);
			System.out.println(Arrays.toString(coordinates));
			if ((size <= Math.abs(coordinates[0])) || size <= Math.abs(coordinates[1])) {
				System.out.println("Total number of steps = " + steps);
				break;
			}

		}
		// walkSimulation(iterations);
	}

	public static int gridSize(Scanner console) {
		System.out.println("Enter the size of the track: ");
		return console.nextInt();
	}

//	public static int [][] getCoordinate(int size) {
//		int[][] grid = new int[size+1][2];
//		
//		
//		
//		for(int k = 0; k <= size; k++) {
//			for(int i=k; i <= size; i++) {
//				grid[i][0] = i;
//			}	
//		}
//
//		
//		
//		for(int j =0; j<=size; j++) {
//			grid[j][1] = j;
//		}
//		System.out.println("Coordinate bc: " + "\n"+ Arrays.deepToString(grid));
//		return grid;
//	}

	public static int[] getMovementCoordinates(int[] prevCoordinates, int move, int prevMove) {
		if (MOVE_UP == move) {
			if (prevMove == MOVE_DOWN) {
				if (acceleration != 1) {
					acceleration--;
				}
				prevCoordinates[1] = prevCoordinates[1] = acceleration;
			} else if (prevMove == move) {
				acceleration++;
				prevCoordinates[1] = prevCoordinates[1] += acceleration;
			} else {
				acceleration = 1;
				prevCoordinates[1] = prevCoordinates[1] += 1;
			}

		} else if (MOVE_DOWN == move) {
			prevCoordinates[1] = prevCoordinates[1] -= 1;
		} else if (MOVE_RIGHT == move) {
			prevCoordinates[0] = prevCoordinates[0] += 1;
		} else if (MOVE_LEFT == move) {
			prevCoordinates[0] = prevCoordinates[0] -= 1;
		} else if (MOVE_UPPER_LEFT == move) {
			prevCoordinates[0] = prevCoordinates[0] -= 1;
			prevCoordinates[1] = prevCoordinates[1] += 1;
		} else if (MOVE_UPPER_RIGHT == move) {
			prevCoordinates[0] = prevCoordinates[0] += 1;
			prevCoordinates[1] = prevCoordinates[1] += 1;
		} else if (MOVE_DOWN_LEFT == move) {
			prevCoordinates[0] = prevCoordinates[0] -= 1;
			prevCoordinates[1] = prevCoordinates[1] -= 1;
		} else if (MOVE_DOWN_RIGHT == move) {
			prevCoordinates[0] = prevCoordinates[0] += 1;
			prevCoordinates[1] = prevCoordinates[1] -= 1;
		} else {
			throw new IllegalStateException("Invalid move!");
		}
		return prevCoordinates;
	}


}
