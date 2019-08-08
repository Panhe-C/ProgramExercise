package 排序;

import java.util.Arrays;

public class 快速排序 {

    public static void main(String[] args) {
        int[] arr = {4,5,3,8,4};
//        int[] arr = {3,1,5,2,4};
        System.out.println(Arrays.toString(quickSort(arr,0,arr.length-1)));


        Arrays.sort(arr);



    }

    public static int[] quickSort(int[] array,int l,int r) {
        int i = l;
        int j = r;

        int privot = array[(l+r)/2];
//        int privot = array[(int) (l + Math.random() * (r - l + 1))];

        while (i <= j) {
            while (array[i] < privot) {//如果pivot左边某一个数大于pivot则i停止
                i++;
            }
            while (array[j] > privot) {//如果pivot右边某一个数小于pivot则i停止
                j--;
            }

            if(i <= j) {//两数交换位置
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                //交换之后i右移一位，j左移一位
                i++;
                j--;
            }
        }

        //四个下标的位置   l   j i   r
        if(l < j){//递归的出口
            quickSort(array,l,j);
        }
        if(i < r){//递归的出口
            quickSort(array,i,r);
        }
        return array;
    }
}
