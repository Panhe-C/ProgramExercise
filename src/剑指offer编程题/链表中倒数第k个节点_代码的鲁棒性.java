package 剑指offer编程题;


/*
*
* 输入一个链表，输出该链表中倒数第k个结点。
* */

import java.awt.*;

public class 链表中倒数第k个节点_代码的鲁棒性 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /*
    * 解题思路：
    * 两个节点指向头节点
    * 一个节点向后走k个节点
    * 然后两个节点一起走到链表的尾结点，那么第二个节点就指向了倒数第k个节点
    * */
    public static ListNode FindKthToTail(ListNode head,int k) {

        ListNode p1 = head;
        ListNode p2 = head;

        if (head == null || k < 1) {
            return null;
        }


//        for (int i = 0; i < k; i++) {  //要从1开始
        for (int i = 1; i < k; i++) {

            if(p1.next != null){
                p1 = p1.next;
            }else{return null;}

        }
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args) {

    }

}
