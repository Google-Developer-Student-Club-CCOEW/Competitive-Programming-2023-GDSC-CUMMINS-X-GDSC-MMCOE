class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        long count=0;

        for(int i=0;i<nums1.length;i++){
            if(nums1[i]==nums2[i]){
                if(hm.containsKey(nums1[i])){
                    hm.put(nums1[i],hm.get(nums1[i])+1);
                }else{
                    hm.put(nums1[i],1);
                }
                count+=i;
            }
        }
        int temp=0;
        int size=0;

        for(Integer key:hm.keySet()){
            if(hm.getOrDefault(key,0)>=hm.getOrDefault(temp,0)){
                temp=key;
            }
            size+=hm.get(key);
        }
        
        for(int i=0;i<nums1.length;i++){
            
            if(nums1[i]==temp || nums2[i]==temp || nums1[i] == nums2[i] || size >= 2 * hm.getOrDefault(temp,0)){
                continue;
            }
            hm.put(nums1[i],hm.getOrDefault(nums1[i],0)+1);
            count+=i;
            size++;
                
        }
        return 2*hm.getOrDefault(temp,0) <= size ? count:-1;
    }
}
