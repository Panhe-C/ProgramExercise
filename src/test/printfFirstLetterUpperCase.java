package test;

import java.util.Scanner;

public class printfFirstLetterUpperCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().trim().toUpperCase().split(" ");
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i].charAt(0));
        }
    }
}
