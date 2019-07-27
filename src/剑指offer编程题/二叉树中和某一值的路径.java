package 剑指offer编程题;


/*
* 输入一颗二叉树的根节点和一个整数，
* 打印出二叉树中结点值的和为输入整数的所有路径。
* 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
* */

import java.util.ArrayList;

public class 二叉树中和某一值的路径 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
            if(root==null){return paths;}

            ArrayList<Integer> path = new ArrayList<>();

            find(paths,path,root,target,0);

            return paths;
    }

    private void find(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode root, int target, int sum) {
        if(root==null){return;}

        sum+=root.val;
        if(root.right==null && root.right==null){
            if(target==sum){
                path.add(root.val);
                paths.add(path);
                path.remove(path.size()-1);
            }
            return;
        }

        path.add(root.val);
        find(paths,path,root.left,target,sum);
        find(paths,path,root.right,target,sum);

    }


}
