import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;

public class RaceTrack {
	static Scanner console = new Scanner(System.in);

	static final int MOVE_NORTH_WEST = 7;
	static final int MOVE_NORTH_EAST = 9;
	static final int MOVE_SOUTH_WEST = 1;
	static final int MOVE_SOUTH_EAST = 3;
	static final int MOVE_NORTH = 8;
	static final int MOVE_SOUTH = 2;
	static final int MOVE_EAST = 6;
	static final int MOVE_WEST = 4;
	
	static int[] principlePoint = new int[] {0, 0};
	static int[] NORTH = new int[] {0, 1};
	static int[] SOUTH = new int[] {0, -1};
	static int[] EAST = new int[] {1, 0};
	static int[] WEST = new int[] {-1, 0};
	static int[] NORTH_EAST = new int[] {1, 1};
	static int[] NORTH_WEST = new int[] {-1, 1};
	static int[] SOUTH_EAST = new int[] {1, -1};
	static int[] SOUTH_WEST = new int[] {-1, -1};
	
	static int acceleration = 1;

	public static void main(String[] args) {
		runRaceTrackSimulation();
	}

	private static void runRaceTrackSimulation() {
		int size = gridSize(console);
		int[] coordinates = new int[] { 0, size - size / 4  };				
		initDraw(size);
		int prevMove = 0;
		int move = 0;
		int steps = 0;
		while (true) {
			steps++;
			int xPrevCoordinate = coordinates[0];
			int yPrevCoordinate = coordinates[1];
			int[] prevCoordinates = coordinates;
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

	/**
	 * Initializes StdDraw with the
	 * Race Track configuration
	 * @param size
	 */
	private static void initDraw(int size) {
		StdDraw.setXscale(-size, size);
		StdDraw.setYscale(-size, size);
		StdDraw.setPenRadius(2.0/1000);
		StdDraw.setPenColor(Color.green);
		StdDraw.line(0,size/2,0,size);
		StdDraw.setPenColor(Color.black);
		StdDraw.square(0,0,size);
		StdDraw.filledSquare(0,0,size/2);
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

	
	
	public static int[] direction(int direction, int prevDirection, int[] prevCoordinates) {
//		if (direction == prevDirection) {
//			acceleration++;
//		} else if ()
//		
//		if (prevDirection == MOVE_DOWN) {
//			if (acceleration != 1) {
//				acceleration--;
//			}
//			prevCoordinates[1] = prevCoordinates[1] = acceleration;
//		} else 
//			prevCoordinates[1] = prevCoordinates[1] += acceleration;
//		} else {
//			acceleration = 1;
//		
		return null;
	}
	
	public static int[] getMovementCoordinates(int[] prevCoordinates, int direction, int prevDirection) {


		if (MOVE_NORTH == direction) {

		} else if (MOVE_SOUTH == direction) {
			prevCoordinates[1] = prevCoordinates[1] -= 1;
		} else if (MOVE_EAST == direction) {

		} else if (MOVE_WEST == direction) {
			prevCoordinates[0] = prevCoordinates[0] -= 1;
		} else if (MOVE_NORTH_WEST == direction) {
			prevCoordinates[0] = prevCoordinates[0] -= 1;
			prevCoordinates[1] = prevCoordinates[1] += 1;
		} else if (MOVE_NORTH_EAST == direction) {
			prevCoordinates[0] = prevCoordinates[0] += 1;
			prevCoordinates[1] = prevCoordinates[1] += 1;
		} else if (MOVE_SOUTH_WEST == direction) {
			prevCoordinates[0] = prevCoordinates[0] -= 1;
			prevCoordinates[1] = prevCoordinates[1] -= 1;
		} else if (MOVE_SOUTH_EAST  == direction) {
			prevCoordinates[0] = prevCoordinates[0] += 1;
			prevCoordinates[1] = prevCoordinates[1] -= 1;
		} else {
			throw new IllegalStateException("Invalid move!");
		}
		return prevCoordinates;
	}
	
	
	
//	public static int[] getMovementCoordinates(int[] prevCoordinates, int direction, int prevDirection) {
//		if (direction == prevDirection) {
//			acceleration++;
//		} else {
//			acceleration--;
//		}
//
//		if (MOVE_NORTH == direction) {
//			if (acceleration > 1) {
//				if (prevCoordinates[1] < 0) {
//					 prevCoordinates[1] -= -acceleration;
//				} else {
//					prevCoordinates[1] = prevCoordinates[1] += acceleration;
//				}
//			} else {
//				prevCoordinates[1] = prevCoordinates[1] += acceleration;	
//			}
//		} else if (MOVE_SOUTH == direction) {
//			prevCoordinates[1] = prevCoordinates[1] -= 1;
//		} else if (MOVE_EAST == direction) {
//			if (acceleration > 1) {
//				if (prevCoordinates[0] < 0) {
//					 prevCoordinates[0] -= -acceleration;
//				} else {
//					prevCoordinates[0] = prevCoordinates[0] += acceleration;
//				}
//			} else {
//				prevCoordinates[0] = prevCoordinates[0] += acceleration;	
//			}
//			
//		} else if (MOVE_WEST == direction) {
//			prevCoordinates[0] = prevCoordinates[0] -= 1;
//		} else if (MOVE_NORTH_WEST == direction) {
//			prevCoordinates[0] = prevCoordinates[0] -= 1;
//			prevCoordinates[1] = prevCoordinates[1] += 1;
//		} else if (MOVE_NORTH_EAST == direction) {
//			prevCoordinates[0] = prevCoordinates[0] += 1;
//			prevCoordinates[1] = prevCoordinates[1] += 1;
//		} else if (MOVE_SOUTH_WEST == direction) {
//			prevCoordinates[0] = prevCoordinates[0] -= 1;
//			prevCoordinates[1] = prevCoordinates[1] -= 1;
//		} else if (MOVE_SOUTH_EAST  == direction) {
//			prevCoordinates[0] = prevCoordinates[0] += 1;
//			prevCoordinates[1] = prevCoordinates[1] -= 1;
//		} else {
//			throw new IllegalStateException("Invalid move!");
//		}
//		return prevCoordinates;
//	}


}


