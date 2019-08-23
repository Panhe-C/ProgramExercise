package 笔试.英语流利说_0819;

import java.util.Scanner;


/*
* 输入第一行：列车到达时刻表
* 第二行：列车出发时刻表
* 最少需要几个站台
*
* 输入：
*   800 900 1000 1300
    830 1200 1200 1500
* 输出：
*   2
* */

public class one {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] a=scan.nextLine().trim().split(" ");
        String[] b=scan.nextLine().trim().split(" ");
        int m=a.length;
        int n=b.length;
        int[] A=new int[m];//到达时间
        int[] B=new int[n];//出发时间
        for(int i=0;i<m;i++){
            A[i]=Integer.valueOf(a[i]);
        }
        for(int i=0;i<n;i++){
            B[i]=Integer.valueOf(b[i]);
        }



        int startTime = A[0];
        int endTime = A[A.length-1];
        int max = 0;
        for (int i = startTime; i < endTime; i++) {//从最开始到达的时刻到最后一个到达的时刻，循环分钟数
            int count = 0;
            for (int j = 0; j < A.length; j++) {//循环判断该时刻在几个 到达-出发 的时间段里
                if(i>=A[j] && i<=B[j]){
                    count++;
                }
            }
            if(count > max)
                max = count;
        }
        System.out.println(max);

    }

}
