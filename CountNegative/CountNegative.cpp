#include <bits/stdc++.h>
using namespace std;


int countNegatives(vector<vector<int>>& matrix) {
    int m = matrix.size();    // Number of rows
    int n = matrix[0].size(); // Number of columns
    int count = 0;          // Initialize the count of negative numbers

    // Start from the bottom-left corner of the matrix
    int row = m - 1;
    int col = 0;

    while (row >= 0 && col < n) {
        if (matrix[row][col] < 0) {
            // If the current element is negative, then all the elements to the right
            // of it in the same row will also be negative, so we increment the count
            count += (n - col);
            row--; // Move up to check the next row
        } else {
            col++; // Move right to check the next column
        }
    }

    return count;
}

int main() {
    int m, n;
    cout << "Enter the number of rows: ";
    cin >> m;
    cout << "Enter the number of columns: ";
    cin >> n;

    vector<vector<int>> matrix(m, vector<int>(n));

    cout << "Enter the elements of the grid row by row:" << endl;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            cin >> matrix[i][j];
        }
    }

    int result = countNegatives(matrix);
    cout << "Number of negative numbers: " << result << endl;

    return 0;
}
