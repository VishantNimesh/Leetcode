class Solution {
    public long removeZeros(long n) {
        long num = 0;
        long base = 1;
        while(n != 0){
            long rem = n%10;
            if(rem != 0){
                num += base*rem;
                base *= 10;
            }
            n /= 10;
        }
        return num;
    }
}