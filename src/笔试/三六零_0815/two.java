package 笔试.三六零_0815;


/*
*
* 输入：
*   5 5
    4 4 1 1 1
    4 3 0 1 2
  输出：
    4 4 3 3 2

* */

import java.util.Arrays;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] num1 = new int[n];
        int[] num2 = new int[n];

        for (int i = 0; i < n; i++) {
            num1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            num2[i] = scanner.nextInt();
        }


        int[] result = new int[n];


        int index = 0;
        int[] newArr = num2;
        for (int i = 0; i < num1.length; i++) {
            int sum = 0;
            for (int j = 0; j < num2.length; j++) {
                if((num1[i]+num2[j])%m >sum){
                    sum = (num1[i]+num2[j]) % m;
                    result[i] = sum;

                    index = j;
                }
            }

            if(num2.length >1){
            num2 = delete(num2,index);}


        }

        Arrays.sort(result);


        for (int i = result.length-1; i >=0 ; i--) {
            System.out.print(result[i] + " ");
        }



    }

    public static int[] delete(int[] arr,int index){
        int[] re_arr = new int[arr.length-1];
        int ind = 0;
        for (int i : arr) {
            if( i != arr[index]){
                re_arr[ind] = i;
                ind++;
            }
        }
        return re_arr;
    }
}
