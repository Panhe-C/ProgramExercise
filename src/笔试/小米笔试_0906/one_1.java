package 笔试.小米笔试_0906;


/*
*
*
2
500
1
1000
* */

import java.util.Scanner;

public class one_1 {
    static int solution(int[] prices, int budget) {
        int[] min = new int[budget+1];
        for (int i = 0; i < budget + 1; i++)
            min[i] = 100;
        min[0] = 0;


        for (int i = 0; i < budget + 1; i++) {
            for (int j = 1; j < prices.length; j++) {
                if(prices[j] <=i && min[i-prices[j]]+1 < min[i]){
                    min[i] = min[i-prices[j]] +1;
                }
            }
        }

        return min[budget];

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(res);

    }
}
