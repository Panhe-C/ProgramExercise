package 算法经典问题.动态规划.背包问题;


/*
V(i,j) : 当前背包容量j，前i个物品的最佳组合对应的价值

当前重量为j,准备放入物品i，放入数量为conut = max(nums[i],j/weight[i])
递推关系式：
  j < w[i]  V(i,j) = V[i-1,j]   第i个物品大于背包容量，直接不装
  j ≥ w[i]  V(i,j) = MAX{V[i-1][j-conut*w[i]] + conut*v[i],V[i-1][j]}  考虑继续放第i个物品和不放入i物品的价值大小
*
*
* */

import java.util.Arrays;

public class 多重背包 {
    public static void main(String[] args) {
        int[] weights = {1,2,3};
        int[] values =  {6,10,20};
        int[] nums = {10,5,2};
        int capacity = 8;
        System.out.println(maxValue(weights,values,nums,capacity));
    }

    private static int maxValue(int[] weights, int[] values, int[] nums, int capacity) {
        int row = weights.length+1;
        int col = capacity+1;

        int[][] result = new int[row][col];

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(j < weights[i-1]){
                    result[i][j] = result[i-1][j];
                }else {
                    int count = Math.min(nums[i-1],j/weights[i-1]);
                    result[i][j] = Math.max(result[i-1][j-count*weights[i-1]]+count*values[i-1],result[i-1][j]);
                }
            }
        }

        //输出结果数组
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        return result[row-1][col-1];

    }
}
