package 笔试.网易2020提前批笔试;

import java.util.Scanner;

public class two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int num = scanner.nextInt();

        int[] array = new int[num];
        Scanner scanner1 = new Scanner(System.in);
        scanner.nextLine();
        String[] a=scanner.nextLine().trim().split(" ");
        for (int i = 0; i < num; i++) {
            array[i] = Integer.valueOf(a[i]);
        }

        if(array[0]>(array[1]+array[num-1]) || array[num-1]>(array[0]+array[num-2])){
            System.out.println("NO");
            return;
        }

        for (int i = 1; i < num-1; i++) {
            if(array[i]>(array[i-1]+array[i+1])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
