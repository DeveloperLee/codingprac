package dynamicprogramming;

import java.util.Arrays;

/**
 * Created by EricLee on 10/17/16.
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= amount; i++) {
            boolean canGet = false;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] == i) {
                    dp[i] = 1;
                    canGet = true;
                    break;
                } else if (coins[j] < i && dp[i - coins[j]] != -1) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    canGet = true;
                }
            }
            if (!canGet) dp[i] = -1;
        }
        return dp[amount];
    }
}
