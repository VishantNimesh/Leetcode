class Solution {
    public int sumSubarrayMins(int[] arr) {
        // int sum = 0; 
        // int mod =  (int)(1e9 + 7);
        // for(int i = 0; i < arr.length; i++) {
        //     int min = arr[i];
        //     for(int j = i; j < arr.length; j++) {
        //         min = Math.min(min, arr[j]);
        //         sum += min % mod;
        //     }
        // }
        // return sum;


        //optimal
        int n = arr.length;
        int mod = (int)(1e9 + 7);

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st1 = new Stack<>();
        // Previous smaller element
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && arr[st1.peek()] > arr[i]) {
                st1.pop();
            }
            left[i] = st1.isEmpty() ? (i + 1) : (i - st1.peek());
            st1.push(i);
        }
        Stack<Integer> st2 = new Stack<>();
        // Next smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (!st2.isEmpty() && arr[st2.peek()] >= arr[i]) {
                st2.pop();
            }
            right[i] = st2.isEmpty() ? (n - i) : (st2.peek() - i);
            st2.push(i);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long contrib = (long) arr[i] * left[i] * right[i];
            ans = (ans + contrib) % mod;
        }

        return (int) ans;
    }
}