//package 剑指offer编程题;
//
///*
//* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
//* 要求不能创建任何新的结点，只能调整树中结点指针的指向。
//* */
//
//import sun.reflect.generics.tree.Tree;
//
//import java.util.Stack;
//
//class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//
//    public TreeNode(int val) {
//        this.val = val;
//    }
//
//}
//
//public class 二叉搜索树与双向链表 {
//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if(pRootOfTree == null){return null;}
//
//
//        TreeNode currentNode = pRootOfTree;
//        Stack<TreeNode> stack = new Stack<>();
//
//        while (currentNode!=null || !stack.isEmpty()){
//
//            while (currentNode != null){
//                System.out.println(currentNode.val);
//                stack.push(currentNode);
//                currentNode = currentNode.left;
//            }
//
//            if(currentNode==null){
//                currentNode = currentNode.right;
//            }
//
//
//
//
//
//        }
//
//
//    }
//
//}
