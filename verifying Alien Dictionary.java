class Solution {
    public boolean isAlienSorted(String[] words, String order) {
    for (int i = 1; i < words.length; ++i)
            if (helper(words[i - 1], words[i], order) > 0) return false;
        return true;
    }

    int helper(String s, String t, String order) {
        int l1 = s.length(), l2 = t.length();
        for (int i = 0; i < l1 && i < l2; ++i) {
            int diff = order.indexOf(s.charAt(i)) - order.indexOf(t.charAt(i));
            if (diff != 0) return diff;
        }
        return l1 - l2;
    }
}
