package 算法经典问题.链表相关;

/*
*
*题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
*  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
* */

public class 删除链表中的重复的节点 {

    /*
思路：
注意，题目说了，这是排序的链表。如果没排序，就另当别论了。
创建一个头结点和尾指针。关键是用到尾指针。遍历链表，当找到节点值相等的两个节点，设其节点值为x，然后通过循环将节点值为x的移除。怎么移除？借助尾指针，通过操控尾指针来剔除那些重复的节点。
要注意的是，这个尾指针并不是相对于旧链表而言，而是相对于无重复节点的链表而已。
 ————————————————
版权声明：本文为CSDN博主「LLLLLLLLEE」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_30531261/article/details/79199167
    * */
    public ListNode deleteDuplication(ListNode pHead){
        ListNode preNode = new ListNode(0);
        preNode.next = pHead;

        ListNode last = preNode;
        ListNode p = pHead;

        while (p != null && p.next !=null){
            if(p.val == p.next.val){
                int val = p.val;
                while (p !=null && p.val == val){//剔除重复节点
                    p = p.next;
                    last.next = p;//剔除
                }
            }else {//不重复则无需剔除，直接移动尾指针
                last = p;
                p = p.next;
            }
        }
        return preNode.next;
    }
}
