package 笔试.网易2018编程笔试;

import org.junit.Test;

import java.util.Scanner;

public class three {

    static int sum = 0;
    static int times = 0;
    static int sumsum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int length = s.length();

        if(length==1){
            System.out.println(1.00);
        }


        compare(length,0,s,0);
        float result = (float)sumsum/(float)times;
        System.out.printf("%.2f",result);




    }

    public static void compare(int length,int index,String s,int sum){
        if(index>length-1){return;}
        int count = 0;
        times++;
        int newIndex = 0;
        for (int i = index; i < length; i++) {
            count++;
            if(i == length-1){
                sum+=count;
                sumsum = sum;
                return;}
            else if(s.charAt(i) != s.charAt(i+1)){
                sum+=count;
                newIndex = i;
                compare(length,newIndex+1,s,sum);
                return;
            }
        }
    }




    class simple{

        /*
         * 要先仔细读题!!!
         *
         * 结果=字符串长度/（重复的字段数）
         * */

        @Test
        public void simpler(){
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();

            int count=1;
            for (int i = 0; i < s.length() - 1; i++) {
                if(s.charAt(i)!=s.charAt(i+1) ){
                    count++;
                }
            }

            System.out.printf("%.2f",s.length()/count);
        }

    }



}


