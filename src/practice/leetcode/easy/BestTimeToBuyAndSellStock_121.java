package practice.leetcode.easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock_121 {
    public static int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int res = 0;
        int diff = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            diff = prices[i] - lsf;
            if(res < diff){
                res = diff;
            }
        }
        return res;
    }

    /**
     * Time Limit Exceeded
     * @param prices
     * @return
     */
    public static int maxProfit_2(int[] prices) {
        int max = Integer.MIN_VALUE;
        int diff = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for(int j = i; j<prices.length-1; j++) {
                diff = prices[j+1]-prices[i];
                if(max<diff) {
                    max = diff;
                }
            }
        }
        return Math.max(max, 0);
    }

    public static void main(String[] args) {
        int[] prices = {2,4,1};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
