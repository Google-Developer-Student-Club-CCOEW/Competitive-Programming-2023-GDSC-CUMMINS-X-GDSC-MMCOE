class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        if(s.equals(goal)) {
            int mask = 0;
            for(int i = 0; i < s.length(); i ++) {
                int ind = 1 << (s.charAt(i) - 'a');
                if((mask & ind) != 0) return true;
                mask |= ind;
            }
            return false;
        }
        int ct = 0;
        int mask1 = 0;
        int mask2 = 0;
        for(int i = 0; i < goal.length(); i ++) {
            if(goal.charAt(i) != s.charAt(i)) {
                ct ++;
                int ind = 1 << (s.charAt(i) - 'a');
                if((mask1 & ind) != 0) return false;
                mask1 += ind;
                ind = 1 << (goal.charAt(i) - 'a');
                if((mask2 & ind) != 0) return false;
                mask2 += ind;
            }
            if(ct > 2) return false;
        }
        if(ct != 2) return false;
        return (mask1 ^ mask2) == 0;
    }
}
