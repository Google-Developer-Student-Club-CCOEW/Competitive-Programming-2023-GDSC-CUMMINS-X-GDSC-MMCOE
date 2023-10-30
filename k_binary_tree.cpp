#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>

using namespace std;

// Definition for a binary tree node.
struct TreeNode 
{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void dfs(TreeNode* node, TreeNode* parent, unordered_map<TreeNode*, TreeNode*>& parentMap) 
{
    if (node) 
    {
        parentMap[node] = parent;
        dfs(node->left, node, parentMap);
        dfs(node->right, node, parentMap);
    }
}

vector<int> distanceK(TreeNode* root, TreeNode* target, int k) 
{
    unordered_map<TreeNode*, TreeNode*> parentMap; 
    dfs(root, nullptr, parentMap); 
    queue<TreeNode*> q;
    q.push(target);
    unordered_map<TreeNode*, bool> visited; 
    visited[target] = true;
    int distance = 0;

    // Perform a level-order traversal starting from the target node
    while (!q.empty()) 
    {
        int levelSize = q.size();
        if (distance == k) 
        {
            vector<int> result;
            while (!q.empty()) 
            {
                result.push_back(q.front()->val);
                q.pop();
            }
            return result;
        }
        for (int i = 0; i < levelSize; i++)
        {
            TreeNode* current = q.front();
            q.pop();
            if (current->left && !visited[current->left]) 
            {
                q.push(current->left);
                visited[current->left] = true;
            }
            if (current->right && !visited[current->right]) 
            {
                q.push(current->right);
                visited[current->right] = true;
            }
            TreeNode* parent = parentMap[current];
            if (parent && !visited[parent]) 
            {
                q.push(parent);
                visited[parent] = true;
            }
        }
        distance++;
    }
    return {}; 
}

int main() 
{
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(5);
    root->right = new TreeNode(1);
    root->left->left = new TreeNode(6);
    root->left->right = new TreeNode(2);
    root->right->left = new TreeNode(0);
    root->right->right = new TreeNode(8);
    root->left->right->left = new TreeNode(7);
    root->left->right->right = new TreeNode(4);

    TreeNode* target = root->left; // Target node with value 5
    int k = 2;

    vector<int> result = distanceK(root, target, k);

    cout << "Output: [";
    for (int i = 0; i < result.size(); i++) 
    {
        cout << result[i];
        if (i < result.size() - 1) 
        {
            cout << ", ";
        }
    }
    cout << "]" << endl;

    return 0;
}


//OUTPUT 

//Output: [7, 4, 1]