package 算法经典问题.动态规划;

/*
* 硬币面值1，2，5，数量若干
* 凑出11块钱的最小硬币书
*
* */

public class 凑硬币 {

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int money = 11;
        System.out.println(sol(coins,money));

    }


    //https://cloud.tencent.com/developer/article/1465512
    //设f(x) = y表示，集齐x元最少需要y个硬币
    //f(i) = min{1 + f(i - coins[j])},(0<=j<=coins)
    public static int sol(int[] coins,int budget){
        int[] dp = new int[budget + 1];

        for (int i = 0; i < budget+1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < budget + 1; i++) {
            int min = dp[i];
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i){
                    if(1 + dp[i-coins[j]] < min){
                        min = dp[i - coins[j]] + 1;
                    }
                }
            }
            dp[i] = min;
        }

        for(int n : dp){
            System.out.println(n);
        }
        return dp[budget];
    }
}
