package 笔试.招银笔试_0906;


/*
* 'A':Absent
* 'L':Late
* 'p':Present
*
* 组合不能有超过一个A，不能超过连续两个L
*
* */

import java.util.Scanner;

public class StudentAttendanceRecord {

    private static long M = 1000000007;
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        System.out.println(checkRecord(3));
    }



    /*
    *
    * dp[i] = total number of rewardable student records whih i len
    * 1.without A
    *   1)end with p
    *       dp[i] = dp[i - 1];
    *   2)end with L
    *       ...PLLL
    *       dp[i] = dp[i -1] - dp[i - 4];
    * 2.with A
    *   Assume A is in index i
    *   [... i - 1] A [i + 1,...n]
    *   dp[i - 1] * dp[n - i]
    *
    *
    * */

    public static int checkRecord(int n){
        long[] dp = new long[n <= 3 ? 4 : n+1];

        //没有A
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        dp[3] = 7;
        for (int i = 4; i <= n; i++) {
//            dp[i] = 2 * dp[i - 1] - dp[i - 4];
            dp[i] = (2 * dp[i - 1])% M + (M - dp[i - 4])% M;//书太大，对M取模
        }

        long sum = dp[n];
        for (int i = 1; i <=n ; i++) {
            sum += (dp[i - 1] * dp[n - i]) % M;
        }
        return (int)(sum % M);
    }
}
