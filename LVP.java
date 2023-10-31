public class LVP {
    private static int longestValidP(String str) {
        int count = 0;       
        int left = 0;       
        int right = 0;       
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            if (left == right) {
                count = Math.max(count, left + right);
            }
            if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '(') {
                left++;
            }
            if (c == ')') {
                right++;
            }
            if (left == right) {
                count = Math.max(count, left + right);
            }
            if (left > right) {
                left = right = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str1 = "(()";
        System.out.println(longestValidP(str1));

        str1 = ")()())";
        System.out.println(longestValidP(str1));

        str1 = "";
        System.out.println(longestValidP(str1));
    }
}