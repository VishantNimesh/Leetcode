class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = Integer.MIN_VALUE;
        int maxArea = 0;

        for(int i = 0; i < dimensions.length; i++) {
            int a = dimensions[i][0];
            int b = dimensions[i][1];
            int area = a * b;
            int diag = a * a + b * b;
            if(diag > max || (diag == max && area > maxArea)) {
                max = diag;
                maxArea = area;
            }
        }
        return maxArea;
    }
}