package 剑指offer编程题;

/*
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
* 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
* */

public class 跳台阶_递归和循环 {


    /*
    * 解题思路：只给了一次 1台阶或2台阶的跳法
    * 如果第一次跳1台阶，剩下的跳法为f(n-1);
    * 如果第二次跳2台阶，剩下的跳法为f(n-2)
    *
    * 所以总方法数：f(n) = f(n-1) + f(n-2)
    * */

    public static int JumpFloor(int target) {
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return JumpFloor(target-1) + JumpFloor(target-2);
    }

    public static int JumpFloor1(int target){
        int a = 1;
        int b = 2;
        int result = 0;
        if(target == 1){
            return a;
        }
        if(target == 2){return b;}

        for (int i = 2; i < target; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(41));
    }

}
