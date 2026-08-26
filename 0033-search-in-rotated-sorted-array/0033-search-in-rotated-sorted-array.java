class Solution {
    public int search(int[] arr, int tar) {
        return search(arr, tar, 0, arr.length - 1);
    }

    public int search(int[] arr, int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }
        int mid = si + (ei - si) / 2;
        // FOUND
        if (arr[mid] == tar) {
            return mid;
        }
        // Case 1: mid on L1
        if (arr[si] <= arr[mid]) {
            // Case a: left search
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            } else {
                // Case b: right
                return search(arr, tar, mid + 1, ei);
            }
        }
        // Case 2: mid on L2
        else {
            // Case c: right
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            } else {
                // Case d: left
                return search(arr, tar, si, mid - 1);
            }
        }
    }
}
