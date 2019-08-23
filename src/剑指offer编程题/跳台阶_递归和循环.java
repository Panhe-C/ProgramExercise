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


    /*
    * 非递归
    *
    *
    比较倾向于找规律的解法，f(1) = 1, f(2) = 2, f(3) = 3, f(4) = 5，  可以总结出f(n) = f(n-1) + f(n-2)的规律，但是为什么会出现这样的规律呢？
* 假设现在6个台阶，我们可以从第5跳一步到6，这样的话有多少种方案跳到5就有多少种方案跳到6，另外我们也可以从4跳两步跳到6，跳到4有多少种方案的话，
* 就有多少种方案跳到6，其他的不能从3跳到6什么的啦，所以最后就是f(6) = f(5) + f(4)；这样子也很好理解变态跳台阶的问题了。
*
*
*
    * */
    public static int JumpFloor1(int target){
        int a = 1;
        int b = 2;
        int result = 0;
        if(target == 1 || target == 2){
            return target;
        }

        for (int i = 2; i < target; i++) {
            result = a + b;
            a = b;
            b = result;
        }

        return result;
    }


    public static int JumpFloor2(int target){
        if(target == 1 || target == 2){
            return target;
        }

        //第一阶和第二阶考虑过滤，初始当前台阶为第三阶，向后迭代
        //思路：当前台阶的跳法总数=当前台阶后退一阶的台阶的跳法总数+当前台阶后退二阶的台阶的跳法总数
        int jumpsum = 0;//当前台阶的跳法总数
        int jumpSumBackStep1 = 2;//当前台阶后退一阶的台阶的跳法总数
        int jumpSumBackStep2 = 1;//当前台阶后退二阶的台阶的跳法总数

        for (int i = 3; i <= target; i++) {
            jumpsum = jumpSumBackStep1 + jumpSumBackStep2;
            jumpSumBackStep2 = jumpSumBackStep1;//后退一阶在下一次迭代标为后退两阶
            jumpSumBackStep1 = jumpsum;//当前台阶在下一次迭代变为后退一阶
        }
        return jumpsum;

    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(41));
    }

}
