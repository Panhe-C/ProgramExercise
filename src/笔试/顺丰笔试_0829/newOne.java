package 笔试.顺丰笔试_0829;

import java.util.Scanner;

public class newOne {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//
//        int people = s.nextInt();
//        int languages = s.nextInt();
//        int k = s.nextInt();
//
//        int[][] edges = new int[k][2];
//
//        for (int i = 0; i < k; i++) {
//            edges[i][0] = s.nextInt();
//            edges[i][1] = s.nextInt();
//        }

        UnionFind unionFind = new UnionFind(8);
        System.out.println(unionFind.isConnected(1, 2));
        unionFind.printId();
    }

}

