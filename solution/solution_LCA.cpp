#include <bits/stdc++.h>
using namespace std;


struct Node {
	int key;
	struct Node *left;
	struct Node *right;
};


Node* newNode(int k)
{
	Node* temp = new Node;
	temp->key = k;
	temp->left = temp->right = NULL;
	return temp;
}


bool findPath(Node* root, vector<int>& path, int k)
{
	if (root == NULL)
		return false;


	path.push_back(root->key);

	if (root->key == k)
		return true;

	if ((root->left && findPath(root->left, path, k))
		|| (root->right && findPath(root->right, path, k)))
		return true;


	path.pop_back();
	return false;
}


int findLCA(Node* root, int n1, int n2)
{
	vector<int> path1, path2;


	if (!findPath(root, path1, n1)
		|| !findPath(root, path2, n2))
		return -1;

	int i;
	for (i = 0; i < path1.size() && i < path2.size(); i++)
		if (path1[i] != path2[i])
			break;
	return path1[i - 1];
}

int main()
{

	Node* root = newNode(6);
	root->left = newNode(2);
	root->right = newNode(8);
	root->left->left = newNode(0);
	root->left->right = newNode(4);
	root->left->right->left = newNode(3);
	root->left->right->right = newNode(5);
	root->right->left = newNode(7);
	root->right->right = newNode(8);
	
	cout << "Lowest Common Ancestor of (2, 8) = " << findLCA(root, 2, 8) <<endl;
	
	cout << "Lowest Common Ancestor of (2, 4) = " << findLCA(root, 2, 4) <<endl;
	
	cout << "Lowest Common Ancestor of (2, 4) = " << findLCA(root, 2, 4) <<endl;
	
	return 0;
}
