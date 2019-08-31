package 笔试.字节跳动笔试_0825;


/*并查树*/

/*

用户A和用户B互动次数不少于3次,则认为A和B为"豆油";
若A<->B,B<->C,则A和C互为"豆油".
定义豆油瓶是由直系和间接朋友所组成的群体.

给定一个N*N的矩阵M,代表抖音上所有用户的互动次数,如果M[i][j]=5;则i和j的互动过5次,为0则没有互动;
其中对于i=j,同一个用户记为0;计算并输出发现的抖音上所有豆油屏的个数

3
0 4 0
4 0 0
0 0 0
2

解释:1和2用户互动超过3次,互为豆油,第3个学生和其他人没有互动,自成一个豆油瓶

3
0 4 0
4 0 6
0 6 0
1

1和2互为豆油,2和3互为豆油,1和3互为间接豆油,所有都在同一个豆油瓶中,

*
* */

import java.util.Scanner;

public class 第一题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n= sc.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j]=sc.nextInt();
                }
            }


            int res =0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if(matrix[i][j]>=3){
                        matrix[j][j]=-1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if(matrix[i][i]!=-1){
                    res++;
                }
            }
            System.out.println(res);
        }
    }

}
