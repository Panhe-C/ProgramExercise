package 拼多多笔试;

import java.util.Scanner;

public class four1 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] c = s.split("\\s");
        int[] a = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            a[i] = Integer.parseInt(c[i]);
        }

        String s1 = sc.nextLine();
        String[] c1 = s1.split("\\s");
        int[] b = new int[c1.length];
        for (int i = 0; i < c1.length; i++) {
            b[i] = Integer.parseInt(c1[i]);
        }
        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if(a[i] <= a[i-1]){
                index=i;
            }
        }

        int num = -1;
        for (int j = 0; j < b.length; j++) {
            if(index < a.length-1) {
                if (b[j] > a[index - 1] && b[j] < a[index + 1]) {
                        num = b[j];
                }
            }else if(index == a.length-1){
                if(b[j] > a[index-1]){
                    num = b[j];
                }
            }
            else{
                System.out.println("NO");
                return;
            }
        }
        if(num > 0) {
            a[index] = num;
            for (int i = 0; i < a.length; i++) {
                System.out.println(a[i]);
            }
        }else{
            System.out.println("No");
        }
    }
}
