class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWord = 0;
        for (String sentence : sentences) {
            int wordCount = sentence.split(" ").length;
            maxWord = Math.max(maxWord, wordCount);
        }
        return maxWord;
    }
}