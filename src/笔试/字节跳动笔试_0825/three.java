package 笔试.字节跳动笔试_0825;


/*
实现4 * 4数组的2048
输入:
1
0 0 0 2
0 0 0 2
0 0 4 8
0 0 4 8

输出:
0 0 8 4
0 0 0 16
0 0 0 0
0 0 0 0

输入:
2
0 0 0 0
0 0 2 2
0 2 8 8
2 4 2 16
输出:
0 0 0 0
0 0 2 2
0 2 8 8
2 4 2 16

*
*
* */


import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int direct = s.nextInt();
        int[][] arr = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = s.nextInt();
            }
        }

        int[][] result = new int[4][4];
        switch (direct){
            case 1:
                result = up(arr);
                break;
            case 2:
                result = down(arr);
                break;
            case 3:
                result = left(arr);
                break;
            case 4:
                result = right(arr);
                break;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(j<3){
                System.out.print(result[i][j] + " ");}
                if(j==3){
                    System.out.print(result[i][j]);
                }
            }
            System.out.println();
        }

    }

    private static int[][] right(int[][] a) {
        for (int i = 0; i < 4; i++) {
            for (int j = 3; j >= 1; j--) {
                if(a[i][j] == a[i][j-1]){
                    a[i][j] +=a[i][j-1];
                    a[i][j-1] = 0;
                }
            }
        }
        return right_remove(a);
    }

    private static int[][] right_remove(int[][] a) {

        int k = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >=0 ; j--) {
                k = j;
                while (k+1 <=3 && a[i][k+1] == 0){
                    int temp = a[i][k];
                    a[i][k] = a[i][k+1];
                    a[i][k+1] = a[i][k];
                    k++;
                }
            }
        }
        return a;
    }

    private static int[][] left(int[][] arr) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if(arr[i][j] == arr[i][j+1]){
                    arr[i][j] +=arr[i][j+1];
                    arr[i][j+1]=0;

                }
            }
        }
        return left_remove(arr);
        
    }

    private static int[][] left_remove(int[][] a) {
        int k =0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                k = j;
                while (k-1 >= 0 && a[i][k-1]==0){
                    int temp = a[i][k];
                    a[i][k] = a[i][k-1];
                    a[i][k-1] = temp;
                    k--;
                }
            }
        }
        return a;
    }

    private static int[][] down(int[][] arr) {
        for (int j = 0; j < 4; j++) {
            for (int i = 3; i >=1 ; i--) {
                if(arr[i][j] == arr[i-1][j]){
                    arr[i][j] = arr[i][j] + arr[i-1][j];
                    arr[i-1][j] = 0;

                }

            }
        }
        return down_remove(arr);
    }

    private static int[][] down_remove(int[][] arr) {

        int k = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 2; i >=0 ; i--) {
                k = i;
                while(k+1<=3 && arr[k+1][j] == 0){
                    int temp = arr[k][j];
                    arr[k][j] = arr[k+1][j];
                    arr[k+1][j] = temp;
                    k++;
                }
            }
        }

        return arr;
    }

    private static int[][] up(int[][] arr) {
        for (int i = 3; i >= 1; i--) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j] == arr[i-1][j]){
                    arr[i-1][j] = 2*arr[i][j];
                    arr[i][j] = 0;
                }
            }
        }

        return up_remove_black(arr);

    }

    public static int[][] up_remove_black(int[][] arr){
        int k = 0;
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i < 4; i++) {
                k = i;
                while (k-1>=0 && arr[k-1][j] == 0){
                    int temp = arr[k][j];
                    arr[k][j] = arr[k-1][j];
                    arr[k-1][j] = temp;
                    k--;
                }
            }
        }
        return arr;
    }

    public static void swap(int a,int b){
        int temp = a;
        a = b;
        b = temp;
    }

}
