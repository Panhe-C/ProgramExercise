package 算法经典问题.动态规划;


/*
一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。

该三角形第n层有n个数字，例如：

第一层有一个数字：5

第二层有两个数字：8 4

第三层有三个数字：3 6 9

第四层有四个数字：7 2 9 5

5
8 4
3 6 9
7 2 9 5


最优方案是：5 + 8 + 6 + 9 = 28

注意:上面应该是排列成一个三角形的样子不是竖向对应的，排版问题没有显示成三角形。



状态定义：Fi,j，是第i行第j列项最大取数和，求第n行Fn,m种最大值
状态转移方程： Fi,j = max{ Fi-1,j-1  Fi-1,j} + Ai,j




 ————————————————
版权声明：本文为CSDN博主「QuinnNorris」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/QuinnNorris/article/details/77484573



* */


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 楼塔取数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//有n层
        long max = 0;

        int[][] dp = new int[n][n];
        dp[0][0] = scanner.nextInt();//第一层只有一个数，加入dp数组中

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = scanner.nextInt();//第i层第j个数
                if(j == 0){//如果是每一层的第一个数，那他只能加上上一层的第一个数
                    dp[i][j] = dp[i-1][j] + num;
                }else dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + num;

                max = Math.max(dp[i][j],max);//存入最大和
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(max);
    }
}
