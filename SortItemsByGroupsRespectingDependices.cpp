// Sort Items by Groups Respecting Dependencies

#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <queue>

using namespace std;

vector<int> sortItems(int n, int m, vector<int>& group, vector<vector<int>>& beforeItems) {
    vector<vector<int>> groupItems(m + n);
    for (int i = 0; i < n; ++i) {
        if (group[i] == -1) {
            group[i] = m++;
        }
        groupItems[group[i]].push_back(i);
    }

    vector<unordered_set<int>> groupGraph(m + n);
    vector<int> groupDegree(m + n);

    vector<unordered_set<int>> itemGraph(n);
    vector<int> itemDegree(n);

    for (int i = 0; i < n; ++i) {
        for (auto j : beforeItems[i]) {
            if (group[i] == group[j]) {
                itemGraph[j].insert(i);
                itemDegree[i]++;
            } else {
                groupGraph[group[j]].insert(group[i]);
                groupDegree[group[i]]++;
            }
        }
    }

    vector<int> itemOrder;
    queue<int> q;

    for (int i = 0; i < m + n; ++i) {
        if (groupDegree[i] == 0) {
            q.push(i);
        }
    }

    while (!q.empty()) {
        int node = q.front();
        q.pop();
        if (node < n) {
            itemOrder.push_back(node);
            for (int next : itemGraph[node]) {
                if (--itemDegree[next] == 0) {
                    q.push(next);
                }
            }
        } else {
            for (int next : groupItems[node - m]) {
                if (--groupDegree[group[next]] == 0) {
                    q.push(group[next]);
                }
            }
        }
    }

    if (itemOrder.size() < n) {
        return {};
    }

    return itemOrder;
}

void printVector(const vector<int>& vec) {
    cout << "[";
    for (size_t i = 0; i < vec.size(); ++i) {
        cout << vec[i];
        if (i != vec.size() - 1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;
}

int main() {
    int n = 8;
    int m = 2;
    vector<int> group = {-1, -1, 1, 0, 0, 1, 0, -1};
    vector<vector<int>> beforeItems = {{}, {6}, {5}, {6}, {3, 6}, {}, [], {}};

    vector<int> result = sortItems(n, m, group, beforeItems);
    cout << "Output: ";
    printVector(result);

    return 0;
}
