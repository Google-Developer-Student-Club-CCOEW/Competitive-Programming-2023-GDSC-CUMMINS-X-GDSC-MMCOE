//End of corruption
//Problem Code:ENDCORR

#include <iostream>
#include <queue>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    priority_queue<int> citizens;

    for (int i = 0; i < N + M; i++) {
        int wealth;
        cin >> wealth;

        if (wealth == -1) {
            // The king's visit, behead the richest citizen.
            int richest = citizens.top();
            cout << richest << endl;
            citizens.pop();
        } else {
            // A citizen's visit, add their wealth to the heap.
            citizens.push(wealth);
        }
    }

    return 0;
}