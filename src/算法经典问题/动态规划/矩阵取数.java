package 算法经典问题.动态规划;


/*
一个N*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，从左上走到右下，只能向下向右走，求能够获得的最大价值。例如：3 * 3的方格。

1 3 3
2 1 3
2 2 1

能够获得的最大价值为：11。


状态方程：Fi,j走到第i行第j列的最大价值，求Fn,n
状态转移方程：Fi,j = max{Fi-1,j   Fi,i-1} + Ai,j


*
* */

import java.util.Arrays;
import java.util.Scanner;

public class 矩阵取数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//矩阵阶数

        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                int num = in.nextInt();
                if(j == 1) dp[i][j] = dp[i-1][j] + num;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + num;
            }
        }

        for (int i = 0; i < n+1; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[n][n]);
    }
}
