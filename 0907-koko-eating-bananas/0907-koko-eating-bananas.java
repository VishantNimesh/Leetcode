class Solution {
    public int maxElement(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    public int calcHrs(int[] arr, int hrs) {
        int totalHrs = 0;
        for(int i = 0; i < arr.length; i++) {
            totalHrs += Math.ceil((double)(arr[i]) / (double)(hrs));
        }
        return totalHrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = maxElement(piles);
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low+high)/2;
            int totalHours = calcHrs(piles, mid);
            if(totalHours <= h) {
                ans = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}