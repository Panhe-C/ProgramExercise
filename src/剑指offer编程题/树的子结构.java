package 剑指offer编程题;



/*
*
* 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
* */
public class 树的子结构 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        //若由一个为空则不可能为子结构
        if(root1 == null || root2 == null){
            return false;
        }

        Boolean result = false;

        //因为题目问的是B是否为A的子结构， 所以这里如果B的根节点等于A的根节点，则往下遍历
        if(root1.val == root2.val){
            result = isSubTree(root1,root2);
        }

        if(!result){
            //若A的根节点不等于B的根节点，则用A的左或右子树去与B的根节点开始比较
            result = HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }

        return result;

}

    private Boolean isSubTree(TreeNode root1, TreeNode root2) {

        //没有else，按顺序来验证if中的条件

        //如果递归遍历后，B先为空，则B为A 的子结构
        if(root2 == null){
            return true;
        }
        if(root1 == null){//若A先遍历完，则B不是A的子结构
            return false;
        }
        if(root1.val == root2.val){
            //对比B与A的左/右子树的值
            return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
        }
        return false;

    }


}
