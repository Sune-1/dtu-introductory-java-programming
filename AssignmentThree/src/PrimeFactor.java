import java.util.Scanner;

public class PrimeFactor {
	
	public static void main(String[] args) {
		runPrimFactor();
	}
	
	private static void runPrimFactor() {
		System.out.println("Enter the number of times you wish to run the Prim Factor programme: ");
		Scanner console = new Scanner(System.in);
		long runNumber = console.nextLong();
		
		for(long i = 1; i <= runNumber; i++ ) {
			System.out.println("Enter a positive integer to convert: ");
			long number = console.nextLong();
			
			if (number > 1) {
				calculatePrimeFactor(number);
			}else if(number <= 1) {
				System.out.println("Not a valid number - Try again!");
				number = console.nextLong();
				calculatePrimeFactor(number);
			}else if (number == 0) {
				break;
			}else {
			}	
		}
	}
	
	
	private static void calculatePrimeFactor(long number) {
		for(long i = 2; i < number; i++) {
			while(number%i == 0) {
				if (i*i > number) {
					break;
				}
				System.out.print(i + ", ");
				number = number/i;
			}
		}
		System.out.println(number);
	}
}
