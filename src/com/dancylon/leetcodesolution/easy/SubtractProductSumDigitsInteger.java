package com.dancylon.leetcodesolution.easy;

public class SubtractProductSumDigitsInteger {
    public static void main(String[] args) {
        int subtract = subtractProductAndSum(234);
        System.out.println(subtract);
    }
    public static int subtractProductAndSum(int n) {
        int subtract = 0;
        if (n >=10) {
            int sum = 0;
            int product = 1;
            int scale = 1;
            while(n/scale!=0){
                sum += (n%(scale*10))/scale;
                product *= (n%(scale*10))/scale;
                scale *= 10;
            }
            subtract = product - sum;
        }
        return subtract;
    }
}
