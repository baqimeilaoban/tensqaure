package com.tensquare.test;

import java.util.Scanner;

public class Fobonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));
    }

    static int f(int n){
        int a=1,b=1,c=0;
        for (int i=1;i<=(n-2);i++){
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
