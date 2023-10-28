package hacktoberfest;
import java.util.*;

public class LongestStringChain {

	// Comparator to sort strings by length
    static Comparator<String> comp = (str1, str2) -> (str1.length() - str2.length());

    // Method to compare the strings to check if one can be transformed into the other
    static boolean compare(String s1, String s2) {
        if(s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while(first < s1.length()) {
            if((second < s2.length()) && (s1.charAt(first) == s2.charAt(second))) {
                first++;
                second++;
            }
            else {
                first++;
            }
        }

        // True if transformation is possible
        boolean res = (first == s1.length()) && (second == s2.length());
        
        return res;
    }

    // Method to find the length of the longest string chain
    static int longestStringChain(List<String> arr) {
    	
        int n = arr.size();

        // To sort the list of strings by length
        arr.sort(comp);

        // Array to store the length of longest chain ending at each string
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        // Dynamic programming to find the longest string chain
        for (int i = 0; i < n; i++) {
            for (int prevIdx = 0; prevIdx < i; prevIdx++) {
                if (compare(arr.get(i), arr.get(prevIdx)) && 1 + dp[prevIdx] > dp[i]) {
                    dp[i] = 1 + dp[prevIdx];
                }
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    // Driver Code
    public static void main(String[] args) {
    	
    	String[] arr = {"a", "b", "ba", "bca", "bda", "bdca"};
    	
        List<String> words = Arrays.asList(arr);
        
        // Calculate the length of the longest string chain
        int ans = longestStringChain(words);

        // Print the answer
        System.out.println("The length of the longest string chain is = " + ans);
    }
}