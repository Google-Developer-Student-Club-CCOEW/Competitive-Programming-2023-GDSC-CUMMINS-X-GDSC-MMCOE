class Solution {
    public String convertToTitle(int columnNumber) {
        
         StringBuilder ans = new StringBuilder();
        
        while (columnNumber > 0) {
            if (columnNumber % 26 == 0) {
                ans.append((char)('A' + 25));
                columnNumber -= 1;
            } else {
                ans.append((char)('A' + (columnNumber % 26) - 1));
            }
            columnNumber /= 26;
        }
        
        return ans.reverse().toString();
    }
}
