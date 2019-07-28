package 拼多多笔试;

import java.util.Scanner;

public class two {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] c = s.split("\\s");

        char[] last = new char[c.length];
        char[] first = new char[c.length];

        for (int i = 0; i < c.length; i++) {
            char lastChar = c[i].charAt(c[i].length()-1);
            last[i]=lastChar;

            char firstChar = c[i].charAt(0);
            first[i]=firstChar;
        }

        int num = 0;

        for (int j = 0; j < c.length; j++) {
            if(j < c.length-1){
                if(last[j] == first[j+1]){
                    num++;
                };
            }else if (j == c.length-1){
                if(last[j] == first[0]){
                    num++;
                }
            }
        }
        if(num == c.length){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

}
