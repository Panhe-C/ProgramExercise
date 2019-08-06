package 笔试.网易2020提前批笔试;


import java.util.Scanner;

public class one {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int n = scanner.nextInt();//班级人数

        scanner.nextLine();

        String[] s = scanner.nextLine().trim().split(" ");
        int[] grades = new int[s.length];//分数
        for (int i = 0; i < s.length; i++) {
            grades[i] = Integer.valueOf(s[i]);
        }

        int times = scanner.nextInt();//询问次数

        int[] which = new int[times];
        for (int i = 0; i < times; i++) {
            which[i] = scanner.nextInt();
        }

        for (int j = 0; j < times; j++) {
            int count = 0;
            int index = which[j] - 1;
            for (int k = 0; k < n; k++) {
                if (grades[k] <= grades[index]) {
                    count++;
                }
            }

            double result = (double) (count - 1) * 100 / (double) n;
            System.out.printf("%.6f", result);
            System.out.println();
        }
    }
}
