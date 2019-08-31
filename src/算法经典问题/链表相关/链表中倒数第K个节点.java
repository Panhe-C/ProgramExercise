package 算法经典问题.链表相关;

/*
*
题目描述
输入一个链表，输出该链表中倒数第k个结点。
* */

public class 链表中倒数第K个节点 {

    /*
思路：
看到倒数，也就是反序，就想到了栈。但是栈会耗费额外的空间内存。实现略。

思路2：
遍历一遍，得到链表个数。第二次遍历，就知道倒数第K个时哪个了。但需要遍历两遍。实现略。

思路3：
使用两个指针ab，a指针先走K步，然后ab两个指针同时前进，当a指针到达尾部时，b指针所指向的节点正是倒数第K个节点。因为a指针先走了k步，所以ab节点差了k个位置啊。这样只需要遍历一次，且没有额外空间开销。
 ————————————————
版权声明：本文为CSDN博主「LLLLLLLLEE」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_30531261/article/details/79199167
    * */


    public ListNode FindKthToTail(ListNode head,int k){
        if(head == null) return null;

        ListNode p1 = head;
        ListNode p2 = head;

        int i = 1;//用i记录实际先走了多少步

        while (i < k && p1.next!= null){
            p1 = p1.next;
            i++;
        }
        if(i!=k)//i!=k说明i<k,说明k比链表长度还长
            return null;

        while (p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


    public ListNode FindKthToTailSimpler(ListNode head,int k) {
        ListNode p,q;
        p = head;
        q = head;
        int i=0;
        for(;p!=null;i++){
            if(i>=k)
                q = q.next;
            p = p.next;
        }
        return i<k ? null : q;
    }
}
