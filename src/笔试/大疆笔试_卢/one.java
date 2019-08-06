package 笔试.大疆笔试_卢;

import java.util.Arrays;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int a = sc.nextInt();
            int x = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++)
                A[i] = sc.nextInt();

            sool(A, a, x);
        }
    }

    public static void sool(int[] A, int a, int x) {
        //A:每个bug的时间；a：倍数；x：coffe
        Arrays.sort(A);
        double count = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            //加速干完活
            double tmp = Math.ceil(A[i] / (double) a);
            if (count + tmp <= 60 * x)
                count += tmp;
                //完全不加速
            else if (count >= 60 * x) {
                count += A[i];
                //加速干完活得一部分
            } else
                count = A[i] - a * (60 * x - count) + 60 * x;
        }
        System.out.printf("%d\n", count);
    }
}
