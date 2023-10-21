class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int temp1;

        for(int i=0; i<nums.length; i++)
        {
            Boolean a = map.containsKey(nums[i]);
            if(a)
            {
                temp1 = nums[i];
                map.put(temp1, (map.get(temp1)+1));
            }
            else
            {
                temp1 = nums[i];
                map.put(temp1, 1);
            }
        }

        int max=0;
        int temp=0;

        Set<Integer> keys = map.keySet();
        for(int key : keys)
        {
            if(map.get(key) > max)
            {
                max = map.get(key);
                temp = key;
            }
        }

        return temp;
        
    }
}