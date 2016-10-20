package greedy;

/**
 * Created by EricLee on 10/19/16.
 */
public class BestTimeBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
