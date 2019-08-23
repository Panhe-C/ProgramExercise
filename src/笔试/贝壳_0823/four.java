package 笔试.贝壳_0823;


/*
*
6
1 2 3 4 5 6
*
* 输出
* 1 2
* */

import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int[] result = cal(weights);
        System.out.print(result[0] + " ");
        System.out.print(result[1]);


    }

    public static int[] cal(int[] weights){

        int[] result = new int[2];

        int one = 0;
        int two = 0;

        int oneNum =1;
        int twoNum = 0;

        int index = 1;
        one+=weights[0];
        for (int i = 1; i < weights.length; i++) {
            int oneIf = one;
            int twoIf = two;

            int diff1 = Math.abs(oneIf - (twoIf+=weights[i]));
            int diff2 = Math.abs((oneIf+=weights[i]) - twoIf);

            if(diff1 <= diff2){
                twoNum++;
                two+=weights[i];
            }else {
                oneNum++;
                one+=weights[i];
            }
        }

        result[0] = Math.abs(one-two);
        result[1] = Math.abs(oneNum-twoNum);

        return result;
    }
}
