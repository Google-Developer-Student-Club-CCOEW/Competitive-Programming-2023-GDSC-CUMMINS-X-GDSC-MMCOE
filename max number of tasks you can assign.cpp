class Solution {
public:
    int maxTaskAssign(vector<int>& tasks, vector<int>& workers, int p, int strength) {
        int n = tasks.size(), m = workers.size();
        
        // Sorting the tasks and workers in increasing order
        sort(tasks.begin(), tasks.end());
        sort(workers.begin(), workers.end());
        int lo = 0, hi = min(m, n);
        int ans;
        
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            bool flag = true;
            
            // Inserting all workers in a multiset
            multiset<int> st(workers.begin(), workers.end());
            
            // Checking if the mid smallest tasks can be assigned
            for(int i = mid - 1; i >= 0; i--) {
                
                // Case 1: Trying to assing to a worker without the pill
                auto it = prev(st.end());
                if(tasks[i] <= *it) {
                    
                    // Case 1 satisfied!
                    st.erase(it);
                } else {
                    
                    // Case 2: Trying to assign to a worker with the pill
                    auto it = st.lower_bound(tasks[i] - strength);
                    if(it != st.end()) {
                        
                        // Case 2 satisfied!
                        count++;
                        st.erase(it);
                    } else {
                        
                        // Case 3: Impossible to assign mid tasks
                        flag = false;
                        break;
                    }
                }
                
                // If at any moment, the number of pills require for mid tasks exceeds 
                // the allotted number of pills, we stop the loop
                if(count > p) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
};





//Input
tasks =
[3,2,1]
workers =
[0,3,3]
pills =
1
strength =
1
//Output
3