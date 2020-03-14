import java.util.*;

public class RomanNumerals {

	public static void main(String[] args) {
		/*int x = 9;
		x /=10;
		System.out.println(x);*/
		int enteredNumber = readInteger();
		if (enteredNumber <= 0 || enteredNumber > 3999 ) {
			System.out.println("Not a valid number");
			return;
		} //If the if statement is false, the method will continue to run.
		System.out.println(convertNumber(enteredNumber));
	}
	private static int readInteger() {
		System.out.print("Enter positive integer to convert: ");
		Scanner console = new Scanner(System.in);
		int number = console.nextInt();
		return number;
	}
	private static String convertNumber(int number) {
		// The method converts the number by using mod and the method calculateRomanDigit.
		String ones = calculateRomanDigit(number%10, "I", "V", "X");
		number /=10;
		String tens = calculateRomanDigit(number%10, "X", "L", "C");
		number /=10;
		String hundreds = calculateRomanDigit(number%10, "C", "D", "M");
		number /=10;
		String thousands = calculateRomanDigit(number%10, "M", "", "");
		return thousands+hundreds+tens+ones;
	}
	// This method is used for returning the roman numbers in their correct orders. 
	private static String calculateRomanDigit(int x, String one, String five, String ten) {
		if (x >= 1) {
			if (x == 1) {
				return one;
			}
			else if(x == 2) {
				return one + one;
			}
			else if	(x == 3) {
				return one+one+one;
			}
			else if (x == 4) {
				return one+five;
			}
			else if (x==5) {
				return five;
			}
			else if (x==6) {
				return five+one;
			}
			else if (x==7) {
				return five+one+one;
			}
			else if (x==8) {
				return one+one+ten;
			}
			else if (x==9) {
				return one+ten;
			}
			else if (x==10) {
				return ten;
			}
		}
		
		return "";
	}
}
