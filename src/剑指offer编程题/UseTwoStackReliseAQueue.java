package 剑指offer编程题;

import java.util.Stack;


/*
* 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
*
* 解题思路：
用一个栈按栈的方式存数据，用另一个栈来按照队列的规则顺序来取数据。
* 实现的就是：比如把1，2按顺序存入栈1，此时栈2为空；取数据时，将栈1的数据全部按照后进先出弹出2、1，
* 然后存入栈2，再从栈2中按照后进先出的顺序取数据为先取出1，后取出2。即最终顺序为：1->2存入；1->2取出，先进先出。
* */

//队列：先进先出
//插入数据只能在队尾，删除数据只能在队头

public class UseTwoStackReliseAQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(int node){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<Integer>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        System.out.println(stack1.pop());
        System.out.println(stack1);
    }
}
