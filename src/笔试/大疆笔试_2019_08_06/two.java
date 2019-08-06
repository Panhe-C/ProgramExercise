package 笔试.大疆笔试_2019_08_06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            int cmdNum = scanner.nextInt();
            int testNum = scanner.nextInt();
            scanner.nextLine();
            Map<String,String> map = new HashMap<>();

            for (int i = 0; i < cmdNum; i++) {
                String[] s=scanner.nextLine().trim().split(" ");
                map.put(s[0],s[1]);
            }

            String[] test = new String[testNum];
            for (int i = 0; i < testNum; i++) {
                test[i] = scanner.nextLine();
            }


            for (int i = 0; i < testNum; i++) {
                System.out.println(map.get(test[i]));
            }

        }
    }
}
