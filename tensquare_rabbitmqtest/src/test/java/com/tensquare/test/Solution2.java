package com.tensquare.test;

import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String mul = multiply(s1,s2);
        System.out.println(mul);
    }

    public static String multiply(String num1,String num2){
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        String res = "0";
        for (int i=num2.length()-1;i>=0;i--){
            int carry=0;
            StringBuilder temp = new StringBuilder();
            for (int j=0;j<num2.length()-1-i;j++){
                temp.append(0);
            }
            int n2 = num2.charAt(i)-'0';
            for (int j=num1.length()-1;j>=0 || carry!=0;j--){
                int n1 = j<0 ? 0:num1.charAt(j)-'0';
                int product = (n1*n2+carry)%10;
                temp.append(product);
                carry = (n1*n2+carry)/10;
            }
            res = addStrings(res,temp.reverse().toString());
        }
        return res;
    }

    public static String addStrings(String num1, String num2){
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length()-1,j=num2.length()-1; i >= 0 || j>=0 || carry!=0 ; i--,j--) {
            int x = i<0 ? 0 : num1.charAt(i)-'0';
            int y = j<0 ? 0 : num2.charAt(j)-'0';
            int sum = (x+y+carry)%10;
            builder.append(sum);
            carry = (x+y+carry)/10;
        }
        return builder.reverse().toString();
    }
}
