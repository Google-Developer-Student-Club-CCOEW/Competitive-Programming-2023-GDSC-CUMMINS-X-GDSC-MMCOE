public class count_negativematrix {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                count += m - row;
                col--;
            } else {
                row++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        count_negativematrix solution = new count_negativematrix();

        // Example 1
        int[][] grid1 = {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
        };
        int output1 = solution.countNegatives(grid1);
        System.out.println(output1);  // Output: 8

        // Example 2
        int[][] grid2 = {
            {3, 2},
            {1, 0}
        };
        int output2 = solution.countNegatives(grid2);
        System.out.println(output2);  // Output: 0
    }
}
