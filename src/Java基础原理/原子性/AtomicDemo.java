package Java基础原理.原子性;

import java.util.concurrent.CountDownLatch;

public class AtomicDemo {
    public static CountDownLatch latch;
    public static int  i = 0;

    public static void increase(){
        //延迟一毫秒，增加线程切换的随机性
        try{
            Thread.sleep(1);
        }catch (Exception e){

        }

        i++;

    }

    public static void multiThread(int threadCnt){
        latch = new CountDownLatch(threadCnt);

        for (int j = 0; j < threadCnt; j++) {
            new Thread((new Runnable() {
                @Override
                public void run() {
                    AtomicDemo.increase();
                    latch.countDown();
                }
            })).start();
        }

        try{
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        int threadCnt = 1000;
        int times = 100;


        System.out.println(threadCnt + "个并发线程计算i++");

        //运行多次观察不同
        for (int x = 0; x < times; x++) {
            //初始化变量
            i= 0;
            //同时启动1000个线程，并发计算i++;
            multiThread(threadCnt);
            System.out.println("运行第" + (x+1 < 10 ? "0":"") + (x+1) + "次的结果: i=" + AtomicDemo.i);
        }

    }



}
