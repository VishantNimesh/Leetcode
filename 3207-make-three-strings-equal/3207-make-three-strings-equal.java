class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int o = s3.length();
        int minLen = Math.min(n, Math.min(m, o));
        int lcp = 0;

        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                lcp++;
            } else {
                break;
            }
        }
        if (lcp == 0) {
            return -1;
        }    
        return (n - lcp) + (m - lcp) + (o - lcp);
    }
}