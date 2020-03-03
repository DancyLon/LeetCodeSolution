package com.dancylon.leetcodesolution.easy;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        String ss = "(([]){})";
        boolean flag = isValid1(ss);
        System.out.println('}'-'{');
    }

    /**
     * ')'-'('==1
     * ']'-'['==2
     * '}'-'{'==2
     * */
    public static boolean isValid4(String s){
        if (s == null || s.length() % 2 != 0) {
            return false;
        } else if (s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        char lastChar;
        for (int i = 1; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }else{
                if (s.charAt(i) == '('||s.charAt(i) == '['||s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                }else{
                    lastChar = stack.lastElement();
                    if (s.charAt(i)-lastChar== 1||s.charAt(i)-lastChar== 2) {
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    /**自制stack*/
    public static boolean isValid3(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        } else if (s.length() == 0)
            return true;
        char[] chs = new char[s.length()];
        int index = 0;
        for (char c :
                s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                chs[index++] = c;
            } else {
                if (index-- == 0)return false;
                else if(c == ')' && chs[index] != '('
                        || c == ']' && chs[index] != '['
                        || c == '}' && chs[index] != '{') {
                    return false;
                }
            }
        }
        return index==0;
    }

        public static boolean isValid2 (String s){
            if (s == null || s.length() % 2 != 0) {
                return false;
            } else if (s.length() == 0)
                return true;
            Stack<Character> stack = new Stack<Character>();
            stack.push(s.charAt(0));
            int index1 = PARENTHESES.indexOf(s.charAt(0));
            if (index1 <= 2) {
                int index2 = 0;
                for (int i = 1; i < s.length(); i++) {
                    index2 = PARENTHESES.indexOf(s.charAt(i));
                    if (index2 == index1 + 3) {
                        stack.pop();
                    } else {
                        //改进，如果不成对又是其他括号的后半部分，则直接返回false
                        if (index2 > 2) {
                            return false;
                        } else
                            stack.push(s.charAt(i));
                    }
                    index1 = stack.isEmpty() ? 3 : PARENTHESES.indexOf(stack.lastElement());
                }
                return stack.isEmpty();
            } else
                return false;
        }

        public static final String PARENTHESES = "{[(}])";
        /**
         * 用栈，如果和前一个不成对就一直放，如果成对就消掉
         * 最后如果栈是空的就说明全消掉了，返回true
         * */
        public static boolean isValid1 (String s){
            if (s == null || s.length() % 2 != 0) {
                return false;
            } else if (s.length() == 0)
                return true;
            Stack<Character> stack = new Stack<Character>();
            stack.push(s.charAt(0));
            int index1 = PARENTHESES.indexOf(s.charAt(0));
            if (index1 <= 2) {
                int index2 = 0;
                for (int i = 1; i < s.length(); i++) {
                    index2 = PARENTHESES.indexOf(s.charAt(i));
                    if (index2 == index1 + 3) {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(i));
                    }
                    index1 = stack.isEmpty() ? 3 : PARENTHESES.indexOf(stack.lastElement());
                }
                return stack.isEmpty();
            } else
                return false;
        }
    }
