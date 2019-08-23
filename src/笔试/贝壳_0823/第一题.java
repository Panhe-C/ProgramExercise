package 笔试.贝壳_0823;

import java.util.Arrays;
import java.util.Scanner;


/*
* 用s元去健身房，有n种器材，第i种器材的费用为c[i]，最多能使用多少种器材
*
* 输入：
*   第一行：两个正整数：n,s
*   第二行：n个正整数，第i个表示第i种器材费用
*
* 输入：
*   5 10
    3 9 5 7 6
  输出：
    2
* */

public class 第一题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int s=in.nextInt();
        int[] c=new int[n];
        for(int i=0;i<n;i++){
            c[i]=in.nextInt();
        }
        Arrays.sort(c);
        int re=0;
        int p=0;
        while(s>0 && s>=c[p]){
            s-=c[p];
            re++;
            p++;
        }
        System.out.println(re);
    }
}
