package test;

import org.junit.Test;

import java.util.Scanner;

/*
* 一个字符串的连续子串如abc，输出a,ab,b,bc,c
*
* */

public class 输出字串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String subStirng = new String();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                subStirng = s.substring(i,j);
                if(subStirng != s){
                System.out.println(subStirng);}
            }


        }

    }

    @Test
    public void tets(){
        String s = "abc";

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }
        System.out.println(s.substring(0,1));
        System.out.println(s.substring(1,2));
        System.out.println(s.substring(2,3));
    }
}
