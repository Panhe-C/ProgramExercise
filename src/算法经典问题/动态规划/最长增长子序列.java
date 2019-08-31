package 算法经典问题.动态规划;






/*
给出长度为N的数组，找出这个数组的最长递增子序列。
(递增子序列是指，子序列的元素是递增的）
例如：5 1 6 8 2 4 5 10，最长递增子序列是1 2 4 5 10


*
* */

import java.util.*;

public class 最长增长子序列 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int length = scanner.nextInt();
//        int[] arr = new int[length];
//        for (int i = 0; i < length; i++) arr[i] = scanner.nextInt();

        int[] arr = {5,1,6,8,2,4,5,10};

        System.out.println(LongestIncreaseSubString(arr));
        System.out.println(LongestIncreaseSubString2(arr));
    }




    /*
    1.定义长度为n的dp数组，dp[i]表示为arr[i]结尾的最长递增子序列的长度。

    2.对于第一个数arr[0]来说dp[0]=1,依次求出以i结尾的最长递增子序列

    3.对于dp[i],求arr[i]结尾的最长递增子序列，在arr[0..i-1]中选出比arr[i]小且长度最长的

    dp[j] , dp[i] = Math.max( dp[0…i-1] , dp[i] );如果所有的 dp[0…i-1] 都比 dp[i] 大，则 dp[i]=1;
                        原文链接：https://blog.csdn.net/u013309870/article/details/62037674
    *
    * */

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
        generateLIS(arr,dp);
        return len;
    }


    //求出递增子序列
    //先找到最大dp[i],从后往前，若dp[i] == dp[j]+1且arr[i]<arr[j],则可知arr[j]是子序列中的arr[i]前面的数

    public static void generateLIS(int[] arr,int[] dp){
        int k = 0;
        int index = 0;
        int len = 0;

        for (int i = 0; i < arr.length; i++) {
            if(dp[i] > len){
                len = dp[i];
                index = i;
                //找到最长子序列的长度对应的下标
            }
        }

        int[] subArr = new int[len];
        subArr[k++] = arr[index];

        for (int j = index-1; j >= 0; j--) {
            if( (dp[index] == dp[j]+1) && (arr[index]>arr[j]) ){
                subArr[k++] = arr[j];
                index = j;
            }
        }

//        List<Object> list = Arrays.asList(subArr);
//        Collections.reverse(list);
//        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(Arrays.toString(subArr));
    }

    /*
    *
    *生成 dp 数组时使用二分查找算法来进行。

    用ends数组来保存单调序列，这个序列并不是 最优值的单调序列，对于arr[i],如果比 ends 中的每个

    数都大时放到 ends 后面，否则用arr[i]代替ends数组中第一个比arr[i]大的数，保持 ends 递增。这样

    每一个arr[i]在ends的位置就是 dp[i] 的值。
    */

    public static int LongestIncreaseSubString2(int[] arr){
        if(arr==null||arr.length==0)
            return 0;


        int l=0,r=0,right=0;
        int len=0;
        int ends[]=new int[arr.length];
        int dp[]=new int[arr.length];
        dp[0]=1;
        ends[0]=arr[0];
        //ends[0]开始时存放arr[0],


        for(int i=1;i<arr.length;i++)
        {
            l = 0;
            r = right;
            //1.如果arr[i]比 ends 数组中的所有元素都大则放到 ends 后面，
            //2.否则用arr[i]代替ends数组中第一个比arr[i]大的数，保持 ends 递增。
            while(l<=r)
            {
                int mid=(l+r)/2;//二分法查找
                if(arr[i]>ends[mid])
                {
                    l=mid+1;
                }
                else {
                    r=mid-1;
                }
            }
            right = Math.max(l,right);//l记录的是最后一个比arr[i]小的数的下标+1；//right记录的是ends目前已经存放了数的最右下标；//如果是第一种情况，ends范围则会加一，否则不变长度
            ends[l] = arr[i];
            dp[i] = l+1;
            //arr[i]在数组 ends 中的位置，就是以arr[i]结尾的最长单调子序列的长度。
        }
        len=right+1;

        generateLIS(arr,dp);
        return len;
    }

}
