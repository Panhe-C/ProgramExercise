package Java基础原理.设计模式.单例模式;


/*双重校验锁实现对象单例（线程安全）*/

public class Singleton {

    private volatile static Singleton uniqueInstance;
    //使用volatile修饰防止指令重排

    private Singleton(){}

    public static Singleton getUniqueInstance(){
        //先判断对象是否已被实例过，没有实例化过才进入加锁代码
        if(uniqueInstance == null){
            //类对象加锁
            synchronized (Singleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
