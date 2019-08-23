package 笔试.贝壳_0823;


/*
*
3 4
aba
*
*
* ababababa
* */

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int times = scanner.nextInt();

        scanner.nextLine();

        String str = scanner.nextLine();



        int index = Integer.MAX_VALUE;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(0)){
                index = i;
            }
        }


        StringBuilder newStr = new StringBuilder();

        if(length==1){
            for (int i = 0; i < times; i++) {
                newStr.append(str);
            }
            System.out.println(newStr.toString());
            return;
        }

        String s = str;

        if(index < Integer.MAX_VALUE && s.split(str.substring(0,index)).length==0) {
            newStr.append(str.substring(0,index));
                String s1 = str.substring(index,length);
                for (int i = 0; i < times; i++) {
                    newStr.append(s1);
                }
        }else if(index==length-1){
            newStr.append(str.charAt(0));
            for (int i = 0; i < times; i++) {
                newStr.append(str.substring(1,length));
            }
        }
        else {
            for (int i = 0; i < times; i++) {
                System.out.print(str);
            }
        }

        System.out.println(newStr.toString());
    }
}
