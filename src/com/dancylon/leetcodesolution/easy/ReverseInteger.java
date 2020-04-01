package com.dancylon.leetcodesolution.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转一个整数
 * 1. 用int四则运算，只要越界就会得到 -(1<<31)
 * 2. 1<<32 得1，因为移了32位又移回来了
 * 3. 可以把整数转化成字符串得到它的位数
 * 4. 幂运算用Math,pow()
 * */
public class ReverseInteger {
    public static void main(String[] args) {
        int c = reverseInteger2(1534236461);
        System.out.println(c);
    }

    //best
    ///相当于移位操作，把每次的余数移到前边
    ///十进制的位操作，只要乘以十就可以了
    ///把余数加在个位，再乘以十，就实现了位操作
    public static int reverseInteger3(int x){
        long rev = 0;
        while (x != 0) {
            int mod = x % 10;
            rev = rev * 10 + mod;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }
        return (int) rev;
    }

    public static int reverseInteger2(int x){
        if (x == -(1<<31)||x==0) {
            return 0;
        }
        boolean sign = x>0;
        x = sign?x:-x;
        int re = 0;
        while(x!=0){
            int mod = x%10;
            re += mod*Math.pow(10,(Integer.toString(x).length()-1));
            if (re == Integer.MIN_VALUE || re == Integer.MAX_VALUE) {
                return 0;
            }
            x = x/10;
        }
        return sign?re:-re;
    }

    public static int reverseInteger1(int x){
        if (x == -(1<<31)) {
            return 0;
        }
        long re = 0;
        boolean sign = x>=0;
        x = sign?x:-x;
        List<Long> list = new ArrayList<Long>(11);
        getEveryInteger(list,x);
        for(int i=0;i<list.size();i++){
            int a = 1;
            for (int j = 1; j <= list.size()-i-1; j++) {
                a = a*10;
            }
            re += a*list.get(i);
        }
        re = re>=(1<<31)-1?0:re;
        int b = (int)re;
        return sign?b:-b;
    }
    public static void getEveryInteger(List<Long> list, long x){
        if (x == 0) {
            return;
        }else{
            list.add(x%10);
            getEveryInteger(list,x/10);
        }
    }

}
