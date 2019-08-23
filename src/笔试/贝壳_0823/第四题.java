package 笔试.贝壳_0823;


/*
* 物品分堆：
*   有N个物品，第i个物品重量是Wi；要将物品分成两堆，使得在“第一堆物品的总重量与第二堆物品总重量之差尽可能小”的前提下，第一堆物品数量与第二堆物品数量之差尽可能大；
*   那么，两队物品的总重量之差最小是多少？总重量之差最小的前提下，两堆物品的数量之差最大是多少？
*
* 输入：
*   第一行：一个整数N
*   第二行：包含n个空格隔开的整数W1-Wn（1≤Wi≤100）
* 输出：
*   总重量之差的最小值 差最小的前提下总数量之差的最大值
*
*
*
输入:
6
1 2 3 4 5 6

输出：
1 2
* */


/*
* 作者：Bless。
链接：https://www.nowcoder.com/discuss/231937?type=post&order=create&pos=&page=1
来源：牛客网

两个问题 ， x+y=sum  |x-y|=MaxWeight   sum-y-y=MinWeight   sum-2y=MinWeight  只要y尽量靠近 sum的一半，重量差就会越小
变成 数组中找出和为y的子序列 ，典型的背包问题 dp[i] 表示和为i的最小数量
* */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 第四题 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //获取到输入的总人数
        int sum = scanner.nextInt();
        //存放所有人的体重
        ArrayList<Integer> list = new ArrayList<>();
        //获取体重
        for (int i = 0; i < sum; i++) {
            list.add(scanner.nextInt());
        }
        int count = list.size() / 2;//队伍的人数(第一队)
        sum = 0;
        //体重全部相加之后, 求其平均值
        for (Integer integer : list) {
            sum += integer;
        }
        int average = sum / 2;
        //新建第一队列表
        ArrayList<Integer> first = new ArrayList<>();
        //获取到 count个人与平均值的最小值
        int func = func(list, count, average, first);
        System.out.println(func);
        System.out.println(first);
        list.removeAll(first);
        System.out.println(list);

    }

    public static int func(List<Integer> list, int count, int sum, List<Integer> first) {
        //当第一队的人数为count时, 结束递归
        if (first.size() == count) {
            int firstSum = 0;
            for (Integer integer : first) {
                firstSum += integer;
            }
            return Math.abs(firstSum - sum);
        } else {

            int min = Integer.MAX_VALUE;
            List<Integer> minFirst = null;

            for (int i = 0; i < list.size(); i++) {
                ArrayList<Integer> listTemp = new ArrayList<>(list);
                ArrayList<Integer> firstTemp = new ArrayList<>(first);
                firstTemp.add(listTemp.remove(i));
                int func = func(listTemp, count, sum, firstTemp);
                if (func < min) {
                    min = func;
                    minFirst = firstTemp;
                }
                if(min == 0) {
                    break;
                }
            }

            first.clear();
            first.addAll(minFirst);
            return min;
        }
    }
}
// ————————————————
//         版权声明：本文为CSDN博主「张鹿鹿」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
//         原文链接：https://blog.csdn.net/u013144863/article/details/52214762

