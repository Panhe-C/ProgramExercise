package 笔试.贝壳笔试_08_10;


/*
* 请求队列中的请求符合必须按照先递增后递减的规律（仅递增或仅递减也可以），比如[1,2,8,4,3],[1,3,5],[10]都满足规律；
* [1,2,2,1][2,1,2][10,10]不符合规律；
*
* 给一个请求队列，可以对请求的负荷进行增加，调整队列中请求的负荷值，使数组满足条件在，最后输出队列满足条件最小的增加总和。
*
* 输入：
*   5
*   1 4 3 2 5
* 输出：
*   6
*
* */


import java.util.Arrays;
import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] mq = new int[num];
        long[] nums = new long[num];
        for (int i = 0; i < num; i++) {
//            mq[i] = scanner.nextInt();
            nums[i] = scanner.nextLong();
        }

        System.out.println(minSum(num,nums));


    }


    //贪心
    public static long minSum(int n ,long[] nums) {
        if(n == 1)
            return 0;
        if(n == 2 && nums[0] == nums[1])
            return 1;
        if(n == 2 && nums[0] != nums[1])
            return 0;

        long[] temp = Arrays.copyOf(nums, n);

        int i = 0;
        while(i < n-1 && nums[i] < nums[i+1])
            i++;
        int j = n-1;
        while(j > 0 && nums[j] < nums[j-1])
            j--;

        while(i < j) {
            if(nums[i] < nums[j]) {
                if(nums[i+1] < nums[i]+1)
                    nums[i+1] = nums[i] + 1;
                i++;
            } else {
                if(nums[j-1] < nums[j]+1)
                    nums[j-1] = nums[j] + 1;
                j--;
            }
        }
        return Arrays.stream(nums).sum() - Arrays.stream(temp).sum();
    }

}
