package 笔试.大疆笔试_2019_08_06;

import java.util.Scanner;

public class three {


    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int money = scanner.nextInt();
        int kinds = scanner.nextInt();
        int[] price = new int[kinds];
        for (int i = 0; i < kinds; i++) {
            price[i] = scanner.nextInt();
        }

        int likeKinds = scanner.nextInt();

        int[] likeDegree = new int[likeKinds];
        for (int i = 0; i < likeKinds; i++) {
            likeDegree[i] = scanner.nextInt()-1;
        }

        ways(price,likeDegree,money,0,money%(price[likeDegree[0]]));
        System.out.println(count);

    }

    public static void ways(int[] prices,int[] likeDegree,int money,int index,int num){
        if(money == 0){
            count++;
            return;
        }
        while(money > prices[likeDegree[index]] * num && num >0 && index <= prices.length-1){
            ways(prices,likeDegree,money-prices[likeDegree[index]]*num,likeDegree[index+1],num-1);
        }
        return;
    }


}
