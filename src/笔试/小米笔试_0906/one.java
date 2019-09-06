package 笔试.小米笔试_0906;


/*
*
*
2
500
1
1000
* */

import java.util.Arrays;
import java.util.Scanner;

public class one {
    static int solution(int[] prices, int budget) {
        int num = 0;
        Arrays.sort(prices);

        for (int i = prices.length-1; i >=0 ; i--) {
            if(budget >=0 ){
                num += budget/prices[i];
                budget = budget % prices[i];
            }
        }

        return num == 0 ? -1 : num;
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
        System.out.println(String.valueOf(res));

    }
}
