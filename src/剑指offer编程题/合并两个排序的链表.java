package 剑指offer编程题;




/*
* 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
*
*
* 
* */

public class 合并两个排序的链表 {


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){return list2;}
        if(list2 == null){return list1;}

        ListNode next1 = list1.next;
        ListNode next2 = list2.next;

        ListNode newList = null;

        if(list1.val < list2.val){
            newList = list1;
            list1 = next1;
            newList.next = Merge(list1,list2);
        }else {
            newList = list2;
            list2 = next2;
            newList.next = Merge(list1,list2);
        }

        return newList;

    }
}
