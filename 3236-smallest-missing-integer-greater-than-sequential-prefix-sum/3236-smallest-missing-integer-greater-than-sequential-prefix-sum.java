class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] == nums[j-1] + 1) {
                sum += nums[j];
            } else {
                break;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        while(set.contains(sum)) {
            sum = sum+1;
        }
        return sum;
    }
}