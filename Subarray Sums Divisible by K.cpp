class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
  map<int,int>map;
map[0]=1;
int sum=0,count=0;
for (int i=0;i<nums.size();i++){
    sum =sum+nums[i];
    int remainder=(sum%k);
    if(remainder<0){
    remainder=remainder+k;
    }
    count=count+map[remainder];
    map[remainder]++;
}
return count;
}
};



//Input
//nums =
//[4,5,0,-2,-3,1]
//k =
//5
//Output
//7
