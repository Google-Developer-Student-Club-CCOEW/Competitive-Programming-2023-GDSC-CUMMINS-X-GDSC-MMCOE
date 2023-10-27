package hacktoberfest;
import java.util.*;

public class LetterCombinationsOfPhoneNo {

	// Method to generate letter combinations 
	public static List<String> letterCombinations(String digits) {
		
        if(digits.isEmpty()) {
        	return Collections.emptyList();
        }

        String[] digit_to_letter = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        // To store the resulting letter combinations
        List<String> result = new ArrayList<>();
        
        // Start Backtracking
        backtrack("", digits, digit_to_letter, result);
        
        return result;
    }

	// Recursive method to backtrack and generate letter combinations
    private static void backtrack(String combination, String next_digits, String[] digit_to_letter, List<String> result) {
    	
    	// Get the letters corresponding to the first digit
        if(next_digits.isEmpty()) {
        	result.add(combination);
        }
        else {
            String letters = digit_to_letter[next_digits.charAt(0) - '2'];
            for(char alphabet : letters.toCharArray()) {
            	// Recursively look for all possible combinations
                backtrack(combination + alphabet, next_digits.substring(1), digit_to_letter, result);
            }
        }
    }
	
    // Driver Code
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// User input
		System.out.print("Enter the string of digits: ");
		String digits = sc.next();
		
		// Call the function
		List<String> ans = letterCombinations(digits);

		// Print all the combinations
		System.out.print("Letter Combinations: ");
		for(String s : ans) {
			System.out.print("\"" + s + "\" ");
		}
		
		// Close the scanner
		sc.close();
	}

}