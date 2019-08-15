package test;

import org.junit.Test;

import java.util.Scanner;

public class 输入字符长度 {
    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);

            String s = scanner.nextLine().trim();

            int spaceCount = 0;
            for (int i = 0; i < s.length();i++) {
                if(s.charAt(i) == ' '){
                    spaceCount++;
                }
            }

            System.out.println(s.length()-spaceCount);
        }
    }

}
