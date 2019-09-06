package 笔试.小红书笔试_0903;



/*
*
a<<b((c)<)
*
* 输出b
* */
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();


        int i = 0;
        int index = 0;
        int count1 = 0;
        int count2 = 0;
        while (i < s.length()){
            if(s.charAt(i) == '('){
                count1++;
                if(count1==1) index = i;
            }
            else if(s.charAt(i) == ')'){
                count2++;
                if(count2 == count1){
                    s = s.substring(0,index).concat(s.substring(i+1,s.length()));
                    count1 = 0;
                    count2 = 0;
                    i = index;
                }
            }
            i++;
        }



        while(s.contains('<' +"")) {
            s = rel(s);
        }
        System.out.println(s);
    }


    public static String rel(String str){
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '<') {
                if(i == 0)
                    str = str.replace(str.substring(i, i + 1), "");
                else
                    str = str.replace(str.substring(i - 1, i + 1), "");
            }
        }
        return str;
    }
}
