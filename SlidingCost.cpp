#include <iostream>
#include <deque>
#include <vector>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    vector<int> cumulative_sum(n);
    cumulative_sum[0] = arr[0];

    for (int i = 1; i < n; ++i) {
        cumulative_sum[i] = cumulative_sum[i - 1] + arr[i];
    }

    deque<int> window_indices;
    vector<int> result;

    for (int i = 0; i < n; ++i) {
        while (!window_indices.empty() && window_indices.front() < i - k + 1) {
            window_indices.pop_front();
        }

        while (!window_indices.empty() && arr[window_indices.back()] >= arr[i]) {
            window_indices.pop_back();
        }

        window_indices.push_back(i);

        int cost = (i - k >= 0) ? cumulative_sum[i] - cumulative_sum[i - k] : cumulative_sum[i];
        result.push_back(cost);
    }

    for (int i = 0; i < n - k + 1; ++i) {
        cout << result[i] << " ";
    }

    cout << endl;

    return 0;
}