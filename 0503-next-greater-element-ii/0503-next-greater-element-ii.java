class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int nxtGreater[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 2 * nums.length-1; i >=0; i--) {
            int idx = i % nums.length;
            //step1 - while
            while (!s.isEmpty() && nums[s.peek()] <= nums[idx]) { 
                s.pop();
            }
            // step2 - if-else
            if(s.isEmpty()) {
                nxtGreater[idx] = -1;
            } else {
                nxtGreater[idx] = nums[s.peek()];
            }
            //step3 - push in s
            s.push(idx);
        }
        return nxtGreater;
    }
}