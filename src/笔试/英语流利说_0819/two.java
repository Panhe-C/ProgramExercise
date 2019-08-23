package 笔试.英语流利说_0819;

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();

            if (num == 1 || num == 2) {
                System.out.println(num);
            }

            int s1 = 1;
            int s2 = 2;
            int s3 = 1;
            for (int i = 3; i <= num; i++) {
                s3 = s1 + s2;
                s1 = s2;
                s2 = s3;
            }

            System.out.println(s3);
        }


    }
}
