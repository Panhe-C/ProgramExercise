package 算法经典问题.动态规划;


/*
N个整数组成的序列a[1],a[2],a[3],…,a[n]，求该序列如a[i]+a[i+1]+…+a[j]的连续子段和的最大值。
当所给的整数均为负数时和为0。
例如：-2,11,-4,13,-5,-2，和最大的子段为：11,-4,13。和为20。
*
* */

public class 最大子段和 {
    public static void main(String[] args) {

        int[] arr = {-2,11,-4,13,-5,-2};
        System.out.println(maxSubSum(arr));
    }




    /*
    *
    * 已知前n个数的最大子段和，那么前n+1个数的最大字段和有两种情况，一是包含前面的结果，二是不包含。
    具体做法是这样的，序列a[]有n个数，我们就要做n次决策，从第一个数开始（下标从0开始），假设已经做好了前i个数的决策，并把做第i个数的最大子段和的结果保存到了tem
   （注意，前i个数的最大子段和sum和第i个数决策的子段和tem是不一样的，前者sum可能不包含第i个数，但第i个数决策的子段和tem一定包含tem，sum是当前最大子段的和，
    而tem是包含第i个数的子段和，并想办法使tem的值尽可能的大），
    当做第i+1个数的决策时，要做的工作就只是判断包含第i+1个数的子段和是否要把tem的值包进来，如果tem>0，就包括，否则不包括。
    （再看一下总的想法）假设前n个数的最大子段和是tem，在决策前n+1个数的最大子段和时，判断tem的值，如果tem>0,那么前n+1个数的最大子段和为tem加上第n+1个数，否则就是第n+1个数自己。这里记住，你所求的是连续的几个数的和。
    原文链接：https://blog.csdn.net/zhong36060123/article/details/4381391*/
    public static int maxSubSum(int[] arr){

        int sum = 0;//sum保存当前连续几个数的和的最大值，只是记录目前算得的最大值
        int tempSum = 0;//tem表示决策第i个数时所保存的第i-1个数决策状态

        int begin=0,end=0;

        for (int i = 0; i < arr.length; i++) {
            if(tempSum > 0)
                tempSum += arr[i];//若tem>0，说明可
            else {
                tempSum = arr[i];
                begin = i;//若tem<=0，说明重新计算最大字段和，计下开始位置
            }

            if(tempSum > sum){
                sum = tempSum;
                end = i;//若tem>sum,说明刷新了最大字段和的值，计下结束位置
            }
        }

        return sum;
    }
}
