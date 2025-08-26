class Solution {
    public int mySqrt(int x) {
        int st = 0;
        int end = x;
        int ans = 0;

        while(st <= end){
            long mid  = ((long)st + (long)end)/2;

            if(mid*mid <= (long)x){
                ans = (int)mid;
                st = (int)mid + 1;
            } else { 
                end = (int)mid - 1;
            }
        }
        return ans;
    }
}
