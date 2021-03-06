package com.dancylon.leetcodesolution.medium;

import java.util.*;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
     示例 1:
     输入: coins = [1, 2, 5], amount = 11
     输出: 3
     解释: 11 = 5 + 5 + 1

     示例 2:
     输入: coins = [2], amount = 3
     输出: -1
 * */
public class CoinChange {
    public static void main(String[] args) {
        //[186,419,83,408]
        // 6249
        int[] coins = new int[]{2};
        int amount = 3;
        System.out.println(coinChange3(coins,amount));
    }
    public static int coinChange3(int[] coins, int amount) {
        long max = (long)amount + 1;
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : (int)dp[amount];
    }


    public static int coinChange1(int[] coins, int amount) {
        if (amount < 1) return 0;
        Arrays.sort(coins);
        int[] reverseCoins = new int[coins.length];
        for (int i = 0; i < coins.length; i++) {
            reverseCoins[i] = coins[coins.length-1-i];
        }
        return coinChange(reverseCoins, amount, new int[amount]);
    }

    private static int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i<coins.length;i++) {
            if (coins[i] > rem) {
                continue;
            }
            int res = coinChange(Arrays.copyOfRange(coins,i,coins.length), rem - coins[i] , count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }


    /**
     * 超出时间限制
     * 考虑任一种组合
     * 任意个硬币组合的情况
     *
     * */
    private static int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE)? -1: minCost;
        }
        return -1;
    }
}
