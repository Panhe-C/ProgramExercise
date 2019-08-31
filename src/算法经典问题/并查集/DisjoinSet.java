package 算法经典问题.并查集;

import java.util.Arrays;

public class DisjoinSet {

    private static final int nodes = 6;

    public static void main(String[] args) {

        int[][] edges = {
                {0, 1}, {1, 2}, {1, 3},
                {2, 4}, {3, 4}, {2, 5}
//                {3, 4}, {2, 5}
        };

        int[] parent = new int[nodes];
        init_arr(parent);
//        parent[edges[0][0]] = edges[0][1];

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            if (union(x, y, parent) == 0) {//如果返回零，则说明边的两点在同一集合里，则有环
                System.out.println("Cycle detected!");
                return;
            }
        }
        System.out.println("No cycles found!");
    }

    //返回
    //1 - union successfully
    //0 - failed(合并的两个点正好在同一个集合里)
    public static int union(int x, int y, int[] parent) {
        int x_root = find_root(x, parent);
        int y_root = find_root(y, parent);

        if (x_root == y_root) return 0;
        else {
            parent[x_root] = y_root;//进行合并，将两个集合的根节点连接起来
            return 1;
        }
    }

    public static int find_root(int x, int[] parent) {
        int x_root = x;
        while (parent[x_root] != -1) {
            x_root = parent[x_root];//循环寻找根节点，但容易形成链；（0->1->2->3->4->5...->n）
        }
        return x_root;

    }


    //初始化parent数组，赋值为-1
    public static void init_arr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
    }
}
