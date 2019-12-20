package com.zhu;

import java.util.Arrays;

public class 斐波那契 {
    public int Fibonacci(int n) {


        if(n<2)
            return n;
        int fn_1 = 0;
        int fn_2 = 1;
        int nIndex = 2;
        while(nIndex++<n){
            int temp = fn_1;
            fn_1 = fn_2;
            fn_2 = fn_2+temp;
        }
        return fn_1+fn_2;
    }


}
