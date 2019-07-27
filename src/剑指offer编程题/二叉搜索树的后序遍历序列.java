package 剑指offer编程题;


/*
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*
* 二叉查找树，也称为二叉搜索树、有序二叉树或排序二叉树，是指一棵空树或者具有下列性质的二叉树：
* 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
*  若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
* 任意节点的左、右子树也分别为二叉查找树； 没有键值相等的节点。
* */

public class 二叉搜索树的后序遍历序列 {




    /*
    * 解题思路：根据二叉搜索树和题目的定义，知：左子树所有值都小于根，右子树所有值都大于根
    * 为后序遍历知最后一个数为整个树的根；
    * 所以：从前往后数，第一个大于根的数的左边为左子树，右边包括该元素则为右子树；
    * 然后对找到的右子树（因为没有大小遍历）进行循环，如有小于根的数则返回false；
    * 若均大于根，则分别在左右子树递归判断
    *
    * */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){return false;}
        if(sequence.length == 1){return true;}

        return judgeBST(sequence,0,sequence.length-1);
    }

    private boolean judgeBST(int[] sequence, int start, int root) {
//        if(root == start){return true;}
        if(root <= start){return true;}


        int index = start;
        //找到左右子树的分界线
        while(sequence[index]<sequence[root] && index<=root){
            index++;
        }


        //判断右子树是否有小于根节点的数，若有则返回false
        for (int i = index; i < root; i++) {
            if(sequence[i] < sequence[root]){
                return false;
            }
        }

        //若左右子树均符合规则，则递归循环判断左右子树
        return judgeBST(sequence,start,index-1) && judgeBST(sequence,index,root-1);
    }
}
