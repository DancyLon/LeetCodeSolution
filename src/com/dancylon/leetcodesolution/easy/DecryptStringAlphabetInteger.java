package com.dancylon.leetcodesolution.easy;

public class DecryptStringAlphabetInteger {
    public static void main(String[] args) {
        String s = freqAlphabets2("10#11#12");
        System.out.println(s);
    }

    //a-z = 97-122
    public static String freqAlphabets1(String s) {
        char[] chs = s.toCharArray();
        int i = chs.length - 1;
        s = "";
        while (i >= 0) {
            if (chs[i] == '#') {
                if (chs[i - 2] == 49) {
                    s = (char) (chs[i - 2]+chs[--i]+9) + s;
                }else{
                    s = (char) (chs[i - 2]+chs[--i]+18) + s;
                }
                i--;
            } else {
                s = (char) (chs[i] + 48) + s;
            }
            i--;
        }
        return s;
    }

    public static String freqAlphabets2(String s){
        char[] chs = s.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder(chs.length);
        int n;
        while (i<=chs.length-1) {
            if (i<=chs.length-3&&chs[i+2] == '#') {
                n = (chs[i++]-'0')*10+chs[i++]-'0';
            } else {
                n = chs[i]-'0';
            }
            i++;
            sb.append((char)('a'+n-1));
        }
        return sb.toString();
    }
}
