package 笔试.拼多多笔试;

import java.util.Scanner;

public class one {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] c = s.split("\\s");
        int[] a = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            a[i] = Integer.parseInt(c[i]);
        }

        int[] b = {2,1,3,8,9};


        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i]>=a[i+1]){
                index = i;
                break;
            }
        }

        for (int j = 0; j < b.length; j++) {
            if(index < a.length-2) {
                if (b[j] > a[index] && b[j] < a[index + 2]) {
                    a[index + 1] = b[j];
                }
            }else if(index == a.length-2){
                if(b[j] > a[index]){
                    a[index+1] = b[j];
                }
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        int[] result = new int[a.length];
        for (int k = 0; k < result.length; k++) {
            result[k] = a[k];
        }
    }
}
