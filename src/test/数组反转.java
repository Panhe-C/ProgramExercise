package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 数组反转 {
    public static void main(String[] args) {
        int[] arr = {3,6,7,14,8,34,7,3,8,0};
//        List<int> ints = Arrays.asList(arr);

        Collections.reverse(Arrays.asList(arr));
        System.out.println();
    }
}
