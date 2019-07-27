package 剑指offer编程题;


import java.util.ArrayList;

/*
* 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
* */
public class 从上往下打印二叉树 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();

        if(root == null){
            return list;
        }

        queue.add(root);

//        while(queue != null){
        while(queue.size() != 0){
            TreeNode remove = queue.remove(0);
            list.add(remove.val);
            if(remove.left!=null){
                queue.add(remove.left);
            }
            if(remove.right!=null){
                queue.add(remove.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(null);
        queue.remove(0);
        System.out.println(queue.remove(0).val);
    }
}
