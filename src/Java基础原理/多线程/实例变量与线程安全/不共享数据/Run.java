package Java基础原理.多线程.实例变量与线程安全.不共享数据;

public class Run {
    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");

        //每个线程都有自己的一个实例变量count
        a.start();
        b.start();
        c.start();
    }
}
