class Solution {
    public int[] findPSE(int[] heights) {
        int[] pse = new int[heights.length];
        Stack<Integer> st1 = new Stack<>();
        for(int i = 0; i < heights.length; i++) {
            while(!st1.isEmpty() && heights[st1.peek()] > heights[i]) {
                st1.pop();
            }
            pse[i] = st1.isEmpty() ? -1 : st1.peek();
            st1.push(i);
        }
        return pse;
    }
    public int[] findNSE(int[] heights) {
        int[] nse = new int[heights.length];
        Stack<Integer> st2 = new Stack<>();
        for(int i = heights.length - 1; i >= 0; i--) {
            while(!st2.isEmpty() && heights[st2.peek()] >= heights[i]) {
                st2.pop();
            }
            nse[i] = st2.isEmpty() ? heights.length : st2.peek();
            st2.push(i);
        }
        return nse;
    }
    public int largestRectangleArea(int[] heights) {
        int[] pse = findPSE(heights);
        int[] nse = findNSE(heights);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            // int width = nse[i] - pse[i] - 1;  
            // int area = heights[i] * width;
            
            maxArea = Math.max(maxArea, heights[i] * (nse[i] - pse[i] - 1));
        }
        return maxArea;
    }
}