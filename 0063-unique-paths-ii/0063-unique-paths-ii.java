class Solution {
    int[][] dp;

    public int solve(int i, int j, int m, int n, int[][] grid) {
        if (i >= m || j >= n) return 0;        
        if (grid[i][j] == 1) return 0;           
        if (i == m - 1 && j == n - 1) return 1;    
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = solve(i + 1, j, m, n, grid) + solve(i, j + 1, m, n, grid);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solve(0, 0, m, n, obstacleGrid);
    }
}
