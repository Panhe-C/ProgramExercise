package 笔试.顺丰笔试_0829;

/*
5
1 2 1 3 4
*
* */

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(LongestIncreaseSubString(arr));
    }

    public static int LongestIncreaseSubString(int[] arr){
        int len=0;
        if(arr==null||arr.length==0)
            return 0;
        int dp[]=new int[arr.length];
        dp[0]=1;
        //dp[i]表示到数组第i个元素为止的最长递增子序列的长度

        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j]){
                    //求dp[i]时要遍历0~i-1,如果第i个元素比前面的某个元素大，则在那个元素的之后加上i元素是子序列长度+1；并遍历，求出dp[0~i-1]中满足比i元素小的加一后子序列长度会最长
                    //若i之前没有比i元素小的，则dp[i]的值为1，即子序列只有i元素一个
                    dp[i]  =Math.max(dp[i],dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            len = Math.max(dp[i],len);
        }
        return len;
    }
}
