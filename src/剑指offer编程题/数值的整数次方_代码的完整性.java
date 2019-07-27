package 剑指offer编程题;


/*
*给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
* */

import static java.lang.Math.abs;

public class 数值的整数次方_代码的完整性 {

    public static double Power(double base, int exponent) {
        double result = 1.0;
        int bound = 0;
        if(exponent >= 0){
            bound=exponent;
        }else{bound = - exponent;}

        for(int i = 0;i<bound;i++){
            result = result * base;
        }

        return exponent>0 ? result : 1/result;

    }


    public static void main(String[] args) {
        Power(2,3);
    }
}
