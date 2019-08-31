package 笔试.字节跳动笔试_0825;

import org.omg.CORBA.INTERNAL;
/*
*
*
*
6
20 50 22 74 9 63

*
*
* */



import java.util.*;

public class four {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] candis = new int[n];

        for (int i = 0; i < n; i++) {
            candis[i] = s.nextInt();
        }


        Map<Integer,int[]> bridge = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if(maxCommon(candis[i],candis[j]) > 1){
                    list.add(candis[j]);
                }
            }
            if(list.size()!=0){
                int[] a= new int[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    a[j] = list.get(j);
                }
                bridge.put(candis[i],a);
            }
        }

        List<Integer> nums = new ArrayList<>();
        for(int teast : candis){
            nums.add(DepthFirstSearch(bridge,teast));
        }

        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            if(nums.get(i) > result){
                result = nums.get(i);
            }
        }
        System.out.println(result);



    }

    public static int DepthFirstSearch(Map<Integer, int[]> graph, int startNode) {
        int depth = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        List<Integer> seen = new ArrayList<>();
        seen.add(startNode);


        while (!stack.empty()) {
            int vertax = stack.pop();
            int[] nodes = graph.get(vertax);//找到该节点的邻节点
            if (nodes.length != 0) {
                for (int i = 0; i < nodes.length; i++) {
                    if (!seen.contains(nodes[i])) {//如果当前节点还没有被添加过
                        stack.push(nodes[i]);//将邻节点放入栈中
                        seen.add(nodes[i]);//同时将已在栈中的节点存储作为已经搜寻过的标记
                    }
                }
            }
            depth++;
        }

        return depth;
    }

    public static int maxCommon(int m,int n){
        if(m < n){
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0){
            int temp = m % n;
            m = n;
            n = temp;
        }

        return n;
    }
}
