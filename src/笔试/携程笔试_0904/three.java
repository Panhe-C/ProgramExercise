package 笔试.携程笔试_0904;

/*
3 5
1 5 3 4 2

6
* */

import java.util.Arrays;
import java.util.Scanner;

public class three {
    static int schedule(int m,int[] array) {

        //最大值
        int max= 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max)
                max = array[i];
        }

        //求和
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }


        int low = max;//桶容量最低为数组的最大值
        int high = sum;//桶容量最大为数组的和，此时桶只有一个

        while (low < high){
            int mid = (low + high)/2;
            int result = getRequiredNum(array,mid);

            if(result > m){//所需桶数量大于实际有的，需要增加容量
                low = mid + 1;
            }else high = mid;//所需桶数量小于等于实际有的，尝试减少容量

        }
        return low;
    }

    private static int getRequiredNum(int[] array, int mid) {
        int num_buc = 1;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if(sum > mid){
                sum = array[i];
                num_buc++;
            }
        }
        return num_buc;
    }


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
