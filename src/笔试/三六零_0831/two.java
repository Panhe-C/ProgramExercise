package 笔试.三六零_0831;

import java.util.Scanner;


/*
10 3
5
2
6
*
* */
public class two {

//    private static final int INDEX = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int len = s.nextInt();
        int Dnum = s.nextInt();
        int[] dist = new int[Dnum];
        for (int i = 0; i < Dnum; i++) {
            dist[i] = s.nextInt();
        }

        sol(dist,len,0,0);



    }

    public static void sol(int[] dist,int len,int tem,int index){
        if(tem < 0 || tem > len || index >= dist.length-1){
            return;
        }

        sol(dist,len,tem+dist[index],index++);
        System.out.println(tem);
        sol(dist,len,tem+dist[index],index++);
//        System.out.println(tem);

    }
}
