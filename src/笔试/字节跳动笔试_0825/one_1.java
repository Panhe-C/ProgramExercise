package 笔试.字节跳动笔试_0825;

import java.util.*;

public class one_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[][] times = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                times[i][j] = s.nextInt();
            }
        }


        int result = 0;

        Map<Integer,int[]> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if(times[i][j] >= 3){
                    list.add(j);
                }
            }


            if(list!=null) {
                int[] a = new int[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    a[j] = list.get(j);
                }
                map.put(i,a);
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(times[i][j]==0) count++;
            }
            if (count == 3) result++;
        }

        if (map.size()==1){
            System.out.println(++result);
            return;
        }

        List<Integer> list =new LinkedList<>();
        for (int key : map.keySet()) {
            list.add(DepthFirstSearch(map,key));
        }

        int paths = 0;
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i+1) != list.get(i)){
                paths++;
            }
        }

        System.out.println(result+paths+1);


    }


    public static int DepthFirstSearch(Map<Integer, int[]> graph, int startNode) {

        int depth = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        List<Integer> seen = new ArrayList<>();
        seen.add(startNode);

        List<Integer> path = new LinkedList<>();

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
}
