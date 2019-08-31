package 算法经典问题.链表相关;


/*
* 题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
* 要求不能创建任何新的结点，只能调整树中结点指针的指向。
*
* */
public class 二叉搜索树变双向链表 {

    /*
思路：
通过中序遍历实现，关键是要创建一个成员引用pre。用来表示上一个刚被访问过的节点，也可看做是新链表的尾指针。
通过在遍历中设置pre.right=current,current.left=pre,pre=current，即可将二叉树转变成双向链表。


    * */
    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree){
        TreeNode p = pRootOfTree;
        if(p == null) return p;

        middleTraverse(p);
        //通过向左遍历找到链表的首节点
        while (p.left != null)
            p = p.left;

        return p;
    }

    private void middleTraverse(TreeNode cur) {
        if(cur == null) return;

        middleTraverse(cur.left);

        //关键。重新调整节点的指针
        if(pre != null)
            pre.right = cur;
        cur.left = pre;
        pre = cur;

        middleTraverse(cur.right);
    }

}
