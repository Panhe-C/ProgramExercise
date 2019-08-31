package Java基础原理.多线程.实例变量与线程安全.不共享数据;

public class MyThread extends Thread {
    private int count = 5 ;

    public MyThread(String name){
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();

        while (count > 0){
            count--;
            System.out.println("由 " + MyThread.currentThread().getName()
                    + " 计算，count=" + count);
        }
    }
}
