package 笔试.贝壳笔试_08_10;

import java.util.Arrays;
import java.util.Scanner;


/*
*举重比赛，要求比赛双方体重较小的要大于等于较大值的90%。那么N个人最多能进行多少场比赛。任意两人之间最多进行一场比赛
*
* 输入：
*   第一行，参赛人数
*   第二行，体重
* 输出：
*   最多进行的比赛场次
*
* 输入：
*   5
*   1 1 1 1 1
* 输出：
*   10
*
* */

public class three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int persons = scanner.nextInt();
        int[] weight = new int[persons];
        for (int i = 0; i < persons; i++) {
            weight[i] = scanner.nextInt();
        }

        int count = 0;

        for (int i = 0; i < persons; i++) {
            for (int j = i+1; j < persons; j++) {
                if(weight[i] > weight[j]){
                    if(weight[j] >= 0.9 * weight[i]){
                        count++;
                    }
                }else {
                    if(weight[i] >= 0.9 * weight[j]){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);

        System.out.println("复杂度更小：" + simpler(weight));

    }


    /*
    * 时间复杂度更小
    *
    * */
    public static int simpler(int[] A){
        Arrays.sort(A);

        int n = A.length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            for (; j < n; j++) {
                if (A[i] < 0.9 * A[j])
                    break;
            }
            count += j - i - 1;
        }
        return count;
    }
}
