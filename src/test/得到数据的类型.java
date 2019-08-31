package test;

import java.util.Scanner;

public class 得到数据的类型 {

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        Object obj = s.next();//返回的都是String



        Object obj = 1.1;
        System.out.println(obj.getClass().getName());
    }
}
