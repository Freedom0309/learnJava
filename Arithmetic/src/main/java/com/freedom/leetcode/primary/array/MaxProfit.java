package com.freedom.leetcode.primary.array;

/**
 * Copyright: Copyright (c) 2022
 *
 * <p>
 * Description: 股票波动期间获取最大利润
 *
 * @author LiuFeng
 * @version 2022/1/16 22:10
 * @since
 */
public class MaxProfit {

    public static int maxProfit(int[] prices) {

        int profit = 0;
        int left = 0;
        for (int right = 1; right < prices.length; ) {
            if (prices[left] >= prices[right]) {
                left++;
                right++;
            } else {
                profit += prices[right] - prices[left];
                if (prices[right + 1] > prices[right]) {
                    right++;
                    left++;
                } else {
                    right += 2;
                    left += 2;
                }
            }
        }
        return profit;
    }

    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][2];
        //初始条件
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < length; i++) {
            //递推公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最后一天肯定是手里没有股票的时候，利润才会最大，
        //只需要返回dp[length - 1][0]即可
        return dp[length - 1][0];
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        //没有股票的利润
        int noHold = 0;
        //持有股票的利润
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            noHold = Math.max(noHold, hold + prices[i]);
            hold = Math.max(hold, noHold - prices[i]);
        }

        return noHold;
    }

    //贪心算法
    public static int maxProfit3(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int total = 0, index = 0, length = prices.length;
        while (index < length) {
            //如果股票下跌，一直找，找到股票上涨为止
            while (index < length - 1 && prices[index] >= prices[index + 1])
                index++;

            //股票上涨开始的值，这段时间最小的值
            int min = prices[index];
            //如果股票一直上涨，一直找，找到股票开始下跌为止
            while (index < length - 1 && prices[index] <= prices[index + 1])
                index++;
            //计算这段时间的差值，然后累加
            total += prices[index++] - min;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4,8};
//        int profit = maxProfit(prices);
        int profit = maxProfit1(prices);
        System.out.println(profit);
        System.out.println(maxProfit3(prices));

    }
}
