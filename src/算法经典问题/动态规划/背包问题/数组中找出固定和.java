package 算法经典问题.动态规划.背包问题;

/*
 * 判断是否有和为100的组合
 * https://blog.csdn.net/qq_19446965/article/details/81775702
 * */

public class 数组中找出固定和 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 59, 20, 80, 99, 98};
        int sum = 100;
        System.out.println(findSum(arr, sum));
    }


    public static boolean findSum(int[] a, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[a[0]] = true;
        for (int i = 1; i < a.length; i++) {
            for (int j = sum; j >= a[i]; j--) {
                if (dp[j - a[i]]) {
                    dp[j] = true;
                }
            }
            if (dp[sum]) {
                return true;
            }
        }
        return false;
    }
}