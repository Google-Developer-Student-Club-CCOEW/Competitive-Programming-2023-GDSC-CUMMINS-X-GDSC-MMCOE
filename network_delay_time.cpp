#include <iostream>
#include <vector>
#include <queue>
#include <unordered_map>
#include <limits>

using namespace std;

int networkDelayTime(vector<vector<int>>& times, int n, int k) 
{
    vector<vector<pair<int, int>> > adj(n + 1);
    for (auto& time : times) 
    {
        adj[time[0]].push_back({time[1], time[2]});
    }
    
    vector<int> distance(n + 1, numeric_limits<int>::max());
    vector<bool> visited(n + 1, false);
    
    distance[k] = 0;
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, k});
    
    while (!pq.empty()) 
    {
        auto [dist, node] = pq.top();
        pq.pop();
        
        if (visited[node]) 
        {
            continue;
        }
        visited[node] = true;
        
        for (auto& neighbor : adj[node]) 
        {
            int neighborNode = neighbor.first;
            int neighborTime = neighbor.second;
            
            if (distance[neighborNode] > distance[node] + neighborTime)
            {
                distance[neighborNode] = distance[node] + neighborTime;
                pq.push({distance[neighborNode], neighborNode});
            }
        }
    }
    
    int maxTime = 0;
    for (int i = 1; i <= n; i++) 
    {
        if (distance[i] == numeric_limits<int>::max()) 
        {
            return -1; // Some nodes are unreachable
        }
        maxTime = max(maxTime, distance[i]);
    }
    
    return maxTime;
}

int main() 
{
    vector<vector<int>> times1 = {{2,1,1},{2,3,1},{3,4,1}};
    int n1 = 4;
    int k1 = 2;

    int minTime1 = networkDelayTime(times1, n1, k1);
    
    cout << "Example 1 - Minimum time for all nodes to receive the signal: " << minTime1 << endl;

    vector<vector<int>> times2 = {{1,2,1}};
    int n2 = 2;
    int k2 = 1;

    int minTime2 = networkDelayTime(times2, n2, k2);
    
    cout << "Example 2 - Minimum time for all nodes to receive the signal: " << minTime2 << endl;

    vector<vector<int>> times3 = {{1,2,1}};
    int n3 = 2;
    int k3 = 2;

    int minTime3 = networkDelayTime(times3, n3, k3);
    
    cout << "Example 3 - Minimum time for all nodes to receive the signal: " << minTime3 << endl;

    return 0;
}

// OUTPUT :
// Example 1 - Minimum time for all nodes to receive the signal: 2
// Example 2 - Minimum time for all nodes to receive the signal: 1
// Example 3 - Minimum time for all nodes to receive the signal: -1