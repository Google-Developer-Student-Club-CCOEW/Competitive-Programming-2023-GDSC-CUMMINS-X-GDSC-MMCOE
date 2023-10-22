class Solution {
    Integer count[],indexes[];

    void merge(int[] nums, int l, int m, int r) {
        List<Pair<Integer,Integer>> list = new ArrayList<Pair<Integer,Integer>>();
        int i=l,j=m+1,k=l;
        while(i<=m && j<=r) {
            if(nums[i]>nums[j]){
                count[indexes[i]]+=r-j+1;
                list.add(new Pair<>(nums[i],indexes[i++]));
            }else
                list.add(new Pair<>(nums[j],indexes[j++]));
        }
        while(i<=m) 
            list.add(new Pair<>(nums[i],indexes[i++]));
        while(j<=r)
            list.add(new Pair<>(nums[j],indexes[j++]));
        for(Pair<Integer,Integer> pair : list){
            nums[k]=pair.getKey();
            indexes[k++]=pair.getValue();
        }
    }

    void mergeSort(int[] nums, int l ,int r) {
        if(l<r) {
            int mid=(l+r)/2;
            mergeSort(nums,l,mid);
            mergeSort(nums,mid+1,r);
            merge(nums,l,mid,r);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        count=new Integer[nums.length];
        indexes=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            count[i]=0;
            indexes[i]=i;
        }

        mergeSort(nums,0,nums.length-1);
        
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<count.length;i++){
            ans.add(count[i]);
        }
        return ans;
    }
}
