package 笔试.贝壳笔试_08_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;




public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }


        int diff = Math.abs(array[1]-array[0]);
        int index = 0;
        for (int i = 1; i < num-1; i++) {
            if(Math.abs(array[i+1]-array[i]) < diff){
                diff = array[i+1]-array[i];
                index=i;
            }
        }
        System.out.println(array[index] + " " + array[index+1]);
    }
}
