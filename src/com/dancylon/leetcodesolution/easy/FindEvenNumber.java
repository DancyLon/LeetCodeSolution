package com.dancylon.leetcodesolution.easy;
/**
 * 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
 * */
public class FindEvenNumber {

    public static void main(String[] args) {
        int[] nums = {1,22,333,5563};
        System.out.println(findNumbers(nums));
    }

    /*
    * 执行用时 :1 ms, 在所有 java 提交中击败了100.00%的用户
      内存消耗 :38.9 MB, 在所有 java 提交中击败了100.00%的用户
    * */
    private static int findNumbers(int[] nums) {
        int n = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=99999){
                if(nums[i]>=10&&nums[i]<=99||nums[i]>=1000&&nums[i]<=9999){
                    n++;
                }
            }else{
                if(isEvenNumber(nums[i])%2==1){
                    n++;
                }
            }
        }
        return n;
    }

    private static int isEvenNumber(int num){
        int a = 1;
        if(num/100000>=1&&num/100000<=9){
            return a;
        }else{
            return a+isEvenNumber(num/10);
        }
    }


    /*
    * 第二种解决方法，去掉99999范围内的判断仍然成立
    * 执行时间仍然是1ms
    * */
    public static int findNumbers2(int[] nums) {
        int n = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=10)
                if(isEvenNumber(nums[i])%2==1){
                    n++;
                }

        }

        return n;
    }

    private static int isEvenNumber2(int num){
        int a = 1;
        if(num/10>=1&&num/10<=9){
            return a;
        }else{
            return a+isEvenNumber(num/10);
        }
    }
}
