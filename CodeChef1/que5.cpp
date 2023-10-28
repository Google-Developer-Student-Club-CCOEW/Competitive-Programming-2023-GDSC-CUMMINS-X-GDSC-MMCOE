//Variation
//Problem Code:ZCO15002

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int N, K;
    cin >> N >> K;

    vector<int> sequence(N);

    for (int i = 0; i < N; i++) {
        cin >> sequence[i];
    }

    sort(sequence.begin(), sequence.end());

    int totalVariationCount = 0;

    for (int i = 0; i < N; i++) {
        for (int j = i + 1; j < N; j++) {
            if (abs(sequence[j] - sequence[i]) >= K) {
                totalVariationCount++;
            }
        }
    }

    cout << totalVariationCount << endl;

    return 0;
}
