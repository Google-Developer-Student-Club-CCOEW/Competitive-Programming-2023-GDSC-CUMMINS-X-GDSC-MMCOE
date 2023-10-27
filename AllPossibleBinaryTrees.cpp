#include <bits/stdc++.h>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

vector<TreeNode*> allPossibleFBT(int n) {
    if (n % 2 == 0) {
        return {};
    }

    if (n == 1) {
        return { new TreeNode(0) };
    }

    vector<TreeNode*> result;
    for (int i = 1; i < n; i += 2) {
        vector<TreeNode*> leftSubtrees = allPossibleFBT(i);
        vector<TreeNode*> rightSubtrees = allPossibleFBT(n - 1 - i);

        for (TreeNode* left : leftSubtrees) {
            for (TreeNode* right : rightSubtrees) {
                TreeNode* root = new TreeNode(0);
                root->left = left;
                root->right = right;
                result.push_back(root);
            }
        }
    }

    return result;
}

void printTree(TreeNode* root) {
    if (root) {
        cout << root->val << " ";
        printTree(root->left);
        printTree(root->right);
    } else {
        cout << "null ";
    }
}

int main() {
    int n = 7;
    vector<TreeNode*> result = allPossibleFBT(n);

    for (TreeNode* root : result) {
        printTree(root);
        cout << endl;
    }

    for (TreeNode* root : result) {
        delete root;
    }

    return 0;
}
