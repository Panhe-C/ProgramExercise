package 算法经典问题.并查集;

public class DisjoinSetSimpler {

    private static final int VERTEXES = 6;

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1}, {1, 2}, {1, 3},
//                {2, 4}, {3, 4}, {2, 5}
                {3, 4}, {2, 5}
        };

        int[] rank = new int[VERTEXES];//记录树的深度
        int[] parent = new int[VERTEXES];
        init_arr(parent,rank);

        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];

            if(union(x,y,parent,rank) == 0) {
                System.out.println("Cycle detected!");
                return;
            }
        }
        System.out.println("No cycle found!");
    }

    public static int union(int x,int y,int[] parent,int[] rank){
        int x_root = find_root(x,parent);
        int y_root = find_root(y,parent);

        if( x_root == y_root){
            return 0;
        }else {
            if(rank[x_root] > rank[y_root]) parent[y_root] = x_root;
            else if(rank[x_root] < rank[y_root]) parent[x_root] = y_root;
            else {
                parent[x_root] = y_root;
                rank[y_root]++;
            }
            return 1;
        }
    }

    public static int find_root(int x,int[] parent){
        int x_root = x;
        if(parent[x_root] != -1){
            x_root = parent[x_root];
        }
        return x_root;
    }

    public static void init_arr(int[] parent,int[] rank){
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
            rank[i] = 0;
        }
    }
}
