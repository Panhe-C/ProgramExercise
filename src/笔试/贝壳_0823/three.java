package 笔试.贝壳_0823;


/*
*
4 100
3 40
3 6
1 1
1 5
* */

import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kinds = scanner.nextInt();
        int capcity = scanner.nextInt();

        int[] num = new int[kinds];
        int[] v = new int[kinds];
        for (int i = 0; i < kinds; i++) {
            num[i] = scanner.nextInt();
            v[i] = scanner.nextInt();
        }


//        int maxNum = caculMaxNums(num,v,kinds,capcity);


    }

//    private static int caculMaxNums(int[] num, int[] v, int kinds, int capcity) {
//
//
//
//
//    }
}
