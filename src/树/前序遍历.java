package 树;


import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//class Node{
//    public int value;
//    public Node left;
//    public Node right;
//    public Node(int v){
//        this.value=v;
//        this.left=null;
//        this.right=null;
//    }
//
//}

public class 前序遍历 {



    /*根->左->右*/
    public void preOrderStack(Node root){
        if(root == null){return;}


        Node p = root;
        Stack<Node> stack = new Stack<>();
        while(p!=null || !stack.isEmpty()){
            while (p!=null){
                //把左结点压入栈

                System.out.println(p.value);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();//回退
            p = p.right;//遍历右结点
        }
    }

    /*中序：-左->根->右*/
    public void inOrderStack1(Node root){
        if(root==null){return;}

        Node p = root;
        Stack<Node> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.println(root.value);
            root = root.right;
        }
    }

    /*后序遍历：左->右->根*/

    public void postOrder1(Node root){
        if(root==null){return;}

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Map<Node,Boolean> map = new HashMap<>();

        while(!stack.isEmpty()){

            Node temp=stack.peek();

            if(temp.left!=null && !map.containsKey(temp.left)){

                temp = temp.left;

                while (temp!=null){
                    if(map.containsKey(temp))break;
                    else stack.push(temp);
                    temp = temp.left;
                }
                continue;
            }


            if(temp.right!=null && !map.containsKey(temp.right)){
                stack.push(temp.right);
                continue;
            }

            Node temp1 = stack.pop();

            map.put(temp1,true);
            System.out.println(temp1.value);

        }



    }


}
