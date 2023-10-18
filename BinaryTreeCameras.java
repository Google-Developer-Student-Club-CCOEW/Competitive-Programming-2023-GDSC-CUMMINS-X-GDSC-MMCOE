class BinaryTreeCameras {
    int count=0;
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftchild=solve(root.left);
        int rightchild=solve(root.right);

        if(leftchild==-1 || rightchild==-1){
            count++;
            return 1;
        }
        if(leftchild==1 || rightchild==1){
            return 0;
        }
        return -1;
    }
    public int minCameraCover(TreeNode root) {
        int ans=solve(root);
        if(ans==-1){
            return count+1;
        }
        return count;
    }
}