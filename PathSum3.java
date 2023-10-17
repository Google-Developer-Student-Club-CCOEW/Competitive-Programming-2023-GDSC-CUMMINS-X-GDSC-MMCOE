//solution to path sum 3 using recursion

class Solution {
    int count=0;
    List<Integer> path=new ArrayList<>();
    public void solve(TreeNode root,int k){
        if(root==null){
            return;
        }
        path.add(root.val);
        solve(root.left,k);
        solve(root.right,k);

        long sum=0;
        for(int i=path.size()-1;i>=0;i--){
            sum=sum+path.get(i);
            if(sum==k){
                count++;
            }
        }
        path.remove(path.size()-1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        solve(root,targetSum);
        return count;

    }
}