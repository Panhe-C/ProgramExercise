package 框架一些特性demo原理展示.AOP代理.代理模式_pattern;

public class proxy implements Subject {
    private RealSubject realSubject;

    public proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("before");
        try {
            this.realSubject.request();
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw e;//代理不会改变真正的方法
        }finally {
            System.out.println("after..");
        }
    }

    @Override
    public void hello() {
        realSubject.hello();//Subject接口新增一个方法，则要再委托一次
    }
}
