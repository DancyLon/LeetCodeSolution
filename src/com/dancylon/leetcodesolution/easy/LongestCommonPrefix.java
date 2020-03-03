package com.dancylon.leetcodesolution.easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"","b"};
        String ss = longestCommonPrefix3(strs);
        System.out.println(ss);
    }


    public static String longestCommonPrefix3(String[] strs){
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length == 0) {
            return "";
        }
        int length = 1000;
        String shortness = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length()<=length) {
                shortness = strs[i];
                length = shortness.length();
            }
        }
        if ("".equals(shortness)) {
            return "";
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < length; j++) {
                if (strs[i].charAt(j) != shortness.charAt(j)) {
                    length = j;
                    break;
                }
            }
        }
        if (length == 0) {
            return "";
        }
        return shortness.substring(0,length);
    }

    //best
    public static String longestCommonPrefix2(String[] strs){
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length == 0||strs[0].equals("")) {
            return "";
        }
        String firstStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(!strs[i].startsWith(firstStr)){
                firstStr = firstStr.substring(0,firstStr.length()-1);
            }
            if(firstStr.equals(""))return "";
        }
        return firstStr;
    }

    /**取前面的几个字符逐一比较*/
    public static String longestCommonPrefix1(String[] strs){
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length == 0) {
            return "";
        }
        String ss = "";
        String press = "";
        boolean flag = true;
        for (int i = 1; i <=strs[0].length() ; i++) {
            ss = strs[0].substring(0,i);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(ss)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                if (i == 1) {
                    ss = "";
                }
                break;
            }
            press = ss;
        }
        return press;
    }
}
