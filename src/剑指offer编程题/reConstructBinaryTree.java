package 剑指offer编程题;

import javax.swing.tree.TreeNode;


public class reConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre,in);
    }

        public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {




            if(pre==null||in==null){
                return null;
            }

            java.util.HashMap<Integer,Integer> map= new java.util.HashMap<Integer, Integer>();
            for(int i=0;i<in.length;i++){
                map.put(in[i],i);
            }
            return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
        }

        public static TreeNode preIn(int[] p,int pi,int pj,int[] n,int ni,int nj,java.util.HashMap<Integer,Integer> map) {

            if (pi > pj) {
                return null;
            }
            TreeNode head = new TreeNode(p[pi]);
            int index = map.get(p[pi]);
            head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
            head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
            return head;
        }




    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
