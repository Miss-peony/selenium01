package com.exercise;

public class DemoMethod {
    public static void main(String[] args) {
//       int c=getSum();
        System.out.println(getSum());

    }

    //    计算1到100的和：
    public static int  getSum(){
        int sum = 0;
        for (int i = 1; i < 101; i++) {

            sum = sum + i;
        }
        return sum;
    }

}