package 剑指offer编程题;


/*
*输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
* 假设压入栈的所有数字均不相等。
* 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
* 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
*
* */


import java.util.List;
import java.util.Stack;

public class 栈的压入_弹出队列 {

    /*
    * 新建栈，将pushA按顺序压入栈，每压入一个，栈顶元素与popA元素进行比较，若相同则把栈顶元素弹出，
    * 再将栈顶元素与popA的后一位进行比较；知道栈为空；
    * 若最后栈不为空，则popA不是pushA的一种弹出顺序
    *
    * */

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null){
            return false;
        }

        int a = pushA.length;

        Stack<Integer> stack = new Stack<>();


        int popIndex = 0;
        for (int i = 0; i < a; i++) {
            stack.push(pushA[i]);

            while(!stack.isEmpty() && popA[popIndex] == stack.peek()){//需要先判断栈是否为空，否则后面的popIndex则会越界
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};

        IsPopOrder(pushA,popA);

    }

}
