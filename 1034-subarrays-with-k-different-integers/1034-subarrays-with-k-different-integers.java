class Solution {
    public int x(int[] nums, int k) {
        int cnt = 0;
        int n = nums.length;
        int l = 0, r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r < n) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if(map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            if(map.size() <= k) {
                cnt += r - l + 1;
            }
            r++;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return x(nums, k) - x(nums, k-1);
    }
}