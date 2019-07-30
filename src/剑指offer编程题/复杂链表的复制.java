package 剑指offer编程题;


/*
*输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
* 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
* （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*

*
* * */

import javax.swing.tree.TreeNode;
import java.util.TreeSet;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}



public class 复杂链表的复制 {
    public RandomListNode Clone(RandomListNode pHead)
    {

        TreeSet

        if(pHead == null){
            return null;
        }



        //1.在旧链表中创建新链表，此时不处理新链表的兄弟结点

        RandomListNode currentNode = pHead;


        /*关键在于循环里面的循环往前遍历，什么时候新建变量存储，什么时候循环不会陷入死循环*/
        while (currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;

            currentNode.next = cloneNode;
            cloneNode.next = nextNode;

            currentNode = nextNode;
        }


        //2.根据旧链表的兄弟结点，初始化新链表的兄弟结点
        currentNode = pHead;
        while (currentNode != null){
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }
        //3.从旧链表中拆分得到新链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null){
            RandomListNode pClone = currentNode.next;

            currentNode.next = pClone.next;

            pClone.next = pClone.next == null ? null : currentNode.next.next;

            currentNode = currentNode.next;
        }

        return pCloneHead;






        RandomListNode randomListNode = new RandomListNode(pHead.label);
        RandomListNode newHead = new RandomListNode(pHead.label);
        newHead.next = pHead.next;
        newHead.random = pHead.random;

        while(pHead.next != null){
            randomListNode.next = pHead.next;
            pHead = pHead.next;
            randomListNode = randomListNode.next;
        }


        randomListNode.random = pHead.random;
        while(pHead.next != null){
            pHead = pHead.next;
            randomListNode = randomListNode.next;
            randomListNode.random = pHead.random;
        }
        return newHead;
    }
}
