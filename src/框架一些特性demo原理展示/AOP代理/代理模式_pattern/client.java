package 框架一些特性demo原理展示.AOP代理.代理模式_pattern;


public class client {

    public static void main(String[] args) {
        Subject subject = new proxy(new RealSubject());//代理实现类其实是委托给目标类来执行的，代理对象做一些边缘的操作
        subject.request();
    }
}
