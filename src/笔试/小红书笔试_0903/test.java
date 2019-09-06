package 笔试.小红书笔试_0903;
/*
*
5 10 20
1 4
0 3
2 2
4 4
1 7
1 3
2 3
1 8
3 7
3 5
1 5
3 9
4 8
4 0
4 1
2 1
0 7
2 4
4 5
0 8
*
* 输出0
* */
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] things = new int[n][m];
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            things[x][y] = 1;
        }
        if(things[0][0] == 1 || things[n-1][m-1] == 0){
            System.out.println("0");
            return;
        }

        int[][] dp = new int[n][m];

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(things[i][j] == 1){
                    dp[i][j] = 0;
                }else if (i == 0){
                    if(j > 0)
                        dp[i][j] = dp[i][j-1];
                }else if(j == 0){
                    if(i > 0)
                        dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
