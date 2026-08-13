class Solution {
    public int majorityElement(int[] arr) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) +1);
        }
        int maxFreq = Integer.MIN_VALUE;
        int maxFreqWaliKey = -1;
        for (int key : freq.keySet()) {
            int currentKey = key;
            int currKeyKiFrequency = freq.get(key);
            if(currKeyKiFrequency > maxFreq){
                // mujhe naya max mil gya
                maxFreq = currKeyKiFrequency;
                maxFreqWaliKey = currentKey;
            }
        }
        return maxFreqWaliKey;
    }
}