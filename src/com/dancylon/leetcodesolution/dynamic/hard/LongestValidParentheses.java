package com.dancylon.leetcodesolution.dynamic.hard;

import java.util.LinkedList;

public class LongestValidParentheses {


    // time O(n^2)
    public static int solution1(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        char[] arr = s.toCharArray();
        boolean flag;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            flag = true;
            if (arr[i] == '(') {
                dp[i] = dp[i] + 1;
                for (int j = index; j < i; j++) {
                    if (arr[j] == '(' && dp[j] > 0) {
                        dp[j] = dp[j] + 1;
                        flag = false;
                    } else {
                        flag = flag && true;
                    }
                }
            } else {
                dp[i] = -1;
                for (int j = index; j < i; j++) {
                    if (arr[j] == '(' && dp[j] > 0) {
                        dp[j] = dp[j] - 1;
                        if (dp[j] == 0) {
                            if (j > 0 && arr[j-1] == ')' && dp[j-1] >= 0) {
                                dp[i] = dp[j-1];
                            } else {
                                dp[i] = j;
                            }
                            max = Math.max(max, i - dp[i] + 1);
                        }
                        flag = false;
                    } else {
                        flag = flag && true;
                    }
                }
            }
            if (flag) {
                index = i;
            }
        }
        return max;
    }

    // O(n)
    public static int solution2(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int max = 0;
        char[] arr = s.toCharArray();
        LinkedList<Integer> stash = new LinkedList<>();
        int[] negative = new int[s.length()];
        int start;
        int len;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stash.add(i);
            } else {
                if (!stash.isEmpty()) {
                    start = stash.removeLast();
                    if (start > 0) {
                        len = i - start + 1 + negative[start - 1];
                    } else {
                        len = i - start + 1;
                    }
                    negative[i] = len;
                    max = max > len ? max : len;
                }
            }
        }
        return max;
    }

    // 正反两个方向遍历
    public static int solution3(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int max = 0;
        int count = 0;
        int stack = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == '(') {
                stack++;
                count++;
            } else {
                if (stack > 0) {
                    count++;
                    stack--;
                    if (stack == 0) {
                        max = max > count ? max : count;
                    }
                } else {
                    count = 0;
                }
            }
        }
        stack = 0;
        count = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            if (arr[i] == ')') {
                stack++;
                count++;
            } else {
                if (stack > 0) {
                    count++;
                    stack--;
                    if (stack == 0) {
                      max = Math.max(max, count);
                    }
                } else {
                    count = 0;
                }
            }
        }
        return max;
    }
}
