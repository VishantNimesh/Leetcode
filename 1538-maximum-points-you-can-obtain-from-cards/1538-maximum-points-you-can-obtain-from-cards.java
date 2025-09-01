class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0, rsum = 0, maxSum = 0;
        for(int i = 0; i < k; i++) {
            lsum = lsum + cardPoints[i];
        }
        maxSum = lsum;
        int n = cardPoints.length;
        int rIdx = n-1;
        for(int i = k-1; i >= 0; i--) {
            lsum = lsum - cardPoints[i]; 
            rsum = rsum + cardPoints[rIdx];
            rIdx = rIdx - 1;

            maxSum = Math.max(maxSum, (lsum + rsum) );
        }
        return maxSum;
    }
}