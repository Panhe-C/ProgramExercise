package 算法经典问题;


/*
* BFS广度优先搜索
* */

import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.GraphImpl;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap<>();

        graph.put("A", new String[]{"B", "C"});
        graph.put("B", new String[]{"A", "C", "D"});
        graph.put("C", new String[]{"A", "B", "D", "E"});
        graph.put("D", new String[]{"B", "C", "E", "F"});
        graph.put("E", new String[]{"C", "D"});
        graph.put("F", new String[]{"D"});


//        BFirstSearch(graph, "A");
//        DepthFirstSearch(graph, "A");
        Map<String,String> path = path(graph, "E");

        String node = "B";
        //计算从节点"B"到输入的起始节点"E"的路径
        while(path.get(node) != null){
            System.out.println(node);//B->C->E
            node = path.get(node);
        }

//

    }


    public static void BFirstSearch(HashMap<String, String[]> graph, String startNode) {
        System.out.println("广度优先遍历：");

        Queue<String> queue = new LinkedList<>();
        queue.offer(startNode);//尽量用offer代替add

        List<String> list = new ArrayList<>();//存储已经被搜寻过的节点
        list.add(startNode);

        while (queue.peek() != null) {//队列不为空
            String vertax = queue.poll();//取出队列头元素，即最先放进去的元素
            String[] nodes = graph.get(vertax);//找到该节点的邻节点
            if (nodes.length != 0) {
                for (int i = 0; i < nodes.length; i++) {
                    if (!list.contains(nodes[i])) {//如果当前节点还没有被搜寻过了
                        queue.offer(nodes[i]);//将邻节点放入队列中
                        list.add(nodes[i]);//同时将已在队列中的节点存储
                    }
                }
            }

            System.out.println(vertax);
        }
    }


    public static void DepthFirstSearch(HashMap<String, String[]> graph, String startNode) {

        System.out.println("深度优先遍历：");

        Stack<String> stack = new Stack<>();
        stack.push(startNode);

        List<String> seen = new ArrayList<>();
        seen.add(startNode);

        while (!stack.empty()) {
            String vertax = stack.pop();
            String[] nodes = graph.get(vertax);//找到该节点的邻节点
            if (nodes.length != 0) {
                for (int i = 0; i < nodes.length; i++) {
                    if (!seen.contains(nodes[i])) {//如果当前节点还没有被添加过
                        stack.push(nodes[i]);//将邻节点放入栈中
                        seen.add(nodes[i]);//同时将已在栈中的节点存储作为已经搜寻过的标记
                    }
                }
            }

            System.out.println(vertax);
        }
    }


    public static Map<String,String> path(HashMap<String, String[]> graph, String startNode) {
        System.out.println("搜索最短路径：");

        Queue<String> queue = new LinkedList<>();
        queue.offer(startNode);

        Map<String,String> parent = new HashMap<>();//用来存储路径中某一个节点的上一个节点
        parent.put(startNode,null);

        List<String> list = new ArrayList<>();
        list.add(startNode);

        while (queue.peek() != null) {//队列不为空
            String vertax = queue.poll();//取出队列头元素，即最先放进去的元素
            String[] nodes = graph.get(vertax);//找到该节点的邻节点
            if (nodes.length != 0) {
                for (int i = 0; i < nodes.length; i++) {
                    if (!list.contains(nodes[i])) {//如果当前节点还没有被搜寻过了

                        parent.put(nodes[i],vertax);

                        queue.offer(nodes[i]);//将邻节点放入队列中
                        list.add(nodes[i]);//同时将已在队列中的节点存储
                    }
                }
            }

//            System.out.println(vertax);
        }

        return parent;
//        System.out.println();
//        for (Map.Entry<String, String> s : parent.entrySet()) {
//            System.out.println(s);
//        }
    }
}


