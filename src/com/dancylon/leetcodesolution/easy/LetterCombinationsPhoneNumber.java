package com.dancylon.leetcodesolution.easy;


import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {

    }
    private final static  Character[][] arr = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},
            {'t','u','v'},{'w','x','y','z'}};

    private final static String[] STRING_ARR = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<String>();
        getStringArr1(digits,"",0,list);
        return list;
    }

    private static void getStringArr1(String digits,String pre,int n,List<String> list){
        if (n < digits.length()-1) {
            for (int i = 0; i < arr[digits.charAt(n)-50].length; i++) {
                getStringArr1(digits,pre+arr[digits.charAt(n)-50][i],n+1,list);
            }
        }else{
            for (int i = 0; i < arr[digits.charAt(n)-50].length; i++) {
               list.add(pre+arr[digits.charAt(n)-50][i]);
            }
        }
    }

    private static void getStringArr2(String digits,String pre,int n,List<String> list){
        Integer in = Integer.valueOf(digits.charAt(n)+"");
        String letter = STRING_ARR[in];
        if (n < digits.length()-1) {
            for (int i = 0; i < letter.length(); i++) {
                getStringArr2(digits,pre+letter.charAt(i),n+1,list);
            }
        }else{
            for (int i = 0; i < letter.length(); i++) {
                list.add(pre+letter.charAt(i));
            }
        }
    }

    private static void getStringArr3(String digits,String pre,List<String> list){
        if (digits == null||digits.length()==0) {
            list.add(pre);
            return;
        }
        Integer in = Integer.valueOf(digits.charAt(0)+"");
        String letter = STRING_ARR[in];
        for (int i = 0; i < letter.length(); i++) {
            getStringArr3(digits.substring(1),pre+letter.charAt(i),list);
        }
    }

}
