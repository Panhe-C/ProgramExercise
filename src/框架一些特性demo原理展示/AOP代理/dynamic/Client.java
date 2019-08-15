package 框架一些特性demo原理展示.AOP代理.dynamic;

import 框架一些特性demo原理展示.AOP代理.代理模式_pattern.RealSubject;
import 框架一些特性demo原理展示.AOP代理.代理模式_pattern.Subject;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        Subject subject = (Subject) Proxy.newProxyInstance(Client.class.getClassLoader(),
                new Class[]{Subject.class},
                new JdkProxySubject(new RealSubject()));
        subject.request();

        //Subject接口新增一个方法，动态代理什么都不用变，这就是相对于静态代理的优势
        subject.hello();
    }
}
