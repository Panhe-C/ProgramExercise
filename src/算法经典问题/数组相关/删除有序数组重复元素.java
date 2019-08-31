package 算法经典问题.数组相关;

import java.util.Arrays;

public class 删除有序数组重复元素 {

    /*
    * 采用双指针的方式https://segmentfault.com/a/1190000018348934
    * */
    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4,5,6};

        int i = 0;
        int j = 1;

        while (j < arr.length){

            if(arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
            j++;
        }

        int[] result = new int[i+1];
        for (int k = 0; k < i+1; k++) {
            result[k] = arr[k];
        }

        System.out.println(Arrays.toString(result));
    }
}
