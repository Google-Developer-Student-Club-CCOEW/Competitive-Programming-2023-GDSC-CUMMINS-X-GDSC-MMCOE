def subarraysDivByK(nums, k):
    
    remainder_count = {0: 1}
    count = 0
    current_sum = 0
    
    for num in nums:
        current_sum += num
        
        current_remainder = current_sum % k
        
        
        if current_remainder < 0:
            current_remainder += k
        
        
        if current_remainder in remainder_count:
            count += remainder_count[current_remainder]
        
        
        remainder_count[current_remainder] = remainder_count.get(current_remainder, 0) + 1
    
    return count


nums1 = [4, 5, 0, -2, -3, 1]
k1 = 5
output1 = subarraysDivByK(nums1, k1)
print("Output 1:", output1)

nums2 = [5]
k2 = 9
output2 = subarraysDivByK(nums2, k2)
print("Output 2:", output2)
