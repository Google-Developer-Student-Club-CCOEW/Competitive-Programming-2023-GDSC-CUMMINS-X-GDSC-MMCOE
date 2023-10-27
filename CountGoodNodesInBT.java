package hacktoberfest;

// Definition for a binary tree node
class TreeNode {
	
    int val;
    TreeNode left, right;
    
    TreeNode() {
    	
    }
    
    TreeNode(int val) { 
    	this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CountGoodNodesInBT {
	
	// To keep track of the count of good nodes
	static int ans = 0;

	// Method to recursively traverse the BT and count the number of good nodes
    static void countGoodNodes(TreeNode root, int max){
    	
    	// Base case
        if(root == null) {
        	return;
        }

        if(root.val >= max) {
        	ans++;
        }
        
        max = Math.max(max, root.val);
        
        countGoodNodes(root.left, max);
        countGoodNodes(root.right, max);
    }
    
    // Method to count the number of good nodes
    public static int goodNodes(TreeNode root) {
    	
        ans = 0;
        
        countGoodNodes(root, root.val);
        
        return ans;
    }

    // Driver Code
	public static void main(String[] args) {

		// Create a binary tree 
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        // Call the function
        int result = goodNodes(root);
        
        // Print the number of good nodes in the BT
        System.out.println("Number of good nodes in the Binary Tree = " + result);
		
	}
}

 