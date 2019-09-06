package 笔试.小红书笔试_0903;


/*
5
.#...
..#S.
.E###
.....
.....
*
*/

import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        char[][] mizz = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] c = scanner.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                mizz[i][j] = c[j];
            }
        }


        System.out.println(mizz);
    }
}
