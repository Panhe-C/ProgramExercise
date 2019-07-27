package 剑指offer编程题;


/*
*
*定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
* */

import java.util.Iterator;
import java.util.Stack;

import java.util.ArrayList;
import java.util.List;

public class 包含min函数的栈 {

    /*
    * 使用了iterator迭代器
    * 迭代器（Iterator）模式，又叫做游标模式，它的含义是，（迭代器，提供一种访问一个集合对象各个元素的途径，同时又不需要暴露该对象的内部细节。）
    * 提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
    *
    * 迭代器主要的用法是：首先用hasNext（）作为循环条件，再用next（）方法得到每一个元素，最后在进行相关的操作。
    * */

    Stack<Integer> stack = new Stack<>();


    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = top();
        int temp = 0;

        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            temp = iterator.next();
            if(min > temp){
                min = temp;
            }
        }
        return min;
    }



    /*
    * 另建一个新栈存压入的数据，依次保存最小的数
    * */
    public class anotherMethod{

//        链接：https://www.nowcoder.com/questionTerminal/4c776177d2c04c2494f2555c9fcc1e49
//        来源：牛客网

        Stack<Integer> data = new Stack<Integer>();
        Stack<Integer> min = new Stack<Integer>();
        Integer temp = null;
        public void push(int node) {
            if(temp != null){
                if(node <= temp ){
                    temp = node;
                    min.push(node);
                }
                data.push(node);
            }else{
                temp = node;
                data.push(node);
                min.push(node);
            }
        }

        public void pop() {
            int num = data.pop();
            int num2 = min.pop();
            if(num != num2){
                min.push(num2);
            }
        }

        public int top() {
            int num = data.pop();
            data.push(num);
            return num;
        }

        public int min() {
            int num = min.pop();
            min.push(num);
            return num;
        }


    }

}
