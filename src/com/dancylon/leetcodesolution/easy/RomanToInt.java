package com.dancylon.leetcodesolution.easy;
/**
 * MMMCMXCIX 3999
 * CM 900
 * CD 400
 * CMXLIV 944
 * MDCLXVI 1666
 * */
public class RomanToInt {
    public final static String ROMANS = "IVXLCDM";

    public static void main(String[] args) {
        String s = "MMMCMXCIX";
        System.out.println(romanToInt1(s));
    }



    //best
    public static int romanToInt2(String s){
        char[] romanMap = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] intMap = {1, 5, 10, 50, 100, 500, 1000};
        int j = 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (romanMap[j] == c){
                count += intMap[j];
            }else if(j>0 && romanMap[j-1] == c){
                count -= intMap[j-1];
            }else if(j>1 && romanMap[j-2] == c){
                count -= intMap[j-2];
            }else {
                j++;
                i++;
            }
        }
        return count;
    }

    public static int romanToInt1(String s){
        int result = 0;
        char[] ss = s.toCharArray();
        int index,nextIndex;
        int r1,r2;
        int i = 0;
        while (i<ss.length) {
            if(i+1<ss.length){
                index = ROMANS.indexOf(ss[i]);
                nextIndex = ROMANS.indexOf(ss[i+1]);
                if (index>=nextIndex) {
                    r1 = fromRomanToInt2(index);
                    result+=r1;
                    i++;
                }else{
                    r1 = fromRomanToInt2(index);
                    r2 = fromRomanToInt2(nextIndex);
                    result+=(r2-r1);
                    i+=2;
                }
            }else{
                index = ROMANS.indexOf(ss[i]);
                r1 = fromRomanToInt2(index);
                result+=r1;
                i++;
            }
        }
        return result;
    }

    public static int fromRomanToInt2(int i){
        int re = 0;
        switch (i){
            case 0:re = 1;break;
            case 1:re = 5;break;
            case 2:re = 10;break;
            case 3:re = 50;break;
            case 4:re = 100;break;
            case 5:re = 500;break;
            case 6:re = 1000;break;
            default:re = 0;
        }
        return re;
    }

    public static int fromRomanToInt1(int i) {
        double index = i/2.0;
        if(Math.round(index)==index){
            return (int)Math.pow(10,index);
        }else{
            double d = Math.pow(10,index-0.5);
            return (int)(Math.round(Math.pow(10,index)/d)*d+2*d);
        }
    }
}
