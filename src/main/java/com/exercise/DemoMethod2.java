package com.exercise;

public class DemoMethod2 {
    public static void main(String[] args) {
        System.out.println(compair(4,3));

    }

//   public static void getSum(int a,int b){
//        int result =a+b;
//       System.out.println("结果是："+result);
//    }

    public static int compair(int a,int b){
        if (a>b){
            return a;
        }else{
            return b;
        }
    }

}
