package 笔试.大疆笔试_卢;

import java.util.*;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int category = scanner.nextInt();

        int money = scanner.nextInt();

        ArrayList<Integer[]> list = new ArrayList<>();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < category; i++) {
            int[] food = new int[3];
            food[0]=scanner.nextInt();
            food[1]=scanner.nextInt();
            food[2]=scanner.nextInt();
            map.put(i,food);
        }

        for (int i = 0; i < category; i++) {
            System.out.println(Arrays.toString(map.get(i)));
        }

        int moneySpend = 0;
        while(moneySpend<=money){
            int index = 0;
            int satis = 0;

            int[] price = new int[category];
            int[] satisfy = new int[category];
            int[] num = new int[category];

            for (int i = 0; i < category; i++) {
                price[i] = map.get(i)[0];
                satisfy[i] = map.get(i)[1];
                num[i] = map.get(i)[2];
            }

//            satis

            int n1 = map.get(index)[0]*map.get(index)[2]>money ? money%map.get(index)[0] : map.get(index)[2];




        }


    }
}
