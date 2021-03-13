package com.dancylon.leetcodesolution.dynamic.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 经典递归标记
 * */
public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(Arrays.asList(new Integer[]{2}));
        triangle.add(Arrays.asList(new Integer[]{3,4}));
        triangle.add(Arrays.asList(new Integer[]{6,5,7}));
        triangle.add(Arrays.asList(new Integer[]{4,1,8,3}));
        minimumTotal1(triangle);
    }

    public static int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int n = triangle.size();
        int[] dp = new int[(n + n*n)/2];
        int index = (n-1 + (n-1)*(n-1))/2;
        for (int i = 0; i < triangle.get(n - 1).size(); i++) {
            dp[index+i] = triangle.get(n-1).get(i);
        }
        int a = 0;
        int pre = 0;
        int tail = 0;
        for (int i = n-2; i >= 0; i--) {
            index = (i + i * i)/2;
            for (int j = i; j >= 0; j--) {
                a = index + j;
                pre = dp[a + i + 1];
                tail = dp[a + i + 2];
                dp[a] = triangle.get(i).get(j) + (pre < tail ? pre : tail);
            }
        }
        return dp[0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        trianglelist = triangle;
        int n = triangle.size();
        dp = new int[(n + n*n)/2];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        int sum = this.getSum(1,0);
        return sum + triangle.get(0).get(0);
    }
    private int max = 1<<28;
    private int[] dp;
    private List<List<Integer>> trianglelist;

    private int getSum(int row, int index) {
        if (row == trianglelist.size() || index > row) {
            return 0;
        }
        int num = (row + row * row)/2 + index;
        int a;
        if (dp[num] == max) {
            a = trianglelist.get(row).get(index);
            a = a + getSum(row + 1,index);
            dp[num] = a;
        } else {
            a = dp[num];
        }

        int b = max;
        if (index + 1 <= row) {
            if (dp[num+1] == max) {
                b = trianglelist.get(row).get(index + 1);
                b = b + getSum(row + 1,index + 1);
                dp[num+1] = b;
            } else {
                b = dp[num+1];
            }
        }

        return a < b ? a : b;
    }
}
