package 笔试.贝壳_0823;

import java.util.Scanner;

public class forth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
            sum += num[i];
        }

        int half = sum/2;


        int[] dp = new int[half+1];
        for (int i = 0; i < n; i++) {
            for (int j = half; j >=num[i] ; j--) {
                if(j > num[i]){
                    if(dp[j-num[i]] > 0){
                        dp[j] = dp[j]==0 ? dp[j-num[i]] + 1 : Math.min(dp[j],dp[j-num[i]]+1);
                    }
                }else {
                    if(dp[j] == 0)
                        dp[j] = 1;
                    else
                        dp[j] = Math.min(1,dp[j]);
                }
            }
        }


        int x1=0,x2=0,num1=0,num2=0;
        for (int i = half; i >=0 ; i--) {
            if(dp[i] > 0){
                x1=i;
                x2=sum-x1;
                num1=dp[i];
                num2=n-num1;
            }
        }
        System.out.println(Math.abs(x1-x2)+" "+Math.abs(num1-num2));

    }

}
