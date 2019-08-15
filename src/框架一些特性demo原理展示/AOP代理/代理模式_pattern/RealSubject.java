package 框架一些特性demo原理展示.AOP代理.代理模式_pattern;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject exceute request");
    }

    @Override
    public void hello() {
        System.out.println("新增一个hello方法：hello");
    }
}
