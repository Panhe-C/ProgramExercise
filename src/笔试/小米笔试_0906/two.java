package 笔试.小米笔试_0906;


/*
* 1(2(3,4(,5)),6(7,))
*
* 输出中序遍历：3245176
* */
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class two {


//=========================================================================
    /*
    用了一个栈 遍历字符串 不同情况不同处理
    */
    static String solution(String input) {
        if(input==null||input.length()<2){
            return input;
        }
        Stack<Character> number=new Stack<Character>();
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(c>='0'&&c<='9'){
                char c1=input.charAt(i+1);
                if(c1==','){
                    builder.append(c);
                    builder.append(number.pop());
                    i++;
                    continue;
                }
                number.push(c);
            }
            if(c=='('){
                char c1=input.charAt(i+1);
                if(c1==','){
                    builder.append(number.pop());
                    i++;
                }
            }
            if(c==')'){
                builder.append(number.isEmpty()?"":number.pop());
            }
        }
        return builder.toString();
    }

        //递归实现================================================================================================================
        public static String getLeft(String s) {
        if(s.charAt(2) == ',')
            return null;
        if(s.charAt(3) == ',')
            return s.substring(2, 3);
        Stack<Character> stack = new Stack<Character>();
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')') {
                stack.pop();
                if(stack.isEmpty()) {
                    return s.substring(2, i+1);
                }
            }
        }
        return s.substring(2, s.indexOf(','));
    }

    public static String getRight(String s) {
        if(s.charAt(2) == ',')
            return s.substring(s.indexOf(',') + 1, s.length() - 1);
        if(s.charAt(3) == ',')
            return s.substring(s.indexOf(',') + 1, s.length() - 1);
        Stack<Character> stack = new Stack<Character>();
        for (int i = 2; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(c == ')') {
                stack.pop();
                if(stack.isEmpty()) {
                    return s.substring(i + 2, s.length() - 1);
                }
            }
        }
        return s.substring(s.indexOf(',') + 1, s.length() - 1);
    }

    public static void Travese(String s) {
        if(s == null || s.equals("")) return;

        if(s.length() == 1) {
            System.out.print(s.charAt(0));
            return;
        }
        String left = getLeft(s);
        Travese(left);
        System.out.print(s.charAt(0));
        String right = getRight(s);
        Travese(right);
    }
    //======================================================================================================================
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }

        Travese(_input);

        System.out.println();
        res = solution(_input);
        System.out.println(res);
    }
}
