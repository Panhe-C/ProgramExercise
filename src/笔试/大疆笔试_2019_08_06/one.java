package 笔试.大疆笔试_2019_08_06;


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
            System.out.println(maxValue);

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



}
