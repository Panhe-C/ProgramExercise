package 笔试.携程笔试_0904;

/*
*
((ur)oi)
* */

import java.util.Scanner;
import java.util.Stack;

public class two_2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
        String str = "((ur)oi)";
//        StringBuilder stringBuilder = new StringBuilder(str);
//        char[] c = stringBuilder.reverse().toString().toCharArray();
//        for (int i = 0; i < c.length; i++) {
//            if(c[i] != '(' && c[i] != ')')
//                System.out.print(c[i]);
//        }
        System.out.println(reslove(str));

    }

    public static String reslove(String s){
        StringBuilder res = new StringBuilder();

        Stack<Character> stack = new Stack<>();
//        char[] c = str.toCharArray();


        int i = 0;
        int count1 = 0;
        int count2 = 0;
        Stack<Integer> stack1 = new Stack<>();
        while (i < s.length()){
            if(s.charAt(i) == '('){
                stack1.push(i);

            }
            else if(s.charAt(i) == ')'){
                int index = stack1.pop();
                s = s.replace(s.substring(index+1,i),repl(s.substring(index+1,i)));
            }
            i++;
        }

        return s;

//        int i = 0;
//        while( c[i] != ')'){
//            if(c[i] == '(') {
//                stack.push(c[i]);
//                while (c[i] != ')'){
//                    i++;
//                    stack.push(c[i]);
//                }
//            }
//        }

//        for (int i = 0; i < c.length; i++) {
//            if(c[i] == '(') {
//                stack.push(c[i]);
//                while (c[i] != ')') {
//                    i++;
//                    stack.push(c[i]);
//                }
//                while (stack.peek()!='(' && !stack.isEmpty()){
//                    res.append(str);
//                }
//            }
//        }


    }


    public static String repl(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }
}
