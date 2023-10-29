class Solution {
    public int[] productExceptSelf(int[] nums)
     {
        int numslen = nums.length;
        int prefixProduct = 1;
        int suffixProduct = 1;
        int[] result = new int[numslen];
        for(int i = 0; i < numslen; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }
        for(int i = numslen-1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return result;

    }
}
