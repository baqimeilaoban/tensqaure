package com.tensquare.test;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] c = s.split(" ");
        int[] num = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            num[i] = Integer.parseInt(c[i]);
        }
        System.out.println(FindGreatestSumOfSubArray(num));
    }

    public static  int FindGreatestSumOfSubArray(int[] array){
        if (array==null || array.length==0){
            return 0;
        }
        int currentSum = 0;
        int finalGreatSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (currentSum<0){
                currentSum=array[i];
            }else {
                currentSum+=array[i];
            }
            if (finalGreatSum<currentSum){
                finalGreatSum=currentSum;
            }
        }
        return finalGreatSum;
    }
}
