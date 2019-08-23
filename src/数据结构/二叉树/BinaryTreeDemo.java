package 数据结构.二叉树;

import sun.reflect.generics.tree.Tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树

        BinaryTree binaryTree = new BinaryTree();

        //创建节点
        TreeNode root = new TreeNode(1,"宋江");
        TreeNode node2 = new TreeNode(2,"吴用");
        TreeNode node3 = new TreeNode(3,"卢俊义");
        TreeNode node4 = new TreeNode(4,"林冲");
        TreeNode node5 = new TreeNode(5,"关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        //测试
        System.out.println("前序遍历");//1，2，3，4
        binaryTree.preOrder();

        System.out.println("中序遍历");//2,1,3,4
        binaryTree.infixOrder();

        System.out.println("后序遍历");//4,2,3,1
        binaryTree.postOrder();

    }
}



//定义二叉树
class BinaryTree{
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //前序
    public void preOrder(){
        if(this.root != null){
            this.root.preOrder();
        }else System.out.println("二叉树为空");
    }

    //中序
    public void infixOrder(){
        if(this.root != null){
            this.root.infixOrder();
        }else System.out.println("二叉树为空");
    }
    //后序
    public void postOrder(){
        if(this.root != null){
            this.root.postOrder();
        }else System.out.println("二叉树为空");
    }
}

class TreeNode{
    private int no;
    private String name;
    private TreeNode left;//默认为null
    private TreeNode right;//默认为null

    public TreeNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }



    //前序遍历:根->左->右
    public void preOrder(){
        System.out.println(this);//输出当前父节点

        //递归向左子树前序遍历
        if(this.left != null){
            this.left.preOrder();
        }

        //递归向右子树前序遍历
        if(this.right != null){
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if(this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if(this.left != null) {
            this.left.postOrder();
        }

        if(this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);
    }


    //前序遍历查找
    public TreeNode preOrderSearch(int no){
        //比较当前节点
        if(this.no == no){
            return this;
        }

        //1.判断当前节点的左子节点是否为空，不为空则递归前序查找
        //2.如果左递归前序查找，找到节点则返回
        TreeNode resNode = null;
        if(this.left != null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }

        if(this.right != null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;

    }


    //中序遍历查找
    public TreeNode infixOrderSearch(int no){


        //1.判断当前节点的左子节点是否为空，不为空则递归前序查找
        //2.如果左递归前序查找，找到节点则返回
        TreeNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }

        System.out.println("进入中序查找");
        //如果找到则返回，若没有找到，就和当前节点比较，是则返回当前节点
        if(this.no == no){
            return this;
        }

        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;

    }

    //后序遍历查找
    public TreeNode postOrderSearch(int no){


        //1.判断当前节点的左子节点是否为空，不为空则递归前序查找
        //2.如果左递归前序查找，找到节点则返回
        TreeNode resNode = null;
        if(this.left != null){
            resNode = this.left.infixOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }



        if(this.right != null){
            resNode = this.right.infixOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }

        System.out.println("进入后序查找");
        //如果左右子树都没有找到，就比较当前节点
        if(this.no == no){
            return this;
        }

        return resNode;
    }


}
