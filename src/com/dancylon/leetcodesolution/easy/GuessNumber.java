package com.dancylon.leetcodesolution.easy;

public class GuessNumber {
    public static void main(String[] args) {

    }

    private static int guessNumber(int[] guess,int[] answer){
        int n = 0;
        for (int i=0;i<3;i++) {
            if(guess[i]==answer[i])n++;
        }
        return n;
    }
}
