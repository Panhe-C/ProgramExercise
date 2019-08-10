package 笔试.网易2018编程笔试;


/*
* 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
牛博士给小易出了一个难题:
对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
*
*
* 输入描述：
*   输入的第一行为数列的个数t(1 ≤ t ≤ 10),
    接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
    第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
*输出:
*   对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
*
* 输入：
*   2
    3
    1 10 100
    4
    1 2 3 4
  输出：
  *   Yes
      No
*
* */

import java.util.Scanner;

public class five {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrayNum = scanner.nextInt();
        for (int i = 0; i < arrayNum; i++) {
            int arrayLength = scanner.nextInt();
            int[] array = new int[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                array[j] = scanner.nextInt();
            }

            if(arrayLength == 0) System.out.println("NO");
            if(arrayLength == 1){
                if(array[0]%4 == 0){
                    System.out.println("YES");
                }else System.out.println("NO");
            }


            if(solve(array,0,arrayLength-1)){
                System.out.println("YES");
            }else System.out.println("NO");
        }

    }


    public static boolean solve(int[] array,int start,int end){
        int length = array.length;

        if(start == end){return true;}

        int first = array[start];
        for (int i = start+1; i < length; i++) {
            if(first * array[i] % 4 == 0){
                swap(array,start+1,i);
                solve(array,start+1,end);
                break;
            }
        }
        return array[end-1]*array[end]%4 == 0;
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}



class solution{


    public static void  main(String[] args){
        Scanner in = new Scanner(System.in);
        //ArrayList<String> list = new ArrayList<String>();
        while(in.hasNext()){
            int t = in.nextInt();
            for(int i = 0;i<t;i++){
                int n = in.nextInt();
                int a[] = new int[n];
                for(int j = 0;j<n;j++){
                    a[j] = in.nextInt();
                }
                int mod4_num=0 , mod2_num=0,odd=0;
                for(int k = 0;k<a.length;k++){
                    if(a[k] % 4 ==0){
                        mod4_num++;
                    }else if(a[k] % 2 ==0){
                        mod2_num++;
                    }else{
                        odd++;
                    }
                }
                if(mod2_num > 0){
                    if(mod4_num >= odd){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }else{
                    if(mod4_num >=(odd-1)){
                        System.out.println("Yes");
                    }else{
                        System.out.println("No");
                    }
                }
            }
        }

    }
}
