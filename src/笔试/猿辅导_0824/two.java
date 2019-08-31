package 笔试.猿辅导_0824;

/*
* 提供角色，每三个不同的角色可以组成一个小组；
* 现有多个角色，每个角色有一定人数，问最多能组成多少小组
*
* 输入：
*   第一行：测试用例数量c，接下来的c行为每行为一个测试用例
*   每个测试用例，第一行表示可选择的角色数T，接下来的T个数字表示每个角色的选择人数Pi（Pi<=500）
*输出：
*   最大的小组数
*
输入：
3
3 1 1 1
3 2 2 3
4 0 2 3 99
输出:
1
2
2
    *
*
* */
import java.util.Arrays;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        int caseNum = 0;
        while (caseNum < cases){

            int roles = scanner.nextInt();
            int[] choseNum = new int[roles];
            for (int i = 0; i < roles; i++) {
                choseNum[i] = scanner.nextInt();
            }

            if (roles==3){
                int min = Arrays.stream(choseNum).min().getAsInt();
                System.out.println(min);
            }
            else {

                int groups = 0;

                while (choseNum[roles-4] == 0){
                    Arrays.sort(choseNum);
                    groups+=choseNum[roles-3];
                    choseNum[roles-1] -= groups;
                    choseNum[roles-2] -= groups;
                    choseNum[roles-3] -= 0;
                }
                System.out.println(groups);
            }
            caseNum++;
        }
    }
}
