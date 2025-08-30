class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        // int mod = (int)(1e9 + 7);
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st1 = new Stack<>(); //ps
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && arr[st1.peek()] > arr[i]) {
                st1.pop();
            }
            left[i] = st1.isEmpty() ? (i + 1) : (i - st1.peek());
            st1.push(i);
        }

        Stack<Integer> st2 = new Stack<>(); //ns
        for (int i = n - 1; i >= 0; i--) {
            while (!st2.isEmpty() && arr[st2.peek()] >= arr[i]) {
                st2.pop();
            }
            right[i] = st2.isEmpty() ? (n - i) : (st2.peek() - i);
            st2.push(i);
        }
        long minSum = 0;
        for (int i = 0; i < n; i++) {
            long contrib = (long) arr[i] * left[i] * right[i];
            minSum += contrib;
        }

        int[] rightGr = new int[n];
        int[] leftGr = new int[n];
        Stack<Integer> st3 = new Stack<>(); //n g element
        for(int i = n-1; i >= 0; i--) {
            while(!st3.isEmpty() && arr[st3.peek()] < arr[i]) {
                st3.pop();
            }
            rightGr[i] = st3.isEmpty() ? (n - i ) : (st3.peek() - i);
            st3.push(i);
        }

        Stack<Integer> st4 = new Stack<>(); //p gr element
        for(int i = 0; i < n; i++) {
            while(!st4.isEmpty() && arr[st4.peek()] <= arr[i]) {
                st4.pop();
            }
            leftGr[i] = st4.isEmpty() ? ( i + 1 ) : (i - st4.peek());
            st4.push(i);
        }
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            long contrib = (long) arr[i] * leftGr[i] * rightGr[i];
            maxSum += contrib;
        }

        return maxSum - minSum;
    }
}