package 算法经典问题.动态规划.背包问题;


import java.lang.reflect.Array;
import java.util.Arrays;

/*

V(i,j) : 当前背包容量j，前i个物品的最佳组合对应的价值


递推关系式：
  j < w[i]  V(i,j) = V[i-1,j]   第i个物品大于背包容量，直接不装
  j ≥ w[i]  V(i,j) = MAX{V[i-1][j-w[i]]+v[i],V[i-1][j]}  比较装入和不装入第i个物品的价值大小选择较大的组合价值


结果数组：
    [0, 0, 0, 0, 0, 0, 0, 0, 0]
    [0, 0, 3, 3, 3, 3, 3, 3, 3]
    [0, 0, 3, 4, 4, 7, 7, 7, 7]
    [0, 0, 3, 4, 5, 7, 8, 9, 9]
    [0, 0, 3, 4, 5, 7, 8, 9, 10]

* */
public class 背包问题 {
    public static void main(String[] args) {
        int[] weights = {2,3,4,5};
        int[] values =  {3,4,5,6};
        int capacity = 8;
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
                    result[i][j] = Math.max(result[i-1][j],result[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }

        //输出结果数组
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        return result[row-1][col-1];
    }


    //优化：用一维数组来保存结果，相当于保存每一列的最大值，但是第二层循环要倒置
    public static int maxValue2(int[] weights, int[] values, int capacity){
        //优化
        int length = capacity +1;
        int[] result = new int[length];

        for (int j = 0; j < weights.length; j++) {//第j个物品
            for (int i = length-1; i >= 1; i--) {//从后往前循环
                if(weights[j] <= i){
                    result[i] = Math.max(result[i], result[i-weights[j]] + values[j]);//求每列最大值即可
                }
            }
        }
        return result[length-1];
    }

    /**
     * @param result ： 结果数组
     * @param goods : 用来保存物品选择结果的数组
     * @param weights
     * @param values
     * @param i ： 最优解的坐标
     * @param j ： 最优解的坐标
     */
    //回溯法，获得物品的放法
    public static void getGoods(int[][] result, int[] goods, int[] weights, int[] values,int i, int j){

        if( i >= 1){
            if(result[i][j] == result[i-1][j]){
                goods[i] = 0;
                getGoods(result,goods,weights,values,i-1,j);
            }else if( j - weights[i-1] >= 0 && result[i][j] == result[i-1][j-weights[i-1]]+values[i-1]){
                goods[i] = 1;
                getGoods(result,goods,weights,values,i-1,j);
            }
        }
    }

}

