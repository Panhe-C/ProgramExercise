package 笔试.网易2020提前批笔试;


import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;


/*


* 输入：
*   3——班级人数
*   100 98 97——每个人分数
*   3——查询次数
*   1——查询第几个人：查询第一个人的百分比
*   2——查询第二个人的百分比
*   3
* 输出：
*   66.666667
*   33.333333
*   0.000000
*
* */

public class 第一题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //输入n个同学的成绩
        int n = sc.nextInt();
        int[] grade = new int[n];
        for(int i = 0; i < n; i++) {
            grade[i] = sc.nextInt();
        }

        int[] newGrade = Arrays.copyOf(grade, grade.length);

        //给n个同学分数排名
        Arrays.sort(newGrade);

        //计算q个同学的分数百分比
        int q = sc.nextInt();
        double[] sort = new double[q];
        int flag,num = 0;
        double count = 0;
        for(int i = 0; i < q; i++) {
            count = 0;
            flag = sc.nextInt();

            //获得当前同学分数排名
            for (int j : newGrade) {
                if(grade[flag - 1] >= j) {
                    count++;
                } else {
                    break;
                }
            }
            sort[num++] = (count - 1)/n * 100;
        }

        DecimalFormat format = new DecimalFormat("0.000000");

        for (double d : sort) {
            System.out.println(format.format(d));
        }

    }

}