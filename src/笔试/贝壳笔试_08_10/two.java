package 笔试.贝壳笔试_08_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/*
序列[5,1,6,2,4]
最长上升子序列为[1,2,4]
* 输入：
    8
    5
    1
    6
    8
    2
    4
    5
    10
输出：
    5
*
*
*
* */

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }


        int len = 0;

        int[] dp = new int[array.length];
        dp[0] = 1;
        //dp[i]表示到i为止是最长递增子序列的长度
        for (int i = 0; i < arrayLength; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(array[i] > array[j]){
                    //求dp[i]时遍历，dp[0...i-1]，找出arr[j]<arr[i]小且dp[j]是最大的
                    //dp[i]=dp[j]+1;
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }

        for (int i = 0; i < arrayLength; i++) {
            len = Math.max(dp[i],len);
        }

        System.out.println(len);

    }



    public static int rec_solution(int[] arr,int index,int length){
        if (index == 0){return length;}
        if(arr[index-1] > arr[index]){
            rec_solution(arr,index-1,length);
        }
//        if (index == 1){return length;}

        int length1 = rec_solution(arr,index-1,length);
        int length2 = rec_solution(arr,index-1,length+1);
        return length1>length2 ? length1 : length2;
    }


    public static int dp_solution(int[] arr){
        int[][] state = new int[arr.length][arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            state[i][0] = 1;
        }
        for (int i = 0; i < arr.length+1; i++) {
            state[0][i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length + 1; j++) {
                if(arr[i] < arr[j-1]){
                    state[i][j] = state[i-1][j];
                }else {
                    int length1 = state[i-1][j];
                    int length2 = state[i-1][j] + 1;
                    state[i][j] = length1>length2?length1:length2;
                }
            }
        }

        return state[arr.length-1][arr.length];






    }

}
