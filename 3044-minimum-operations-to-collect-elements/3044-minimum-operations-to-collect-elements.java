class Solution {
    public int minOperations(List<Integer> nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= k; i++) {
            set.add(i);
        }

        int p = 0;
        for(int i = nums.size()-1; i >= 0; i--) {
            if(set.contains(nums.get(i))) {
                set.remove(nums.get(i));
            }
            else if(set.isEmpty()) {
                break;
            }
            p++;
        }
        return p;
    }
}