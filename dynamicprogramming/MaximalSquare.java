package dynamicprogramming;

/**
 * Created by EricLee on 10/17/16.
 *
 * This problem is a classic dp problem. For each cell whose value is 1, we consider it's
 * three neighbourhood (i - 1, j) (i - 1, j - 1) and (i, j - 1) and get the minimum value
 * of these three neighbourhoods.
 */
public class MaximalSquare {

    // O(mn) Time O(mn) Space
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }
}
