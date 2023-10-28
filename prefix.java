import java.util.*;
import java.lang.*;
import java.io.*;

class prefix {
    public static String commonPrefixUtil(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();
 
        for (int i = 0, j = 0; i <= n1 - 1 &&
                j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }
        return (result);
    }
    public static String longestCommonPrefix(String S[], int low, int high) {
        if (low == high) {
            return (S[low]);
        }
 
        if (high > low) {
            int mid = low + (high - low) / 2;
 
            String str1 = longestCommonPrefix(S, low, mid);
            String str2 = longestCommonPrefix(S, mid + 1, high);
 
            return (commonPrefixUtil(str1, str2));
        }
        return null;
    }

    public static void main(String args[]) {
        // Your code goes here
        String s[] = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(s, 0, 2));
    }
}