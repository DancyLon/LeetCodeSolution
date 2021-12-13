package com.dancylon.leetcodesolution.easy;

public class JewelsAndStones {
    public static void main(String[] args) {

    }

    public static int numJewelsInStones1(String J, String S) {
        char[] jarr = J.toCharArray();
        char[] sarr = S.toCharArray();
        int n = 0;
        for (int i = 0; i < jarr.length; i++) {
            for (int j = 0; j < sarr.length; j++) {
                if (jarr[i] == sarr[j]) {
                    n++;
                }
            }
        }
        return n;
    }

    public static int numJewelsInStones2(String J, String S) {
        int n = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    n++;
                }
            }
        }
        return n;
    }

    public static int numJewelsInStones3(String J, String S) {
        int n = 0;
        for (int i = 0; i < S.length(); i++) {
            if (J.indexOf(S.charAt(i)) != -1) {
                n++;
            }
        }
        return n;
    }

    public static int numJewelsInStones4(String J, String S) {
        int n = 0;
        char[] sarr = S.toCharArray();
        for (int i=0;i<sarr.length;i++) {
            if (J.indexOf(sarr[i]) != -1) {
                n++;
            }
        }
        return n;
    }
}
