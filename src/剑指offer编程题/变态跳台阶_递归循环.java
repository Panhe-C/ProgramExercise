package 剑指offer编程题;

/*
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
* */

public class 变态跳台阶_递归循环 {


    /*
    * 解题思路：
    * 假如第一次跳1阶/2阶/3阶...n...对应剩下的方法数为：f(n-1),f(n-2),f(n-3)...f(1),跳一阶
    *
    * 所以台阶为n时，f(n) = 1 + f(1) + f(2)+ f(3)+ f(4)+...+f(n-2)+f(n-1)
    * f(n-1) = 1 + f(1) + f(2)+ f(3)+ f(4)+...+f(n-2)
    *
    * 所以f(n) = f(n-1) + f(n-1) = 2 * f(n - 1)
    *
    * */

    public int JumpFloorII(int target) {
        if(target == 1){
            return 1;
        }

        if(target == 2){
            return 2;
        }
        return 2*JumpFloorII(target-1);
    }
}
