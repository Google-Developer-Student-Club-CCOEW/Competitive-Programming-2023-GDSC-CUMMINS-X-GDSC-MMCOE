class Solution {
    public char findTheDifference(String s, String t) {
    char[] sortedS = s.toCharArray();
    char[] sortedT = t.toCharArray();
    Arrays.sort(sortedS);
    Arrays.sort(sortedT);
    for(int i=0;i<s.length();i++){
      if (sortedS[i] != sortedT[i]) {
        return sortedT[i];
      }
    }
    return sortedT[s.length()];
    }
}

/***
Test Case 1 : 
Input
s =
"abcd"
t =
"abcde"
Output
"e"
Expected
"e"

Test Case 2 : 
Input
s =
""
t =
"y"
Output
"y"
Expected
"y"
 */
