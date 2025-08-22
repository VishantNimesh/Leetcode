class Solution {
    public int maxProduct(int[] arr) {
        // int currSum = 0;
        // int maxProductSum = Integer.MIN_VALUE;

        // for(int i = 0; i < arr.length; i++) {
        //     for(int j = i; j < arr.length; j++) {
        //         currSum = 0;
        //         for(int k = i; k <= j; k++) {
        //             currSum *= arr[k]; 
        //         }
        //         if( maxProductSum < currSum) {
        //             maxProductSum = currSum;
        //         }
        //     }
        // }
        // return maxProductSum;


        

        // int prod1 = arr[0],prod2 = arr[0],result = arr[0];
        // for(int i=1;i<arr.length;i++) {
        //     int temp = Math.max(arr[i],Math.max(prod1*arr[i],prod2*arr[i]));
        //     prod2 = Math.min(arr[i],Math.min(prod1*arr[i],prod2*arr[i]));
        //     prod1 = temp;

        //     result = Math.max(result,prod1);
        // }

        // return result;

        
        // observation based
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;

        for(int i = 0; i < n; i++) {
            if(prefix == 0) prefix = 1;
            else if(suffix == 0) suffix = 1;

            prefix = prefix * arr[i];
            suffix = suffix * arr[n - i- 1];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }
}
