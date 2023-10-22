class Solution {
    public int strStr(String haystack, String needle) {
        int i=0;
        int j=needle.length();
        while(i<=(haystack.length()-needle.length())){
            if(haystack.substring(i,i+j).equals(needle)){
                return i;
            }
            i++;

        }
        return -1;
        
    }
}
