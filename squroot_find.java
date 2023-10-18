public class squroot_find {
    public int divide(int dividend, int divisor) {
        // Handle edge cases where the result may overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result.
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;

        // Convert dividend and divisor to positive values for easier computation.
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        // Initialize the result and perform subtraction.
        long result = 0;
        while (ldividend >= ldivisor) {
            long temp = ldivisor;
            long multiple = 1;
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            ldividend -= temp;
            result += multiple;
        }

        // Apply the sign to the result and return it.
        return (int) (sign * result);
    }

    public static void main(String[] args) {
        squroot_find solution = new squroot_find();

        // Example 1
        int dividend1 = 10;
        int divisor1 = 3;
        int output1 = solution.divide(dividend1, divisor1);
        System.out.println(output1);  // Output: 3

        // Example 2
        int dividend2 = 7;
        int divisor2 = -3;
        int output2 = solution.divide(dividend2, divisor2);
        System.out.println(output2);  // Output: -2
    }
}
