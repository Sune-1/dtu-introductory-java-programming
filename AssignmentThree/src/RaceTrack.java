import java.awt.Color;
import java.util.Arrays;
import java.util.Scanner;

public class RaceTrack {
    private static Scanner console = new Scanner(System.in);
    private static int[] startPosition;

    public static void main(String[] args) {
        int size = gridSize(console);
        initDraw(size);
        startPosition = new int[] { 0, size - size / 4  };
        runRaceTrackSimulation(size);
    }

    private static void runRaceTrackSimulation(int size) {
        // Arrays with x,y coordinate
        int[] currentPosition = startPosition;
        int[] prevPosition;
        int[] tempPrevPosition = null;

        int steps = 0;
        do {
            prevPosition = currentPosition;
            currentPosition = finalMove(tempPrevPosition != null ? tempPrevPosition : prevPosition, currentPosition, movementInteraction(console));
            drawCarMovement(currentPosition, prevPosition);
            tempPrevPosition = prevPosition;
            System.out.println(Arrays.toString(currentPosition));

            steps++;
        } while (!hasCrashed(size, currentPosition, steps));
    }

    private static boolean hasCrashed(int size, int[] position, int steps) {
        int corner = size/2;
    	int x = Math.abs(position[0]);
        int y = Math.abs(position[1]);

        if ((x - corner) <= 0 && (y - corner) <= 0) {
            System.out.println("You crashed inside boundary");
            return true;
        } else if (size <= x || size <= y) {
            System.out.println("You crashed! \nTotal number of steps = " + steps);
            return true;
        }
        return false;
    }


    private static int[] finalMove(int[] prevPosition, int[] currentPosition, int[] move) {
        System.out.println("prevPosition" + Arrays.toString(prevPosition));
        System.out.println("currentPosition" + Arrays.toString(currentPosition));
        System.out.println("move" + Arrays.toString(move));
        int y = currentPosition[1] + (currentPosition[1] - prevPosition[1] + move[1]);
        int x = currentPosition[0] + ((currentPosition[0] - prevPosition[0]) + move[0]);
        int[] newPosition = new int[] {x,y};
        System.out.println("newCoordinates" + Arrays.toString(newPosition));
        return newPosition;
    }


    private static void drawCarMovement(int[] currentPosition, int[] prevPosition) {
        int xCoordinate = currentPosition[0];
        int yCoordinate = currentPosition[1];
        int xPrevCoordinate = prevPosition[0];
        int yPrevCoordinate = prevPosition[1];
        StdDraw.line(xPrevCoordinate,yPrevCoordinate,xCoordinate,yCoordinate);
    }

    public static int[] movementInteraction(Scanner console) {
        int[] directionChoice;
        int move = console.nextInt();

        if (move == 8) {
            directionChoice = new int[] {0, 1};
        }else if (move == 2) {
            directionChoice = new int[] {0, -1};
        }else if (move == 6) {
            directionChoice = new int[] {1, 0};
        }else if (move == 4) {
            directionChoice = new int[] {-1, 0};
        }else if (move == 7) {
            directionChoice = new int[] {-1, 1};
        }else if (move == 9) {
            directionChoice = new int[] {1, 1};
        }else if (move == 1) {
            directionChoice = new int[] {-1, -1};
        }else if (move == 3) {
            directionChoice = new int[] {1, -1};
        }else if (move == 5) {
            directionChoice = new int[] {0, 0};
        }else {
            throw new IllegalStateException("Invalid move!");
        }
        return directionChoice;

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

}