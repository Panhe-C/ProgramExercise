package 算法经典问题.链表相关;


import java.util.ArrayList;
import java.util.Stack;

public class 从头到尾打印链表 {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        ListNode p = listNode;
        while (p != null){
            stack.push(p.val);
            p = p.next;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
}
