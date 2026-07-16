class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector<int>ans;
        int i=0;
        while(i<nums.size()){
            int curr_idx=nums[i]-1;

            if(nums[i]!=nums[curr_idx]){
                swap(nums[i],nums[curr_idx]);
            }else{
                i=i+1;
            }
        }

        for(int i=0;i<nums.size();i++){
            if(nums[i]!=i+1){
                ans.push_back(nums[i]);
                ans.push_back(i+1);
                break;   
            }
        }

        return ans;
    }
};