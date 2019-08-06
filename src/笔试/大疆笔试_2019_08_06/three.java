package 笔试.大疆笔试_2019_08_06;

import java.util.Scanner;

/*
*   W对零食的喜爱程度排序，比如对于零食A和零食B，W对A的喜爱程度大于对零食B的喜爱，那么每次拿零食的时候，一定会确保A的数量比B多。
* 现在零食间有N中零食，假设每种零食都是取不完的，但W每次都会刚好花完所有的开销，那么W去取零食的时候应该有多少种可能的取法？
*
*
* 输入：
*   第一行：买零食的开销V（v<100）和所有的零食种类数目N（N<200）
*   第二行：第i个正整数表示第i种零食的价格
*   第三行：特别喜欢的零食的种类数
*   第四行：按照对M种零食的喜爱程度从高到底排序，第i种零食的喜爱程度会大于第i+1种，保证不会形成环
*
* 输出：   输出一个整数ans，表示在满足W的特殊偏好的情况下，把并且花光所有开销，有多少种可能方案。
*
* 输入：
*   5 2
*   1 2
*   2
*   2 1
* 输出：
*   1
*
* */




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

        ways(price,likeDegree,money,0, (int) Math.floor(money/(price[likeDegree[0]])));
        System.out.println(count);

    }

    public static void ways(int[] prices,int[] likeDegree,int money,int index,int num){
        if(money == 0){
            count++;
            return;
        }
        while(money > prices[likeDegree[index]] * num && num >0 && index <= prices.length-1){
            ways(prices,likeDegree,money-prices[likeDegree[index]]*num,index+1,num-1);
        }
        return;
    }


}
