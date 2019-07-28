package 拼多多笔试;


/*
* 给定两个数组A和B。其中数组A是几乎严格升序排列的，几乎的定义是只需改变其中一个数，即可满足完全升序排列。
*
* 你的任务是从数组A中找到这个数字，并从数组B中选取一个数将其替换，使得数组A是完全严格升序排列的。（不允许相邻两个为相同的数）
* 请找出数组B中满足要求的最大数字，并输出最终有序的数组，如果不存在就输出NO
*
*
* 输入描述：
*   共两行，第一行是数组A，第二行是数组B，元素之间用空格分隔。（长度都<100）
*
* 输出描述：
*   共一行，为最终有序的数组。不存在则输出No
*
* 示例：
*   1 3 7 4 10
*   2 1 5 8 9
* 输出：
*   1 3 7 9 10
*
*
* */

import java.util.Arrays;
import java.util.Scanner;

public class 第一题 {

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String[] a=scan.nextLine().trim().split(" ");
        String[] b=scan.nextLine().trim().split(" ");
        int m=a.length;
        int n=b.length;
        int[] A=new int[m];
        int[] B=new int[n];
        for(int i=0;i<m;i++){
            A[i]=Integer.valueOf(a[i]);
        }
        for(int i=0;i<n;i++){
            B[i]=Integer.valueOf(b[i]);
        }



        int pos=-1;
        for(int i=0;i<m-1;i++){
            if(A[i]>=A[i+1]){
                pos=i;
                break;
            }
        }


        Arrays.sort(B);
        int temp=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            if(B[i]<A[pos+1]){
                if(pos==0) {
                    temp=B[i];
                    A[pos]=temp;
                    break;
                }
                if(pos>0&&B[i]>A[pos-1]){
                    temp=B[i];
                    A[pos]=temp;
                    break;
                }
            }
            if(B[i]>A[pos]){
                if(pos+2==m){
                    temp=B[i];
                    A[pos+1]=temp;
                    break;
                }
                if(pos+2<m&&B[i]<A[pos+2]){
                    temp=B[i];
                    A[pos+1]=temp;
                    break;
                }
            }
        }
        if(temp==Integer.MIN_VALUE){
            System.out.println("NO");
            return ;
        }
        for(int i=0;i<m-1;i++){
            System.out.print(A[i]+" ");
        }
        System.out.print(A[m-1]);
    }

}
