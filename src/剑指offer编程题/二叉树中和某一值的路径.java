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

    /*
    *从根节点使用递归下溯各个子节点
    *
    * 思路：
    *      用一个ArrayList装路径，遍历一个子节点加上和并装入list，如果遍历到叶结点则判断路径和与目标是否相等。
    *       若相等，则保存路径；若不等则去掉list最后装近的数，即该路径的页结点，即回退，遍历父节点的右结点；
    *       最终将得到路径和与目标相等的路径；
    *
    *
    *  */

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
        if(root.left==null && root.right==null){
            if(target==sum){
                path.add(root.val);
                paths.add(new ArrayList<>(path));
                path.remove(path.size()-1);
            }
            return;
        }
        path.add(root.val);
        find(paths,path,root.left,target,sum);
        find(paths,path,root.right,target,sum);
        path.remove(path.size()-1);//若改路径之和不符合则回退
    }



    /*更简单*/

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPathSimpler(TreeNode root, int target){

        if(root == null){return new ArrayList<>(0);}

        target -= root.val;

        list.add(root.val);
        if(target == 0 && root.right == null && root.left == null){
            listAll.add(new ArrayList<>(list));
        }

        FindPathSimpler(root.left,target);
        FindPathSimpler(root.right,target);
        list.remove(list.size()-1);

        return listAll;
    }


}
