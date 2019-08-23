package 笔试.贝壳_0823;



/*
5 10
3 9 5 7 6

* */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class one {

    private static List<Integer>  num = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int S = scanner.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        rec_opt(prices,n-1,S,0);
        Arrays.sort(num.toArray());
        System.out.println(num.get(num.size()-1));

    }

    public static void rec_opt(int[] prices, int index, int money, int count){

        if(index == 0 || money<=0){
            num.add(count);
            return;
        }

        if(prices[index] > money){
            rec_opt(prices,index-1,money,count);
        }
        rec_opt(prices,index-1,money,count);
        rec_opt(prices,index-1,money-prices[index],count+=1);

//
//        return count+1;
    }

}
