package 笔试.携程笔试_0904;

/*
*
4
9 6 3 7 6 5
* */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        scanner.nextLine();
        List<Integer> list = new LinkedList<>();
        String[] s = scanner.nextLine().trim().split(" ");

        for (int i = 0; i < s.length; i++) {
            list.add(Integer.valueOf(s[i]));
        }

        List<Integer> bigger = new LinkedList<>();
        List<Integer> lower = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) < m)
                lower.add(list.get(i));
            else bigger.add(list.get(i));
        }

        for (int i = 0; i < lower.size(); i++) {
            System.out.print(lower.get(i) + ",");
        }
        for (int i = 0; i < bigger.size(); i++) {
            if(i < bigger.size()-1)
                System.out.print(bigger.get(i) + ",");
            else System.out.print(bigger.get(i));

        }
    }
}
