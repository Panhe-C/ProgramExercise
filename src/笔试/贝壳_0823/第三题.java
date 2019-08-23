package 笔试.贝壳_0823;

import java.util.Scanner;

/*
*
* 小明捡贝壳，背包容量有限；希望先捡价值最大的；如果价值打的贝壳装不下，再考虑价值次大的贝壳，直到背包再也装不下；
*
* 输入：
*   第一行：两整数：n,m;标识贝壳的种数和背包的体积
*   接下来n行，第i行两个整数xy，分表标识价值第i大的贝壳的数量和单个贝壳所占的体积：1≤x≤200000;1≤y≤200000;即从上到下输入的贝壳价值越来越小
*
* 输出：
*   一个整数，表示按要求背包中最多可以装下的贝壳数量
*
* 输入：
4 100
3 40
3 6
1 1
1 5
  输出：
    6
* */


public class 第三题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int kinds=in.nextInt();
        long capacity=in.nextLong();
        int p=0;
        long count=0l;
        while(p<kinds && capacity>0){
            int num=in.nextInt();
            int volume=in.nextInt();
            while(capacity>0 && capacity >= volume && num>0) {
                capacity-=volume;
                count++;
                num--;
            }
            p++;
        }
        System.out.println(count);
    }
}
