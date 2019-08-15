package 框架一些特性demo原理展示.AOP代理.dynamic;

import 框架一些特性demo原理展示.AOP代理.代理模式_pattern.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxySubject implements InvocationHandler {
    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行动态代理逻辑
        System.out.println("before");

        Object result = null;

        try{
            //基于方法的反射
            result = method.invoke(realSubject,args);//通过反射调用目标的方法
        }catch (Exception e){
            System.out.println("ex:" + e.getLocalizedMessage());
            throw e;
        }finally {
            System.out.println("after");
        }
        return result;
    }
}
