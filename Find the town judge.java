class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n+1];
        int[] outgoing = new int[n+1];

        for(int[] rely : trust){
            int p1 = rely[0];
            int p2 = rely[1];
            incoming[p2]++;
            outgoing[p1]++;
        }
        for(int i=1;i<n+1;i++){
            if(incoming[i]==n-1 && outgoing[i]==0){
                return i;
            }
        }
        return -1;
    }
}
