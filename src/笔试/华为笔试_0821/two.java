package 笔试.华为笔试_0821;


/*
质数：除1和其本身，不被其他自然数整除
* 给定一个取值范围[low,high),找到该范围的左右质数，输出这些质数的十位数之和与个位数之和的较小值
* 如果该质数小于10，则其十位数为0
*
* 输入：
*   第一行：low，high，用列保证均不小于0，且low<high,如果没有质数输出0
* 输出：
*   输出找到的质数十位数之和与个位数之和的较小值
*输入：
*   151 160
* 输出：
*   8
*
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class two {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int low = s.nextInt();
        int high = s.nextInt();


        List<Integer> list = new ArrayList<>();

        for (int i = low; i < high; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if(i/j * j == i){
                    count++;
                }
            }
            if(count == 2){
                list.add(i);
            }
        }

        int tenSum = 0;
        int oneSum = 0;
        for (int i = 0; i < list.size(); i++) {
            tenSum += (list.get(i)/10) % 10;
            oneSum += list.get(i) % 10;
        }

        System.out.println(tenSum < oneSum ? tenSum : oneSum);

        /*
        *
        * 个位数：units = i % 10
        * 十位数: tens = (i/10)%10
        * 百位数: hundreds = (i/100)%10
        *
        * */

    }
}
