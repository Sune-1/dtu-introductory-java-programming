import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args){ 
		palindromeAnalyzer(new Scanner(System.in));
		
	}
	
	
	public static void palindromeAnalyzer(Scanner console){
		System.out.print("Enter line to check: ");

		String palindromeSentence = console.nextLine();
		
		String temp = palindromeSentence.replaceAll("[^a-zæøåA-ZÆØÅ]","").toLowerCase();


		for (int i = 0, j = temp.length() - 1; i < temp.length(); i++) {
			
			
			
			if (temp.charAt(i) == temp.charAt(j)) {
				
				if(i == temp.length()-1) {
					System.out.print(palindromeSentence + " - is a palindrome!");
				}				
				
			} else {
				
				System.out.println(palindromeSentence + " - is not a palindrome!");
				return;
				
			}

			
			j--;
			
		}
		
				
		
		
	}

}


