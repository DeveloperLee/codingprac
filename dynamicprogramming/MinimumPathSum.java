package dynamicprogramming;

/**
 * Created by EricLee on 10/16/16.
 * Idea is simple: Since we can only move from either top or left to the current cell.
 * The minimum cost for travelling to the current cell would always be min(fromTop, fromLeft) + currentCellCost.
 */
public class MinimumPathSum {

    // O(m * n) Time since we need to traverse all grid cells
    // O(m * n) Space for the 2-d dp array
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
