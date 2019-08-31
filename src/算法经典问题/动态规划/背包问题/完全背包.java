package 算法经典问题.动态规划.背包问题;

import java.util.Arrays;


/*
V(i,j) : 当前背包容量j，前i个物品的最佳组合对应的价值


递推关系式：
  j < w[i]  V(i,j) = V[i-1,j]   第i个物品大于背包容量，直接不装
  j ≥ w[i]  V(i,j) = MAX{V[i][j-w[i]] + v[i],V[i-1][j]}  考虑继续放第i个物品和不放入i物品的价值大小
*
**/

public class 完全背包 {
    public static void main(String[] args) {
        int[] weights = {2,3,4,7};
        int[] values =  {1,3,5,9};
        int capacity = 10;
        System.out.println(maxValue(weights,values,capacity));
        System.out.println(maxValue2(weights,values,capacity));
    }

    private static int maxValue(int[] weights, int[] values, int capacity) {
        int row = weights.length+1;
        int col = capacity+1;
        int[][] result = new int[row][col];//数组默认初始化值为0

        for (int i = 1; i < row; i++) {//i指第i个物品
            for (int j = 1; j < col; j++) {//j为背包当前容量
                if(j < weights[i-1]){
                    result[i][j] = result[i-1][j];
                }else {
//                    result[i][j] = Math.max(result[i-1][j],result[i-1][j-weights[i-1]]+values[i-1]);
                    result[i][j] = Math.max(result[i-1][j],result[i][j-weights[i-1]]+values[i-1]);//考虑可能需要继续放入当前物品
                }
            }
        }

        //输出结果数组
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        return result[row-1][col-1];
    }


    /**
     *
     * 优化：
     *  空间优化，用一维数组解决二维数组的思路。
     *  仔细分析填表的过程就可以发现，当判断物品i时，只需保存小于等于物品i-1的重量的状态，而其它的状态不用保存，相当于每一列都保存最大值即可。
     * @param weights
     * @param values
     * @param capacity
     * @return
     */
    public static int maxValue2(int[] weights, int[] values, int capacity){
        int length = capacity + 1;
        int[] result = new int[length];

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < weights.length; j++) {
                if(i >= weights[j]){
                    result[i] = Math.max(result[i],result[i-weights[j]]+values[j]);
                }
            }
        }
        return result[length-1];
    }

}
