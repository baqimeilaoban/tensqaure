package com.tensquare.test;

import java.util.Scanner;

public class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int price = Integer.parseInt(sc.nextLine());
        int n  = Integer.parseInt(sc.nextLine());
        int max = 0;
        int[] num = new int[2*n];
        for (int i=0;i<n;i++){
            String str = sc.nextLine();
            String[] temp = str.split(" ");
            num[2*i] = Integer.parseInt(temp[0]);
            num[2*i+1] = Integer.parseInt(temp[1]);
        }
        for (int i=0;i<2*n-1;i=i+2){
            int temp = num[i];
            int tempmax = num[i+1];
            for (int j=i+2;j<2*n-1;j=j+2){
                int temp1 = temp;
                temp = temp+num[j];
                if (temp<price){
                    tempmax = num[j+1]+tempmax;
                    max = Math.max(max,tempmax);
                }else {
                    temp = temp1;
                    continue;
                }
            }
        }
        System.out.println(max);
    }
}
