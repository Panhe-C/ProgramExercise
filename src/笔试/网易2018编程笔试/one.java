package 笔试.网易2018编程笔试;

import java.util.Scanner;


/*
*
* 小易准备去魔法王国采购魔法神器,购买魔法神器需要使用魔法币,但是小易现在一枚魔法币都没有,但是小易有两台魔法机器可以通过投入x(x可以为0)个魔法币产生更多的魔法币。
魔法机器1:如果投入x个魔法币,魔法机器会将其变为2x+1个魔法币
魔法机器2:如果投入x个魔法币,魔法机器会将其变为2x+2个魔法币
小易采购魔法神器总共需要n个魔法币,所以小易只能通过两台魔法机器产生恰好n个魔法币,小易需要你帮他设计一个投入方案使他最后恰好拥有n个魔法币。
*
*
*
* */



public class one {

    /*
    * 解题思路：
    *   机器1只能产生奇数，机器2只能产生偶数
    *
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coins = scanner.nextInt();
        StringBuffer s = new StringBuffer();

        while (coins != 0){

            if(coins%2==0){
                coins = (coins-2)/2;
                s.append(2);
            }else {
                coins = (coins-1)/2;
                s.append(1);
            }
        }

        System.out.println(s.reverse().toString());

    }



//    static StringBuffer str=new StringBuffer();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//
//        if(n==1){
//            System.out.println(1);
//            return;
//        }else if(n==2){
//            System.out.println(2);
//            return;
//        }
//
//        int sum = 0;
//        findWay(str,n,sum,1);
//        for (int i = 1; i < str.length()-1; i++) {
//            System.out.println(str.toString().charAt(i));
//        }
//    }
//
//    public static void findWay(StringBuffer str,int n,int sum,int way){
//        str.append(way);
//        if(sum>n){
//            str.deleteCharAt(str.length()-1);
//            if (way==1){
//                sum=(sum-1)/2;
//            }else if(way == 2){
//                sum = (sum-2)/2;
//            }
//            return;
//        }else if(sum == n){
//            return;
//        }
//
//
//        findWay(str,n,sum*2+1,1);
//        findWay(str,n,sum*2+2,2);
//    }



}
