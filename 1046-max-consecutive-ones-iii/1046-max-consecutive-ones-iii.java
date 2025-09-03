class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, maxLen = 0, zeros =0;
        while(r < n) {
            if(nums[r] == 0) {
                zeros++;
            }    
            if(zeros > k) {
                if(nums[l] == 0) {
                    zeros--;
                }
                l++;
            }
            if(zeros <= k) {
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
}