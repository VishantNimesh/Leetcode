class Solution {
    public void solve(int[] nums, List<Integer> output, List<List<Integer>> ans) {
        if (nums.length == 0) {
            ans.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int item = nums[i];

            int[] remaining = new int[nums.length - 1];
            int index = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    remaining[index++] = nums[j];
                }
            }
            output.add(item);

            solve(remaining, output, ans);
            output.remove(output.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, new ArrayList<>(), ans);
        return ans;
    }
}