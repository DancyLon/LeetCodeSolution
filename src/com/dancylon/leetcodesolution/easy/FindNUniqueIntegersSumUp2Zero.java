package com.dancylon.leetcodesolution.easy;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 * */
public class FindNUniqueIntegersSumUp2Zero {

    public static void main(String[] args) {

    }

    public static int[] sumZero1(int n) {
        int[] arr = new int[n];
        if (n >= 2) {
            if (n % 2 == 0) {
                for (int i = 1; i <= n/2; i++) {
                    arr[n/2+i-1] = i;
                    arr[n/2-i] = -i;
                }
            }else{
                for (int i = 1; i <= n/2; i++) {
                    arr[n/2+i] = i;
                    arr[n/2-i] = -i;
                }
                arr[n/2] = 0;
            }
        }
        return arr;
    }

    public static int[] sumZero2(int n){
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i <= n-2; i++) {
            arr[i] = i;
            sum += i;
        }
        arr[n-1] = -sum;
        return arr;
    }

    public static int[] sumZero3(int n){
        int[] arr = new int[n];
        for (int i = 0; i < n/2; i++) {
            arr[i] = i+1;
            arr[n-1-i] = -i-1;
        }
        return arr;
    }
}
