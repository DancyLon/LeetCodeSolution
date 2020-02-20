package com.dancylon.leetcodesolution.easy;

import static com.dancylon.leetcodesolution.easy.ReverseInteger.reverseInteger3;

/**
 * 回文数
 * */
public class PalindromeNumber {
    public static void main(String[] args) {
        boolean flag = isPalindrome4(12332);
        System.out.println(flag);
    }

    public static boolean isPalindrome4(int x){

        if(x>=0){
            int len = Integer.toString(x).length();
            int i = 0;
            while(i<len/2){
                if((x/(int)Math.pow(10,i))%10!=(x/(int)Math.pow(10,len-1-i))%10){
                    return false;
                }
                i++;
            }
            return true;
        }
        return false;
    }

    //best
    public static boolean isPalindrome3(int x){
        if(x < 0 || (x % 10 == 0 && x != 0))    return false;
        int reverse = 0;
        while(x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse/10;
    }

    public static boolean isPalindrome2(int x){
        if(x>=0){
            char[] chs = Integer.toString(x).toCharArray();
            for (int i = 0; i < chs.length/2; i++) {
                if (chs[i] != chs[chs.length-1-i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isPalindrome1(int x){
        boolean flag =false;
        int x1 = x;
        if (x >=0) {
            long rev = 0;
            while (x != 0) {
                int mod = x % 10;
                rev = rev * 10 + mod;
                if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                    return false;
                }
                x = x / 10;
            }
            flag = x1==rev;
        }
        return flag;
    }
}
