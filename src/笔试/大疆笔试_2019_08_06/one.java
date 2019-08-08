package 笔试.大疆笔试_2019_08_06;


/*
* 小J热爱玩游戏，每个游戏有一个成就值，同时完成一个游戏需要一定时间，
* 他只有X天时间，每个游戏一旦开始玩，至少玩一天才能停下，那么在，他所玩完的游戏的成就值之和最大能达到多少？
*
*
*
* 输入：
*   第一行输入case数。
*   对于每个case，第一行输入游戏的数目N，总时间X用空格分隔。
*   从第二行但第N+1行每行输入游戏的成就值Ai，所需要花费的时间Bi
*
*   2
*   2 2
*   10 1
*   20 2
*   3 4
*   10 2
*   18 3
* */



import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int kinds = scanner.nextInt();
            int allTime = scanner.nextInt();

            int[] values = new int[kinds];
            int[] time = new int[kinds];
            for (int j = 0; j < kinds; j++) {
                values[j] = scanner.nextInt();
                time[j] = scanner.nextInt();
            }
            int maxValue = caculMaxValue(values,time,allTime);
            int maxValue1 = cacuMaxValue(time,values,allTime);
            System.out.println(maxValue);
            System.out.println(maxValue1);
        }
    }

    private static int caculMaxValue(int[] v, int[] t, int allTime) {
        int[][] b = new int[v.length+1][allTime+1];

        int[] values = new int[v.length+1];
        values[0] = 0;
        for (int i = 0; i < v.length; i++) {
            values[i+1] = v[i];
        }

        int[] time = new int[t.length+1];
        time[0] = 0;
        for (int i = 0; i <t.length; i++) {
            time[i+1] = t[i];
        }



        for (int k = 1; k < v.length+1; k++) {
            for (int c=1;c<allTime+1;c++){
                if(time[k] > c){
                    b[k][c] = b[k-1][c];
                }else{
                    int value1 = b[k-1][c-time[k]] + values[k];
                    int value2 = b[k-1][c];
                    if(value1 > value2){
                        b[k][c] = value1;
                    }else b[k][c] = value2;
                }
            }
        }

        return b[values.length-1][allTime];
    }

    public static int cacuMaxValue(int[] time,int[] value,int allTime){
        //构建数组记录中间状态
        int row = time.length+1;
        int col = allTime+1;
        int[][] state = new int[row][col];

        for (int i = 0; i < row; i++) {
            state[i][0] = 0;
        }
        for (int i = 0; i < col; i++) {
            state[0][i] = 0;
        }

        for (int i = 1; i < row; i++) {
            for (int resTime = 1; resTime < col; resTime++) {
                if(time[i-1] > resTime){
                    state[i][resTime] = state[i-1][resTime];
                }else {
                    int value1 = state[i-1][resTime - time[i-1]] + value[i-1];
                    int value2 = state[i-1][resTime];
                    if(value1 > value2){
                        state[i][resTime] = value1;
                    }else state[i][resTime] = value2;
                }
            }
        }

        return state[row-1][col-1];
    }



}
