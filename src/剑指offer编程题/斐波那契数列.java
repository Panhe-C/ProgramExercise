package 剑指offer编程题;

/*
*现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
*
* 斐波那契数列：F0=0；F1=1；Fn=Fn-1 + Fn-2  (n>=2)
* */

public class 斐波那契数列 {

    static int i = 0;
    static int j = 0;


    //使用递归,复杂度高，容易造成栈溢出;归非常耗费内存，因为需要同时保存成千上百个调用记录，很容易发生"栈溢出"错误（stack overflow）
    public static int Fibonacci(int n) {
        i++;
        System.out.println("运行"+ i + "次");

        if(n < 2){
            return n == 0 ? 0 : 1;
        }else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }


    }


    public static int Fibonacci1(int n){

        j++;
        System.out.println("运行"+ j + "次");

        int one = 0;
        int two = 1;
        int time = 0;
        if(n <= 0) return one;
        if(n == 1) return two;
        int result = 0;
        for(int i = 2; i <= n; i++){
            result = one + two;
            one = two;
            two = result;

            time++;
        }
        System.out.println("for循环次数" + time);
        return result;

    }


    /*
    * 尾递归：函数调用自身，称为递归。如果尾调用自身，就称为尾递归
    * 递归：递出去，由归回来；下一个函数结束以后此函数还有后续，必须保存本身的环境以处理返回值
    * 尾递归：递出去，不归回来；进入下一个函数不在需要上一个函数的环境了，得出结果后直接返回
    *
    *
    * 阶乘：
    * 递归：
    *   6 * fact(5)
        6 * (5 * fact(4))
        6 * (5 * (4 * fact(3))))
//          two thousand years later...
        6 * (5 * (4 * (3 * (2 * (1 * 1)))))) // <= 最终的展开
    *递归展开时候会产生大量的中间缓存
    *
    * 尾递归：
    *   f(5,1)
    *   f(4,5)
    *   f(3,20)
    *   f(2,60)
    *   f(1,120) = 120
    *
    *
    * https://zhuanlan.zhihu.com/p/36587160
    *
    * */


    //非尾递归，计算阶乘
    public static int factorial1(int n){
        j++;
        System.out.println("运行次数：" + j);

        if(n == 1){
            return 1;
        }else {
            return n * factorial1(n-1);
        }
    }

    //尾递归
    public static int factorial(int n,int total){
        i++;
        System.out.println(i);
        if(n == 1){
            return total;
        }
        else {
            return factorial(n-1,n * total);
        }
    }

    public static void main(String[] args) {
//        System.out.println(Fibonacci(19));
//        System.out.println(Fibonacci1(19));
        System.out.println(factorial(20,1));
        System.out.println(factorial1(20));
    }
}
