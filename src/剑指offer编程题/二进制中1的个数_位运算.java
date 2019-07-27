package 剑指offer编程题;


import org.junit.Test;

/*
* 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
* */
public class 二进制中1的个数_位运算 {

    @Test
    public static int NumberOf1(int n) {
        int i = 0;
        String c = Integer.toBinaryString(n);
        char[] bi = Integer.toBinaryString(n).toCharArray();
        for(int k = 0;k < bi.length;k++){
            if(bi[k] == '1'){
                i++;
            }
        }

        return i;
    }


    /*
    * 解题思路：整数-1的二进制，实际是最右边的1之后都取反了；
    * 所以把原来的整数跟减去1之后的整数做与运算，从原来整数最右边一个1那一位开始所有位都会变成0；
    * 一个整数的二进制有多少个1，就可以进行多少次这样的操作
    * */

    @Test
    public static int NumberOf1_2(int n) {

        int i = 0;
        while(n != 0){
            n = n & (n-1);
            i++;
        }

        return i;
    }

    public static void main(String[] args) {

        System.out.println(NumberOf1_2(3333));
        System.out.println(NumberOf1(3333));
    }
}
