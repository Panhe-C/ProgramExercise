package 笔试.三六零_0815;



/*
* https://unclegem.cn/2018/08/27/Leetcode%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0-892-%E4%B8%89%E7%BB%B4%E5%BD%A2%E4%BD%93%E7%9A%84%E8%A1%A8%E9%9D%A2%E7%A7%AF/
*
* */

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();


        int[][] Aij = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Aij[i][j] = scanner.nextInt();
            }
        }

        System.out.println(surfaceArea(Aij));

    }

    public static int surfaceArea(int[][] grid) {

        int area = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0)
                    area += 4 * grid[i][j] + 2;
                if (i < grid.length - 1)
                    area -= Math.min(grid[i][j], grid[i + 1][j]) * 2;
                if (j < grid[0].length - 1)
                    area -= Math.min(grid[i][j], grid[i][j + 1]) * 2;
            }
        return area;
    }
}
