package Java基础原理.原子性;

public class VolatileDemo {
    public static void main(String[] args) {
        final int[] x = {0};
        final boolean[] bExit = {false};

        new Thread(new Runnable() {
            @Override
            public void run() {
                x[0] = 1;
                bExit[0] = true;
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                if(bExit[0] == true) System.out.println("x=" + x[0]);
            }
        }).start();

    }
}
