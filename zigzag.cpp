#include <iostream>
#include <string>
#include <vector>

using namespace std;

string convert(string s, int numRows) {
    if (numRows == 1 || numRows >= s.length()) {
        return s;
    }

    vector<string> rows(min(numRows, int(s.length())));
    int currentRow = 0;
    bool goingDown = false;

    for (char c : s) {
        rows[currentRow] += c;
        if (currentRow == 0 || currentRow == numRows - 1) {
            goingDown = !goingDown;
        }
        currentRow += goingDown ? 1 : -1;
    }

    string result;
    for (const string& row : rows) {
        result += row;
    }

    return result;
}

int main() {
    string s1 = "PAYPALISHIRING";
    int numRows1 = 3;
    string result1 = convert(s1, numRows1);
    cout << "Input: " << s1 << ", numRows: " << numRows1 << endl;
    cout << "Output: " << result1 << endl;

    string s2 = "PAYPALISHIRING";
    int numRows2 = 4;
    string result2 = convert(s2, numRows2);
    cout << "Input: " << s2 << ", numRows: " << numRows2 << endl;
    cout << "Output: " << result2 << endl;

    string s3 = "A";
    int numRows3 = 1;
    string result3 = convert(s3, numRows3);
    cout << "Input: " << s3 << ", numRows: " << numRows3 << endl;
    cout << "Output: " << result3 << endl;

    return 0;
}
