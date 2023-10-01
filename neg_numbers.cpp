#include <bits/stdc++.h>

using namespace std;

int main()
{
    int m, n;
    cout << "\nEnter the number of rows in the matrix : ";
    cin >> m;
    cout << "\nEnter the number of columns in the matrix : ";
    cin >> n;
    int arr[m][n];
    cout << "\nEnter the matrix :\n";
    int count = 0;
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> arr[i][j];
            if (arr[i][j] < 0)
            {
                count++;
            }
        }
    }
    cout << "\nThe number of negative numbers in the matrix is : " << count << endl;
    return 0;
}