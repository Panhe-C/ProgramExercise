package Java基础原理.多线程.实例变量与线程安全.共享数据;


/*https://juejin.im/post/5ab116875188255561411b8a*/
public class Run {
    public static void main(String[] args) {
        MyThread mythread=new MyThread();
        //下列线程都是通过mythread对象创建的
        Thread a=new Thread(mythread,"A");
        Thread b=new Thread(mythread,"B");
        Thread c=new Thread(mythread,"C");
        Thread d=new Thread(mythread,"D");
        Thread e=new Thread(mythread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();


        /*
        * 在jvm中，count--分为三步：
        *   1.取得count的值
        *   2.计算i-1
        *   3.对i进行复制
        *
        *
        * */
    }

    //解决方法：在run方法前加上synchronized关键字即可得到正确答案。
}
