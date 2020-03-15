import java.util.Scanner;

public class PrimeFactor {
	
	public static void main(String[] args) {
		
		long enteredNumber = readLong();
			if (enteredNumber <= 1) {
				System.out.println("Not a valid number");
			}
			convertNumber(enteredNumber);
			
	}
	
	private static long readLong() {
		System.out.println("Enter a positive integer to convert: ");
		Scanner console = new Scanner(System.in);
		long number = console.nextLong();
		return number;
	}
	
	private static void convertNumber(long number) {
		for(long i = 2; i < number; i++) {
			while(number%i == 0) {
				if (i*i > number) {
					break;
				}
					
				System.out.print(i + ", ");
				number = number/i;
			}
			
		}
		System.out.print(number);
	}
	
}
